package cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface ILineaAereaDao {
    public void registrarLinea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuena, String nombrePais, String logo) throws java.sql.SQLException, Exception;

    ArrayList<LineaAerea> listarAerolinea() throws java.sql.SQLException, Exception;

    LineaAerea listarLineaAereaPorNombre() throws java.sql.SQLException, Exception;

    LineaAerea validarLinea(String cedulaJuridica) throws java.sql.SQLException, Exception;

    public void eliminarLinea();
}
