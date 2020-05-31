package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.Administrador;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.IAdministradorDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.IMiembroDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.Miembro;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.IUsuarioDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.Usuario;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;

public class ControllerIniciarSesion {
    DaoFactory factory;
    IUsuarioDao usuarioDao;
    IMiembroDao miembroDao;
    IAdministradorDao administradorDao;

    public ControllerIniciarSesion() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        usuarioDao = factory.getUsuarioDao();
        miembroDao = factory.getMiembroDao();
        administradorDao = factory.getAdministradorDao();
    }

    public String iniciarSesionUsuario(String correo, String contrasenia) {
        Usuario user = new Usuario();
        try {
            user = usuarioDao.iniciarSesion(correo, contrasenia);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.getCorreo();
    }

    public String iniciarSesionMiembro(String correo, String contrasenia) {
        Miembro miembro = new Miembro();
        try {
            miembro = miembroDao.iniciarSesion(correo, contrasenia);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miembro.getCorreo();
    }

    public String iniciarSesionAdministrador(String correo, String contrasenia) {
        Administrador administrador = new Administrador();
        try {
            administrador = administradorDao.iniciarSesion(correo, contrasenia);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrador.getCorreo();
    }
}
