package cr.ac.JuanMaswell.ucenfotec.bl.dao.factory;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.IAdministradorDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.MySqlAdministradorDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeronave.IAeronaveDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeronave.MySqlAeronaveDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.IAeropuertoDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.MySqlAeropuertoDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.ILineaAereaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.MySqlLineaAereaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.IMiembroDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.MySqlMiembroDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais.IPaisDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais.MySqlPaisDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.ISalaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.MySqlSalaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.ITiqueteDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.MySqlTiqueteDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tripulacion.ITripulacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tripulacion.MySqlTripulacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.IUbicacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.MySqlUbicacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.IUsuarioDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.MySqlUsuarioDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.IVueloDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.MySqlVueloDao;

public class MysqlDaoFactory extends DaoFactory {
    public IAdministradorDao getAdministradorDao() {
        return new MySqlAdministradorDao();
    }

    public IAeronaveDao getAeronaveDao() {
        return new MySqlAeronaveDao();
    }

    public IAeropuertoDao getAeropuertoDao() {
        return new MySqlAeropuertoDao();
    }

    public ILineaAereaDao getLineaAereaDao() {
        return new MySqlLineaAereaDao();
    }

    public IMiembroDao getMiembroDao() {
        return new MySqlMiembroDao();
    }

    public IPaisDao getPaisDao() {
        return new MySqlPaisDao();
    }

    public ISalaDao getSalaDao() {
        return new MySqlSalaDao();
    }

    public ITiqueteDao getTiqueteDao() {
        return new MySqlTiqueteDao();
    }

    public ITripulacionDao getTripulacionDao() {
        return new MySqlTripulacionDao();
    }

    public IUbicacionDao getUbicacionDao() {
        return new MySqlUbicacionDao();
    }

    public IUsuarioDao getUsuarioDao() {
        return new MySqlUsuarioDao();
    }

    public IVueloDao getVueloDao() {
        return new MySqlVueloDao();
    }
}
