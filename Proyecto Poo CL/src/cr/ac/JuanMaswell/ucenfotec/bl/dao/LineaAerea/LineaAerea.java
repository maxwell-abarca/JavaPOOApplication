package cr.ac.JuanMaswell.ucenfotec.bl.dao.LineaAerea;


public class LineaAerea {
    private String nombreComercial;
    private String cedulaJuridica;
    private String nombreEmpresaDuena;
    private String nombrePais;
    private String logo;

    public LineaAerea() {

    }

    public LineaAerea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuena, String nombrePais, String logo) {
        this.nombreComercial = nombreComercial;
        this.cedulaJuridica = cedulaJuridica;
        this.nombreEmpresaDuena = nombreEmpresaDuena;
        this.nombrePais = nombrePais;
        this.logo = logo;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getNombreEmpresaDuena() {
        return nombreEmpresaDuena;
    }

    public void setNombreEmpresaDuena(String nombreEmpresaDuena) {
        this.nombreEmpresaDuena = nombreEmpresaDuena;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "LineaAerea{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", cedulaJuridica='" + cedulaJuridica + '\'' +
                ", nombreEmpresaDuena='" + nombreEmpresaDuena + '\'' +
                ", nombrePais='" + nombrePais + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaAerea that = (LineaAerea) o;
        return cedulaJuridica.equals(that.cedulaJuridica);
    }
}
