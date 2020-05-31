package cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais;

import java.util.ArrayList;

public interface IPaisDao {
    public void registrarPais(String nombre, String abreviatura, String codigo) throws java.sql.SQLException, Exception;

    String[] listarNombrePais() throws java.sql.SQLException, Exception;

    ArrayList<Pais> listarPais() throws java.sql.SQLException, Exception;

    String buscarPaisPorNombre(String nombrePais) throws java.sql.SQLException, Exception;

    Pais validarPaisRepetido(String nombrePais, String codigoPais) throws java.sql.SQLException, Exception;

    public void modificarPais();

    public void eliminarPais();
}
