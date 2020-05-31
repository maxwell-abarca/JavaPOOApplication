package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.IVueloDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.Vuelo;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerVuelo {
    DaoFactory factory;
    IVueloDao vueloDao;

    public ControllerVuelo() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        vueloDao = factory.getVueloDao();
    }

    public void registrarVuelo(String lineaAerea, String aeropuertoOrigen, String horaLlegada, String horaSalida, String estado, String aeropuertoDestino, String sala) {
        try {
            vueloDao.registrarVuelo(lineaAerea, aeropuertoOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, sala);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validarVuelo(String sala) {
        Vuelo tmpVuelo = new Vuelo();
        try {
            tmpVuelo = vueloDao.validarVueloRepetido(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpVuelo.getEstado();
    }

    public ArrayList<Vuelo> listarVuelo() {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try {
            vuelos = vueloDao.listarVuelo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vuelos;
    }
}
