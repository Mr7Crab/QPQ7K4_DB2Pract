

public class Konyv {
    private final int konyvId;
    private String tipus;
    private String szerzoNeve;
    private String cim;
    private String kiado;
    private String kiadasIdeje;
    private String konyvtarNeve;
    private int darabszam;

    public Konyv(int konyvId, String tipus, String szerzoNeve, String cim,
                 String kiado, String kiadasIdeje, String konyvtarNeve, int darabszam) {
        this.konyvId = konyvId;
        this.tipus = tipus;
        this.szerzoNeve = szerzoNeve;
        this.cim = cim;
        this.kiado = kiado;
        this.kiadasIdeje = kiadasIdeje;
        this.konyvtarNeve = konyvtarNeve;
        this.darabszam = darabszam;
    }

    public int getKonyvId() { return konyvId; }
    public String getTipus() { return tipus; }
    public String getSzerzoNeve() { return szerzoNeve; }
    public String getCim() { return cim; }
    public String getKiado() { return kiado; }
    public String getKiadasIdeje() { return kiadasIdeje; }
    public String getKonyvtarNeve() { return konyvtarNeve; }
    public int getDarabszam() { return darabszam; }

    public void setTipus(String tipus) { this.tipus = tipus; }
    public void setSzerzoNeve(String szerzoNeve) { this.szerzoNeve = szerzoNeve; }
    public void setCim(String cim) { this.cim = cim; }
    public void setKiado(String kiado) { this.kiado = kiado; }
    public void setKiadasIdeje(String kiadasIdeje) { this.kiadasIdeje = kiadasIdeje; }
    public void setKonyvtarNeve(String konyvtarNeve) { this.konyvtarNeve = konyvtarNeve; }
    public void setDarabszam(int darabszam) { this.darabszam = darabszam; }

    @Override
    public String toString() {
        return konyvId + " | " + cim + " | " + szerzoNeve + " | " + tipus + " | " + kiado + " | " + kiadasIdeje;
    }
}