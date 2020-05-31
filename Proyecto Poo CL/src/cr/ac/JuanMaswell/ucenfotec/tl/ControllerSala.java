package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.ISalaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerSala {
    DaoFactory factory;
    ISalaDao salaDao;

    public ControllerSala() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        salaDao = factory.getSalaDao();
    }

    public void registrarSala(String nombre, String codigo, String ubicacion) {
        try {
            salaDao.registrarSala(nombre, codigo, ubicacion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String validarSala(String codigo) {
        Sala tmpSala = new Sala();
        try {
            tmpSala = salaDao.validarSalaRepetida(codigo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tmpSala.getNombre();
    }

    public String[] listarNombreSala() {
        String[] nombreSala = {};
        try {
            nombreSala = salaDao.listarNombreSala();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreSala;
    }

    public ArrayList<Sala> listarSalas() {
        ArrayList<Sala> salas = new ArrayList<>();
        try {
            salas = salaDao.listarSala();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salas;
    }
}
