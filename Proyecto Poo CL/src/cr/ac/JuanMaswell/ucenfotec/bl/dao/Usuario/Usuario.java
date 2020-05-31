package cr.ac.JuanMaswell.ucenfotec.bl.dao.Usuario;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Persona;

import java.time.LocalDate;

public class Usuario extends Persona {
    private String provincia;
    private String canton;
    private String distrito;
    private LocalDate fechaNacimiento;
    private int edad;
    private String genero;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido1, String apellido2, String correo, String genero, String cedula, String provincia, String canton, String distrito, String detalleDireccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String contrasenia) {
        super(nombre, apellido1, apellido2, cedula, correo, nacionalidad, detalleDireccion, contrasenia);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) ;

        Usuario other = (Usuario) otherObject;

        return correo.equals(other.correo) && contrasenia.equals(other.contrasenia);

    }

}
