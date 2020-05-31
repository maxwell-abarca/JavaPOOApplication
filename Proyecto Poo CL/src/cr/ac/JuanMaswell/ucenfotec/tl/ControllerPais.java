package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais.IPaisDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais.Pais;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerPais {
    DaoFactory factory;
    IPaisDao paisDao;

    public ControllerPais() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        paisDao = factory.getPaisDao();
    }


    public void registrarPais(String nombre, String abreviatura, String codigo) {
        try {
            paisDao.registrarPais(nombre, abreviatura, codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Pais> listarPais() {
        ArrayList<Pais> paises = new ArrayList<>();
        try {
            paises = paisDao.listarPais();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paises;
    }

    public String validarPaisRepetido(String nombre, String codigo) {
        Pais tmpPais = new Pais();
        try {
            tmpPais = paisDao.validarPaisRepetido(nombre, codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpPais.getCodigo();

    }

    public String[] listarNombrePais() {
        String[] nombres = {};
        try {
            nombres = paisDao.listarNombrePais();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombres;
    }

    public String buscarPaisPorNombre(String nombrePais) {
        String codigo = " ";
        try {
            codigo = paisDao.buscarPaisPorNombre(nombrePais);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigo;
    }
}
