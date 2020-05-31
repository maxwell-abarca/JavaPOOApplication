package cr.ac.JuanMaswell.ucenfotec.bl.dao.Miembro;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Persona;

import java.time.LocalDate;

public class Miembro extends Persona {
    private String genero;
    private String anniosExperiencia;
    private LocalDate fechaGraduacion;
    private String numeroLicencia;
    private String puesto;
    private String telefono;

    public Miembro() {

    }

    public Miembro(String genero, String anniosExperiencia, LocalDate fechaGraduacion, String numeroLicencia, String puesto, String telefono) {
        this.genero = genero;
        this.anniosExperiencia = anniosExperiencia;
        this.fechaGraduacion = fechaGraduacion;
        this.numeroLicencia = numeroLicencia;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    public Miembro(String nombre, String apellido1, String apellido2, String identificacion, String correo, String nacionalidad, String detalleDireccion, String contrasenia, String genero, String anniosExperiencia, LocalDate fechaGraduacion, String numeroLicencia, String puesto, String telefono) {
        super(nombre, apellido1, apellido2, identificacion, correo, nacionalidad, detalleDireccion, contrasenia);
        this.genero = genero;
        this.anniosExperiencia = anniosExperiencia;
        this.fechaGraduacion = fechaGraduacion;
        this.numeroLicencia = numeroLicencia;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnniosExperiencia() {
        return anniosExperiencia;
    }

    public void setAnniosExperiencia(String anniosExperiencia) {
        this.anniosExperiencia = anniosExperiencia;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "genero=" + genero +
                ", anniosExperiencia=" + anniosExperiencia +
                ", fechaGraduacion=" + fechaGraduacion +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", puesto='" + puesto + '\'' +
                ", telefono='" + telefono + '\'' +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) ;

        Miembro other = (Miembro) otherObject;

        return correo.equals(other.correo) && contrasenia.equals(other.contrasenia);

    }
}
