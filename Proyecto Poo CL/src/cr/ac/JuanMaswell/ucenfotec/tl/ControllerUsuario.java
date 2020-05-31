package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.IUsuarioDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.Usuario;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerUsuario {
    DaoFactory factory;
    IUsuarioDao usuarioDao;

    public ControllerUsuario() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        usuarioDao = factory.getUsuarioDao();
    }

    public void registrarUsuario(String nombre, String apellido1, String apellido2, String correo, String genero, String cedula, String provincia, String canton, String distrito, String detalleDireccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String contrasenia) {
        try {
            usuarioDao.registrarUsuario(nombre, apellido1, apellido2, correo, genero, cedula, provincia, canton, distrito, detalleDireccion, nacionalidad, fechaNacimiento, edad, contrasenia);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        }
    }

    public String validarRepetido(String correo) {
        Usuario tmpUsuario = new Usuario();
        try {
            tmpUsuario = usuarioDao.validarRepetido(correo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpUsuario.getCorreo();
    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = usuarioDao.listarUsuario();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
