package cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IMiembroDao {
    public void registrarMiembro(String nombre, String apellido1, String apellido2, String correo, String genero, String constrasenia, String identificacion, String numeroLicencia, String puesto, LocalDate fechaGraduacion, String annosExperiencia, String telefono, String detalleDireccion) throws java.sql.SQLException, Exception;

    Miembro iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception;

    ArrayList<Miembro> listarMiembro() throws java.sql.SQLException, Exception;

    Miembro validarMiembro(String correo) throws java.sql.SQLException, Exception;

    public void modificarMiembro();

    public void eliminarMiembro();
}
