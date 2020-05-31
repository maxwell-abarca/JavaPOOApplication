package cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IUsuarioDao {
    /*este recibe los parametros que le envia el controller*/
    public void registrarUsuario(String nombre, String apellido1, String apellido2, String correo, String genero, String cedula, String provincia, String canton, String distrito, String detalleDireccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String contrasenia) throws java.sql.SQLException, Exception;

    Usuario iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception;

    ArrayList<Usuario> listarUsuario() throws java.sql.SQLException, Exception;

    Usuario validarRepetido(String correo) throws java.sql.SQLException, Exception;

    public void eliminarUsuario();

    public void modificarUsuario();
}
