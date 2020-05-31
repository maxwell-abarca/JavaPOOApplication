package cr.ac.JuanMaswell.ucenfotec.tl;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.IMiembroDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.Miembro;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.factory.DaoFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerMiembro {
    DaoFactory factory;
    IMiembroDao miembroDao;

    public ControllerMiembro() {
        factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        miembroDao = factory.getMiembroDao();
    }

    public void registrarMiembro(String nombre, String apellido1, String apellido2, String correo, String genero, String constrasenia, String identificacion, String numeroLicencia, String puesto, LocalDate fechaGraduacion, String annosExperiencia, String telefono, String detalleDireccion) {
        try {
            miembroDao.registrarMiembro(nombre, apellido1, apellido2, correo, genero, constrasenia, identificacion, numeroLicencia, puesto, fechaGraduacion, annosExperiencia, telefono, detalleDireccion);
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validarMiembroRepetido(String correo) {
        Miembro tmpMiembro = new Miembro();
        try {
            tmpMiembro = miembroDao.validarMiembro(correo);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpMiembro.getCorreo();
    }

    public ArrayList<Miembro> listarMiembro() {
        ArrayList<Miembro> miembros = new ArrayList<>();
        try {
            miembros = miembroDao.listarMiembro();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miembros;
    }

}
