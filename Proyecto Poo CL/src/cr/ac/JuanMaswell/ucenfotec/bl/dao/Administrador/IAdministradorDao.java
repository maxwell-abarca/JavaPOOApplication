package cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IAdministradorDao {
    public void registrarAdministrador(String nombre, String apellido1, String apellido2, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String identificacion, String detalleDireccion, String correo, String contrasenia) throws java.sql.SQLException, Exception;

    Administrador iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception;

    ArrayList<Administrador> listarAdministrador() throws java.sql.SQLException, Exception;

    Administrador validarAdministrador(String correo) throws java.sql.SQLException, Exception;

    public void eliminarAdministrador();

    public void modificarAdministrador();
}
