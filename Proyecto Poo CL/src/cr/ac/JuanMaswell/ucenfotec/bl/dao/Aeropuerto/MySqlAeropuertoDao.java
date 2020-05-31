package cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto;

import com.company.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlAeropuertoDao implements IAeropuertoDao {

    public void registrarAeropuerto(String nombre, String codigo, String nombrePais, String codigoPais) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql;
        sql = "Insert into aeropuerto(nombre,codigoAeropuerto,pais,codigoPais) values" +
                "('" + nombre + "','" + codigo + "','" + nombrePais + "','" + codigoPais + "')";
        Conector.getConnector().ejecutarSql(sql);

    }


    public String[] listarAeropuertoPorNombre() throws Exception {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select * from aeropuerto";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Aeropuerto tmpAeropuerto = new Aeropuerto();
            tmpAeropuerto.setNombre(rs.getString("nombre"));
            aeropuertos.add(tmpAeropuerto);
        }
        String[] nombreAeropuertos = new String[aeropuertos.size()];
        int posicion = 0;
        for (Aeropuerto dato : aeropuertos) {
            String info = dato.getNombre();
            nombreAeropuertos[posicion] = info;
            posicion++;
        }
        return nombreAeropuertos;

    }

    public Aeropuerto validarAeropuerto(String codigoAeropuerto) throws Exception {
        ResultSet rs;
        String query;
        query = "Select nombre,codigoAeropuerto,pais,codigoPais from aeropuerto where codigoAeropuerto='" + codigoAeropuerto + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        Aeropuerto tmpAeropuerto = new Aeropuerto();
        while (rs.next()) {
            tmpAeropuerto.setCodigo(rs.getString("codigoAeropuerto"));
        }
        return tmpAeropuerto;
    }

    public ArrayList<Aeropuerto> listarAeropuerto() throws java.sql.SQLException, Exception {
        ResultSet rs;
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        String query;
        query = "Select * from aeropuerto";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Aeropuerto tmpAeropuerto = new Aeropuerto(
                    rs.getString("nombre"),
                    rs.getString("codigoAeropuerto"),
                    rs.getString("pais"),
                    rs.getString("codigoPais")
            );
            aeropuertos.add(tmpAeropuerto);
        }
        return aeropuertos;
    }


    public void modificarAeropuerto() {

    }

    public void eliminarAeropuerto() {

    }

}
