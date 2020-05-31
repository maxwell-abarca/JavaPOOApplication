package cr.ac.JuanMaswell.ucenfotec.bl.dao.Tripulacion;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro.Miembro;

import java.util.ArrayList;

public class Tripulacion {
    private String codigo;
    private String nombreClave;
    ArrayList<Miembro> mMiembro = new ArrayList<>();

    public Tripulacion() {

    }

    public Tripulacion(String codigo, String nombreClave) {
        this.codigo = codigo;
        this.nombreClave = nombreClave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public void agregarMiembroATripulacion(Miembro obj) {
        mMiembro.add(obj);
    }

    @Override
    public String toString() {
        return "Tripulacion{" +
                "codigo='" + codigo + '\'' +
                ", nombreClave='" + nombreClave + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tripulacion that = (Tripulacion) o;
        return codigo.equals(that.codigo);
    }


}