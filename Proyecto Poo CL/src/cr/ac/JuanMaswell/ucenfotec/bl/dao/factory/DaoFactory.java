package cr.ac.JuanMaswell.ucenfotec.bl.dao.factory;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador.IAdministradorDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeronave.IAeronaveDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.IAeropuertoDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.ILineaAereaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.IMiembroDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais.IPaisDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.ISalaDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete.ITiqueteDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tripulacion.ITripulacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.IUbicacionDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario.IUsuarioDao;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo.IVueloDao;

public abstract class DaoFactory {
    public static final int MYSQL = 1;

    public static DaoFactory getDaoFactory(int factory) {
        switch (factory) {
            case MYSQL:
                return new MysqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract IAdministradorDao getAdministradorDao();

    public abstract IAeronaveDao getAeronaveDao();

    public abstract IAeropuertoDao getAeropuertoDao();

    public abstract ILineaAereaDao getLineaAereaDao();

    public abstract IMiembroDao getMiembroDao();

    public abstract IPaisDao getPaisDao();

    public abstract ISalaDao getSalaDao();

    public abstract ITiqueteDao getTiqueteDao();

    public abstract ITripulacionDao getTripulacionDao();

    public abstract IUbicacionDao getUbicacionDao();

    public abstract IUsuarioDao getUsuarioDao();

    public abstract IVueloDao getVueloDao();

}
