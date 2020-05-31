package cr.ac.JuanMaswell.ucenfotec.bl.dao.Pais;

public class Pais {
    private String nombre;
    private String abreviatura;
    private String codigo;

    public Pais() {

    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }



    public Pais(String nombre, String abreviatura, String codigo) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return codigo.equals(pais.codigo);
    }
}
