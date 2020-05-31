package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.ITiqueteDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.Tiquete;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerTiquete {
    ITiqueteDao tiqueteDao;
    DaoFactory factory;

    public ControllerTiquete() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        tiqueteDao = factory.getTiqueteDao();
    }

    public void registrarTiquete(LocalDate fecha, String aeropuertoOrigen, String aeropuertoDestino, int numeroAsiento, double precio, int numeroDeVuelo, String tipoAsiento, double impuesto) {
        try {
            tiqueteDao.registrarTiquete(fecha, aeropuertoOrigen, aeropuertoDestino, numeroAsiento, precio, numeroDeVuelo, tipoAsiento, impuesto);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int validarTiqueteRepetido(int numero_vuelo) {
        Tiquete tmpTiquete = new Tiquete();
        try {
            tmpTiquete = tiqueteDao.validarTiquete(numero_vuelo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpTiquete.getNumeroDeVuelo();
    }

    public ArrayList<Tiquete> listarTiquete() {
        ArrayList<Tiquete> tiquetes = new ArrayList<>();
        try {
            tiquetes = tiqueteDao.listarTiquete();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiquetes;
    }
}
