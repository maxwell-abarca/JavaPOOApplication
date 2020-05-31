package cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais;


import com.company.Conector;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlPaisDao implements IPaisDao {

    public void registrarPais(String nombre, String abreviatura, String codigo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        String sql;
        sql = "Insert into pais(nombre,abreviatura,codigo)values" +
                "('" + nombre + "','" + abreviatura + "','" + codigo + "')";
        Conector.getConnector().ejecutarSql(sql);
    }


    public ArrayList<Pais> listarPais() throws java.sql.SQLException, Exception {
        ResultSet rs;
        String query;
        query = "Select * from pais";
        ArrayList<Pais> paises = new ArrayList<>();
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Pais tmpPais = new Pais(
                    rs.getString("nombre"),
                    rs.getString("abreviatura"),
                    rs.getString("codigo")
            );
            paises.add(tmpPais);
        }
        return paises;
    }


    public Pais validarPaisRepetido(String nombrePais, String codigoPais) throws Exception {
        ResultSet rs;
        String query;
        query = "Select nombre,codigo from pais where nombre='" + nombrePais + "'" + "&& codigo='" + codigoPais + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        Pais tmpPais = new Pais();
        while (rs.next()) {
            tmpPais.setNombre(rs.getString("nombre"));
            tmpPais.setCodigo(rs.getString("codigo"));
        }
        return tmpPais;
    }

    public String[] listarNombrePais() throws java.sql.SQLException, Exception {
        ArrayList<Pais> paises = new ArrayList<>();
        ResultSet rs;
        String query;
        query = "Select nombre,abreviatura,codigo from pais";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            Pais tmpPais = new Pais();
            tmpPais.setNombre(rs.getString("nombre"));
            paises.add(tmpPais);
        }

        String[] nombrePaises = new String[paises.size()];
        int posicion = 0;
        for (Pais dato : paises) {
            String info = dato.getNombre();
            nombrePaises[posicion] = info;
            posicion++;
        }
        return nombrePaises;

    }


    public String buscarPaisPorNombre(String nombrePais) throws java.sql.SQLException, Exception {
        ResultSet rs;
        String query;
        Pais tmpPais = new Pais();
        query = "Select codigo from pais where nombre='" + nombrePais + "'";
        rs = Conector.getConnector().ejecutarQuery(query);
        while (rs.next()) {
            tmpPais.setCodigo(rs.getString("codigo"));
        }
        return tmpPais.getCodigo();
    }

    public void modificarPais() {

    }

    public void eliminarPais() {

    }
}
