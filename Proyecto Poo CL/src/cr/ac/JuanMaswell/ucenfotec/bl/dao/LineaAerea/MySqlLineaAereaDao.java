package cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea;

import com.company.Conector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlLineaAereaDao implements ILineaAereaDao {

    public void registrarLinea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuena, String nombrePais, String logo) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql;
        sql = "Insert into aerolinea(nombre_comercial,cedula_juridica,nombre_empresa,nombre_pais,logo) values" +
                "('" + nombreComercial + "','" + cedulaJuridica + "','" + nombreEmpresaDuena + "','" + nombrePais + "','" + logo + "')";
        Conector.getConnector().ejecutarSql(sql);
    }

    public ArrayList<LineaAerea> listarAerolinea() throws Exception {
        ResultSet rs;
        String query;
        query = "Select * from aerolinea";
        rs = Conector.getConnector().ejecutarQuery(query);
        ArrayList<LineaAerea> lineasAereas = new ArrayList<>();
        while (rs.next()) {
            LineaAerea tmpLinea = new LineaAerea(
                    rs.getString("nombre_comercial"),
                    rs.getString("cedula_juridica"),
                    rs.getString("nombre_empresa"),
                    rs.getString("nombre_pais"),
                    rs.getString("logo")
            );
            lineasAereas.add(tmpLinea);
        }
        return lineasAereas;
    }


    public LineaAerea listarLineaAereaPorNombre() throws Exception {
        ResultSet rs;
        String query;
        query = "Select nombre_comercial from aerolinea";
        rs = Conector.getConnector().ejecutarQuery(query);
        LineaAerea tmpLinea = new LineaAerea();
        while (rs.next()) {
            tmpLinea.setNombreComercial(rs.getString("nombre_comercial"));
        }
        return tmpLinea;
    }


    public LineaAerea validarLinea(String cedulaJuridica) throws Exception {
        ResultSet rs;
        String query = "Select cedula_juridica from aerolinea where cedula_juridica='" + cedulaJuridica + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        LineaAerea tmpLinea = new LineaAerea();
        while (rs.next()) {
            tmpLinea.setCedulaJuridica(rs.getString("cedula_juridica"));
        }
        return tmpLinea;
    }

    public void modificarLinea() {

    }

    public void eliminarLinea() {

    }
}
