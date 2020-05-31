package cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala;


import cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion.Ubicacion;

public class Sala {
    private String nombre;
    private String codigo;
    Ubicacion ubicacion;

    public Sala() {

    }

    public Sala(String nombre, String codigo, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
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

    public String getUbicacion() {
        return ubicacion.getPiso();
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", ubicacion=" + ubicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return codigo.equals(sala.codigo);
    }


}