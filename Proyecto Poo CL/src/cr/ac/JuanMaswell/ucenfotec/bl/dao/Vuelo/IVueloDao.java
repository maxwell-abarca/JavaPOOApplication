package cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;

import java.util.ArrayList;

public interface IVueloDao {
    public void registrarVuelo(String lineaAerea, String aeropuertoOrigen, String horaLlegada, String horaSalida, String estado, String aeropuertoDestino, String sala) throws java.sql.SQLException, Exception;

    ArrayList<Vuelo> listarVuelo() throws java.sql.SQLException, Exception;

    Vuelo validarVueloRepetido(String sala) throws java.sql.SQLException, Exception;

    public void modificarVuelo();

    public void eliminarVuelo();
}
