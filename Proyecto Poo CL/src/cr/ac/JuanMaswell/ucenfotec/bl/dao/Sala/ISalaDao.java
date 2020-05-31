package cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala;

import java.util.ArrayList;

public interface ISalaDao {
    public void registrarSala(String nombre, String codigo, String ubicacion) throws java.sql.SQLException, Exception;

    ArrayList<Sala> listarSala() throws java.sql.SQLException, Exception;

    String[] listarNombreSala() throws java.sql.SQLException, Exception;

    Sala validarSalaRepetida(String codigo) throws java.sql.SQLException, Exception;

    public void eliminarSala();
}
