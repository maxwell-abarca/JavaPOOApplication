package cr.ac.JuanMaswell.ucenfotec.tl;

import com.mysql.cj.xdevapi.SqlDataResult;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.Administrador;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.IAdministradorDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerAdministrador {
    IAdministradorDao administradorDao;
    DaoFactory factory;

    public ControllerAdministrador() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        administradorDao = factory.getAdministradorDao();
    }

    public void registrarAdministrador(String nombre, String apellido1, String apellido2, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String identificacion, String detalleDireccion, String correo, String contrasenia) {
        try {
            administradorDao.registrarAdministrador(nombre, apellido1, apellido2, nacionalidad, fechaNacimiento, edad, genero, identificacion, detalleDireccion, correo, contrasenia);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validarAdministrador(String correo) {
        Administrador a = new Administrador();
        try {
            a = administradorDao.validarAdministrador(correo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a.getCorreo();
    }

    public ArrayList<Administrador> listarAdministrador() {
        ArrayList<Administrador> administradores = new ArrayList<>();
        try {
            administradores = administradorDao.listarAdministrador();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administradores;
    }
}
