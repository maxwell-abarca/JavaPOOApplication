package cr.ac.JuanMaswell.ucenfotec.bl.dao.Vuelo;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeropuerto.Aeropuerto;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea.LineaAerea;
import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;

public class Vuelo {
    LineaAerea lineaAerea;
    Aeropuerto aeropuertoOrigen;
    private String horaLlegada;
    private String horaSalida;
    private String estado;
    Aeropuerto aeropuertoDestino;
    Sala sala;


    public Vuelo() {

    }

    public Vuelo(LineaAerea lineaAerea, Aeropuerto aeropuertoOrigen, String horaLlegada, String horaSalida, String estado, Aeropuerto aeropuertoDestino, Sala sala) {
        this.lineaAerea = lineaAerea;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.aeropuertoDestino = aeropuertoDestino;
        this.sala = sala;

    }

    public String getLineaAerea() {
        return lineaAerea.getNombreComercial();
    }

    public void setLineaAerea(LineaAerea lineaAerea) {
        this.lineaAerea = lineaAerea;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen.getNombre();
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino.getNombre();
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getSala() {
        return sala.getNombre();
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "lineaAerea=" + lineaAerea.getNombreComercial() +
                ", aeropuertoOrigen=" + aeropuertoOrigen.getNombre() +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", estado=" + estado +
                ", aeropuertoDestino=" + aeropuertoDestino.getNombre() +
                ", sala=" + sala.getNombre() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return sala.getNombre().equals(vuelo.sala.getNombre());
    }

}