package cr.ac.JuanMaswell.ucenfotec.bl.dao.Tiquete;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;

import java.time.LocalDate;

public class Tiquete {
    private LocalDate fecha;
    Aeropuerto aeropuertoOrigen;
    Aeropuerto aeropuertoDestino;
    private int numeroAsiento;
    private double precio;
    private int numeroDeVuelo;
    private String tipoAsiento;
    private double impuesto;

    public Tiquete() {

    }

    public Tiquete(LocalDate fecha, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, int numeroAsiento, double precio, int numeroDeVuelo, String tipoAsiento, double impuesto) {
        this.fecha = fecha;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.numeroDeVuelo = numeroDeVuelo;
        this.tipoAsiento = tipoAsiento;
        this.impuesto = impuesto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen.getNombre();
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino.getNombre();
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(int numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Tiquete{" +
                "fecha=" + fecha +
                ", aeropuertoOrigen=" + aeropuertoOrigen.getNombre() +
                ", aeropuertoDestino=" + aeropuertoDestino.getNombre() +
                ", numeroAsiento=" + numeroAsiento +
                ", precio=" + precio +
                ", numeroDeVuelo=" + numeroDeVuelo +
                ", tipoAsiento='" + tipoAsiento + '\'' +
                ", impuesto=" + impuesto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiquete tiquete = (Tiquete) o;
        return numeroDeVuelo == tiquete.numeroDeVuelo;
    }
}
