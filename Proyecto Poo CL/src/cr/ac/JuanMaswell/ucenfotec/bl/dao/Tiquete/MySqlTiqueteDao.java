package cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete;

import com.company.Conector;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlTiqueteDao implements ITiqueteDao {

    public void registrarTiquete(LocalDate fecha, String aeropuertoOrigen, String aeropuertoDestino, int numeroAsiento, double precio, int numeroDeVuelo, String tipoAsiento, double impuesto) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql;
        sql = "Insert into tiquete (fecha,aeropuerto_origen,aeropuerto_destino,numero_asiento,precio,numero_vuelo,tipo_asiento,impuesto) values" +
                "('" + fecha + "','" + aeropuertoOrigen + "','" + aeropuertoDestino + "','" + numeroAsiento + "','" + precio + "','" + numeroDeVuelo + "','" + tipoAsiento + "','" + impuesto + "')";
        Conector.getConnector().ejecutarSql(sql);
    }

    public ArrayList<Tiquete> listarTiquete() throws Exception {
        ArrayList<Tiquete> tiquetes = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select * from tiquete";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Aeropuerto tmpAeropuerto = new Aeropuerto();
            tmpAeropuerto.setNombre(rs.getString("aeropuerto_origen"));
            Aeropuerto tmpAeroPuerto2 = new Aeropuerto();
            tmpAeroPuerto2.setNombre(rs.getString("aeropuerto_destino"));
            Tiquete tmpTiquete = new Tiquete(
                    rs.getDate("fecha").toLocalDate(), tmpAeropuerto, tmpAeroPuerto2,
                    rs.getInt("numero_asiento"), rs.getDouble("precio"),
                    rs.getInt("numero_vuelo"),
                    rs.getString("tipo_asiento"),
                    rs.getDouble("impuesto")
            );
            tiquetes.add(tmpTiquete);
        }
        return tiquetes;
    }


    public Tiquete validarTiquete(int numeroVuelo) throws Exception {
        Tiquete tmpTiquete = new Tiquete();
        ResultSet rs;
        String query = "Select numero_vuelo from tiquete";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpTiquete.setNumeroDeVuelo(rs.getInt("numero_vuelo"));
        }
        return tmpTiquete;
    }

    public void modificarTiquete() {

    }


    public void eliminarTiquete() {

    }
}
