package cr.ac.JuanMaswell.ucenfotec.bl.dao.Administrador;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Persona;

import java.time.LocalDate;

public class Administrador extends Persona {
    private int edad;
    private String genero;
    private LocalDate fechaNacimiento;

    public Administrador() {

    }

    public Administrador(int edad, String genero, LocalDate fechaNacimiento) {
        this.edad = edad;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrador(String nombre, String apellido1, String apellido2, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String identificacion, String detalleDireccion, String correo, String contrasenia) {
        super(nombre, apellido1, apellido2, identificacion, correo, nacionalidad, detalleDireccion, contrasenia);
        this.edad = edad;
        this.genero = genero;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "edad=" + edad +
                ", genero=" + genero +
                ", fechaNacimiento=" + fechaNacimiento +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) ;

        Administrador other = (Administrador) otherObject;

        return correo.equals(other.correo) && contrasenia.equals(other.contrasenia);

    }


}