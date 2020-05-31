package cr.ac.JuanMaswell.ucenfotec.bl.dao.Aeronave;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Tripulacion.Tripulacion;

public class Aeronave {
    private String placa;
    private String marcaFabricante;
    private String modelo;
    private String capacidad;
    Tripulacion mTripulacion;

    public Aeronave() {

    }

    public Aeronave(String placa, String marcaFabricante, String modelo, String capacidad) {
        this.placa = placa;
        this.marcaFabricante = marcaFabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(String marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Aeronave{" +
                "placa='" + placa + '\'' +
                ", marcaFabricante='" + marcaFabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad='" + capacidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeronave aeronave = (Aeronave) o;
        return placa.equals(aeronave.placa);
    }

}
