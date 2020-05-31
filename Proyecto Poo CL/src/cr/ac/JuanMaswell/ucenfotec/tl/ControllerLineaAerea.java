package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.ILineaAereaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerLineaAerea {
    ILineaAereaDao lineaAereaDao;
    DaoFactory factory;

    public ControllerLineaAerea() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        lineaAereaDao = factory.getLineaAereaDao();
    }

    public void registrarLineaAerea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuena, String nombrePais, String logo) {
        try {
            lineaAereaDao.registrarLinea(nombreComercial, cedulaJuridica, nombreEmpresaDuena, nombrePais, logo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LineaAerea> listarLineas() {
        ArrayList<LineaAerea> lineaAereas = new ArrayList<>();
        try {
            lineaAereas = lineaAereaDao.listarAerolinea();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineaAereas;
    }

    public String validarLinea(String cedulaJuridica) {
        LineaAerea tmpLinea = new LineaAerea();
        try {
            tmpLinea = lineaAereaDao.validarLinea(cedulaJuridica);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpLinea.getCedulaJuridica();
    }

    public String[] listarPorNombre() {
        String[] dataLinea = {};
        try {
            dataLinea = new String[lineaAereaDao.listarAerolinea().size()];
            int posicion = 0;
            for (LineaAerea dato : lineaAereaDao.listarAerolinea()) {
                String info = dato.getNombreComercial();
                dataLinea[posicion] = info;
                posicion++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataLinea;
    }
}

