
public  class Kolcsonzo {
    private final int kolcsonzoId;
    private String nev;
    private String emailCim;
    private String lakcim;
    private int tiltott;
    private String regisztracioDatuma;

    public Kolcsonzo(int kolcsonzoId, String nev, String emailCim, String lakcim, int tiltott, String regisztracioDatuma) {
        this.kolcsonzoId = kolcsonzoId;
        this.nev = nev;
        this.emailCim = emailCim;
        this.lakcim = lakcim;
        this.tiltott = tiltott;
        this.regisztracioDatuma = regisztracioDatuma;
    }

    public int getKolcsonzoId() { return kolcsonzoId; }
    public String getNev() { return nev; }
    public String getEmailCim() { return emailCim; }
    public String getLakcim() { return lakcim; }
    public int getTiltott() { return tiltott; }
    public String getRegisztracioDatuma() { return regisztracioDatuma; }

    public void setNev(String nev) { this.nev = nev; }
    public void setEmailCim(String emailCim) { this.emailCim = emailCim; }
    public void setLakcim(String lakcim) { this.lakcim = lakcim; }
    public void setTiltott(int tiltott) { this.tiltott = tiltott; }
    public void setRegisztracioDatuma(String regisztracioDatuma) { this.regisztracioDatuma = regisztracioDatuma; }

    @Override
    public String toString() {
        return kolcsonzoId + " | " + nev + " | " + emailCim + " | " + lakcim + " | " + tiltott + " | " + regisztracioDatuma;
    }
    
}