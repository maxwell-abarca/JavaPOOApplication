package cr.ac.JuanMaswell.ucenfotec.bl.dao.Ubicacion;

import cr.ac.JuanMaswell.ucenfotec.bl.dao.Sala.Sala;

import java.util.ArrayList;

public class Ubicacion {
    private String piso;
    ArrayList<Sala> salas = new ArrayList<>();

    public Ubicacion() {

    }

    public Ubicacion(String piso) {
        this.piso = piso;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    public void agregarSala(Sala obj){
        salas.add(obj);
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "piso='" + piso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return piso.equals(ubicacion.piso);
    }


}
