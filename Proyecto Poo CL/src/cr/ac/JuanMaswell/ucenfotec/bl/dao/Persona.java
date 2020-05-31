package cr.ac.JuanMaswell.ucenfotec.bl.dao;

public class Persona {
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String cedula;
    protected String correo;
    protected String nacionalidad;
    protected String detalleDireccion;
    protected String contrasenia;

    public Persona() {

    }

    public Persona(String nombre, String apellido1, String apellido2, String cedula, String correo, String nacionalidad, String detalleDireccion, String contrasenia) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.detalleDireccion = detalleDireccion;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDetalleDireccion() {
        return detalleDireccion;
    }

    public void setDetalleDireccion(String detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", detalleDireccion='" + detalleDireccion + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return cedula.equals(persona.cedula);
    }
}
