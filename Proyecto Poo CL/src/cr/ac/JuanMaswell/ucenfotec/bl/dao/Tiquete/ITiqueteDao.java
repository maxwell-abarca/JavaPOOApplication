package cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ITiqueteDao {
    public void registrarTiquete(LocalDate fecha, String aeropuertoOrigen, String aeropuertoDestino, int numeroAsiento, double precio, int numeroDeVuelo, String tipoAsiento, double impuesto) throws java.sql.SQLException, Exception;

    ArrayList<Tiquete> listarTiquete() throws java.sql.SQLException, Exception;

    Tiquete validarTiquete(int numeroVuelo) throws java.sql.SQLException, Exception;

    public void modificarTiquete();

    public void eliminarTiquete();
}
