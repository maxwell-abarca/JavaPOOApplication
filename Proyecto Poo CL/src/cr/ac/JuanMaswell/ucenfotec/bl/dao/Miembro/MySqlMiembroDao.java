package cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro;

import com.company.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlMiembroDao implements IMiembroDao {

    public void registrarMiembro(String nombre, String apellido1, String apellido2, String correo, String genero, String constrasenia, String identificacion, String numeroLicencia, String puesto, LocalDate fechaGraduacion, String annosExperiencia, String telefono, String detalleDireccion) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql;
        sql = "Insert into miembro(nombre,apellido1,apellido2,correo,genero,contrasenia,identificacion,numero_licencia,puesto,fecha_graduacion,annos_experiencia,telefono,detalle_direccion) values" +
                "('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + correo + "','" + genero + "','" + constrasenia + "','" + identificacion + "','" + numeroLicencia + "','" + puesto + "','" + fechaGraduacion + "','" + annosExperiencia + "','" + telefono + "','" + detalleDireccion + "')";
        Conector.getConnector().ejecutarSql(sql);
    }

    public Miembro iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception {
        Miembro tmpMiembro = new Miembro();
        ResultSet rs;
        String query = "Select correo,contrasenia from miembro where correo='" + correo + "'" + "&& contrasenia='" + contrasenia + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpMiembro.setCorreo(rs.getString("correo"));
            tmpMiembro.setContrasenia(rs.getString("contrasenia"));
        }
        return tmpMiembro;
    }

    public Miembro validarMiembro(String correo) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String query;
        query = "Select correo from miembro where correo='" + correo + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        Miembro tmpMiembro = new Miembro();
        while (rs.next()) {
            tmpMiembro.setCorreo(rs.getString("correo"));
        }
        return tmpMiembro;
    }

    public ArrayList<Miembro> listarMiembro() throws java.sql.SQLException, Exception {
        ResultSet rs;
        ArrayList<Miembro> miembros = new ArrayList<>();
        String query;
        query = "Select * from miembro";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Miembro tmpMiembro = new Miembro(
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("correo"),
                    rs.getString("genero"),
                    rs.getString("nacionalidad"),
                    rs.getString("detalle_direccion"),
                    rs.getString("contrasenia"),
                    rs.getString("genero"),
                    rs.getString("annos_experiencia"),
                    rs.getDate("fecha_graduacion").toLocalDate(),
                    rs.getString("numero_licencia"),
                    rs.getString("puesto"),
                    rs.getString("telefono")
            );
            miembros.add(tmpMiembro);
        }
        return miembros;
    }

    public void modificarMiembro() {

    }


    public void eliminarMiembro() {

    }
}
