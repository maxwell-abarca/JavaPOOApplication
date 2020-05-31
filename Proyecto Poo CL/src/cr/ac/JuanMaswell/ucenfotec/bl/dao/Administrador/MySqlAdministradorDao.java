package cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador;

import com.company.Conector;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlAdministradorDao implements IAdministradorDao {


    public void registrarAdministrador(String nombre, String apellido1, String apellido2, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String identificacion, String detalleDireccion, String correo, String contrasenia) throws java.sql.SQLException, Exception {
        Resultset rs;
        String sql = "Insert into administrador(nombre,apellido1,apellido2,nacionalidad,fecha_nacimiento,edad,genero,cedula,detalle_direccion,correo,contrasenia) values" +
                "('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + nacionalidad + "','" + fechaNacimiento + "','" + edad + "','" + genero + "','" + identificacion + "','" + detalleDireccion + "','" + correo + "','" + contrasenia + "')";
        Conector.getConnector().ejecutarSql(sql);
    }

    public Administrador iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception {
        Administrador tmpAdministrador = new Administrador();
        ResultSet rs;
        String query;
        query = "Select correo,contrasenia from administrador where correo='" + correo + "'" + "&& contrasenia='" + contrasenia + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpAdministrador.setCorreo(rs.getString("correo"));
            tmpAdministrador.setContrasenia(rs.getString("contrasenia"));
        }
        return tmpAdministrador;
    }


    public ArrayList<Administrador> listarAdministrador() throws Exception {
        ArrayList<Administrador> administradores = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select * from administrador";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Administrador tmpAdministrador = new Administrador(
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("nacionalidad"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getInt("edad"), rs.getString("genero"),
                    rs.getString("cedula"), rs.getString("detalle_direccion"),
                    rs.getString("correo"), rs.getString("contrasenia")
            );
            administradores.add(tmpAdministrador);
        }
        return administradores;
    }


    public Administrador validarAdministrador(String correo) throws Exception {
        ResultSet rs;
        String query;
        query = "Select correo from administrador where correo='" + correo + "'";
        Administrador tmpAdministrador = new Administrador();
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpAdministrador.setCorreo(rs.getString("correo"));
        }
        return tmpAdministrador;

    }

    public void eliminarAdministrador() {

    }


    public void modificarAdministrador() {

    }

}
