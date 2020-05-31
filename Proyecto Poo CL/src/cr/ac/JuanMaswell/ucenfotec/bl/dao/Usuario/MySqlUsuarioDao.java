package cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario;


import com.company.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlUsuarioDao implements IUsuarioDao {
    /*aqui se ejecuta el sql*/

    public void registrarUsuario(String nombre, String apellido1, String apellido2, String correo, String genero, String cedula, String provincia, String canton, String distrito, String detalleDireccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String contrasenia) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql = "Insert into usuario(nombre,apellido1,apellido2,correo,genero,cedula,provincia,canton,distrito,detalle_direccion,nacionalidad,fecha_nacimiento,edad,contrasenia) values" +
                "('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + correo + "','" + genero + "','" + cedula + "','" + provincia + "','" + canton + "','" + distrito + "','" + detalleDireccion + "','" + nacionalidad + "','" + fechaNacimiento + "','" + edad + "','" + contrasenia + "')";
        Conector.getConnector().ejecutarSql(sql);
    }

    public Usuario iniciarSesion(String correo, String contrasenia) throws java.sql.SQLException, Exception {
        Usuario tmpUsuario = new Usuario();
        ResultSet rs;
        String query = "Select correo,contrasenia from usuario where correo='" + correo + "'" + "&& contrasenia='" + contrasenia + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpUsuario.setCorreo(rs.getString("correo"));
            tmpUsuario.setContrasenia(rs.getString("contrasenia"));

        }
        return tmpUsuario;
    }


    public ArrayList<Usuario> listarUsuario() throws java.sql.SQLException, Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select * from usuario";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Usuario tmpUsuario = new Usuario(
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("correo"),
                    rs.getString("genero"),
                    rs.getString("cedula"),
                    rs.getString("provincia"),
                    rs.getString("canton"),
                    rs.getString("distrito"),
                    rs.getString("detalle_direccion"),
                    rs.getString("nacionalidad"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getInt("edad"),
                    rs.getString("contrasenia")
            );
            usuarios.add(tmpUsuario);
        }
        return usuarios;
    }


    public Usuario validarRepetido(String correo) throws Exception {
        ResultSet rs;
        String query;
        query = "Select correo from usuario where correo='" + correo + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        Usuario tmpUsuario = new Usuario();
        while (rs.next()) {
            tmpUsuario.setCorreo(rs.getString("correo"));
        }
        return tmpUsuario;

    }

    public void eliminarUsuario() {

    }


    public void modificarUsuario() {

    }
}
