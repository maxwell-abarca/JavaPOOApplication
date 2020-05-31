package cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo;

import com.company.Conector;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlVueloDao implements IVueloDao {

    public void registrarVuelo(String lineaAerea, String aeropuertoOrigen, String horaLlegada, String horaSalida, String estado, String aeropuertoDestino, String sala) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql = "insert into vuelos(linea_aerea,aeropuerto_origen,hora_llegada,hora_salida,estado,aeropuerto_destino,sala) values" +
                "('" + lineaAerea + "','" + aeropuertoOrigen + "','" + horaLlegada + "','" + horaSalida + "','" + estado + "','" + aeropuertoDestino + "','" + sala + "')";
        Conector.getConnector().ejecutarSql(sql);
    }


    public ArrayList<Vuelo> listarVuelo() throws Exception {
        ResultSet rs;
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        String query = "Select * from vuelos";
        rs = Conector.getConnector().ejecutarQuery(query);

        while (rs.next()) {
            LineaAerea tmpLinea = new LineaAerea();
            tmpLinea.setNombreComercial(rs.getString("linea_aerea"));
            Aeropuerto aeropuerto = new Aeropuerto();
            aeropuerto.setNombre(rs.getString("aeropuerto_origen"));
            Aeropuerto aeropuerto2 = new Aeropuerto();
            aeropuerto2.setNombre(rs.getString("aeropuerto_destino"));
            Sala tmpSala = new Sala();
            tmpSala.setNombre(rs.getString("sala"));
            Vuelo tmpVuelo = new Vuelo(
                    tmpLinea, aeropuerto, rs.getString("hora_llegada"), rs.getString("hora_salida"),
                    rs.getString("estado"), aeropuerto2, tmpSala
            );
            vuelos.add(tmpVuelo);
        }
        return vuelos;
    }


    public Vuelo validarVueloRepetido(String sala) throws Exception {
        Vuelo tmpVuelo = new Vuelo();
        ResultSet rs;
        String query = "Select estado from vuelos where sala='" + sala + "'";

        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpVuelo.setEstado("estado");
        }
        return tmpVuelo;
    }

    public void modificarVuelo() {

    }

    public void eliminarVuelo() {

    }
}
