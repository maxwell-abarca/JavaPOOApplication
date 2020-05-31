package cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala;

import com.company.Conector;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.Ubicacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlSalaDao implements ISalaDao {

    public void registrarSala(String nombre, String codigo, String ubicacion) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String sql = "insert into sala(nombre,codigo,ubicacion) values" +
                "('" + nombre + "','" + codigo + "','" + ubicacion + "')";
        Conector.getConnector().ejecutarSql(sql);
    }


    public Sala validarSalaRepetida(String codigo) throws Exception {
        ResultSet rs;
        String query = "Select codigo from sala where codigo='" + codigo + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        Sala tmpSala = new Sala();
        while (rs.next()) {
            tmpSala.setCodigo(codigo);
        }
        return tmpSala;

    }

    public ArrayList<Sala> listarSala() throws Exception {
        ResultSet rs;
        String query;
        query = "Select * from sala";
        rs = Conector.getConnector().ejecutarQuery(query);
        ArrayList<Sala> salas = new ArrayList<>();
        while (rs.next()) {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setPiso(rs.getString("ubicacion"));
            Sala tmpSala = new Sala(
                    rs.getString("nombre"),
                    rs.getString("codigo"),
                    ubicacion
            );
            salas.add(tmpSala);
        }
        return salas;
    }


    public String[] listarNombreSala() throws java.sql.SQLException, Exception {
        ArrayList<Sala> salas = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select * from sala";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Sala tmpSala = new Sala();
            tmpSala.setNombre(rs.getString("nombre"));
            salas.add(tmpSala);
        }
        String[] nombreSala = new String[salas.size()];
        int posicion = 0;
        for (Sala dato : salas) {
            String info = dato.getNombre();
            nombreSala[posicion] = info;
            posicion++;
        }
        return nombreSala;
    }

    public void modificarSala() {

    }


    public void eliminarSala() {

    }
}
