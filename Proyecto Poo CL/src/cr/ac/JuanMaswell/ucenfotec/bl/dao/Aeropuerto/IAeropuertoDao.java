package cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto;

import java.util.ArrayList;

public interface IAeropuertoDao {
    public void registrarAeropuerto(String nombre, String codigo, String nombrePais, String codigoPais) throws java.sql.SQLException, Exception;

    ArrayList<Aeropuerto> listarAeropuerto() throws java.sql.SQLException, Exception;

    String[] listarAeropuertoPorNombre() throws java.sql.SQLException, Exception;

    Aeropuerto validarAeropuerto(String codigoAeropuerto) throws java.sql.SQLException, Exception;

    public void modificarAeropuerto();

    public void eliminarAeropuerto();
}
