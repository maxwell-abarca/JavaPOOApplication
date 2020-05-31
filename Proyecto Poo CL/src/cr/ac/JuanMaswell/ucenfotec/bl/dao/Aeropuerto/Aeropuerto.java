package cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto;


import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.Ubicacion;

import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private String codigo;
    private String nombrePais;
    private String codigoPais;
    ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

    public Aeropuerto() {

    }

    public Aeropuerto(String nombre, String codigo, String nombrePais, String codigoPais) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.codigoPais = codigoPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public void agregarUbicaciones(Ubicacion obj) {
        ubicaciones.add(obj);
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombrePais='" + nombrePais + '\'' +
                ", codigoPais='" + codigoPais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuerto that = (Aeropuerto) o;
        return codigo.equals(that.codigo);
    }

}
