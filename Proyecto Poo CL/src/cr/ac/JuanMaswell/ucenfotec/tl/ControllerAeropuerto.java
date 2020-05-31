package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.IAeropuertoDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerAeropuerto {
    DaoFactory factory;
    IAeropuertoDao aeropuertoDao;

    public ControllerAeropuerto() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        aeropuertoDao = factory.getAeropuertoDao();
    }

    public void registrarAeropuerto(String nombre, String codigoAeropuerto, String pais, String codigoPais) {
        try {
            aeropuertoDao.registrarAeropuerto(nombre, codigoAeropuerto, pais, codigoPais);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validarAeropuerto(String codigo) {
        Aeropuerto tmpAeropuerto = new Aeropuerto();
        try {
            tmpAeropuerto = aeropuertoDao.validarAeropuerto(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpAeropuerto.getCodigo();
    }

    public String[] listarNombreAeropuerto() {
        String[] nombreAeropuerto = {};
        try {
            nombreAeropuerto = aeropuertoDao.listarAeropuertoPorNombre();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreAeropuerto;
    }

    public ArrayList<Aeropuerto> listarAeropuerto() {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        try {
            aeropuertos = aeropuertoDao.listarAeropuerto();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }
}
