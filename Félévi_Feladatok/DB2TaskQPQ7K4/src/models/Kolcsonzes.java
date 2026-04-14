

public class Kolcsonzes {
    private final int kolcsonzesId;
    private String kolcsonzesIdeje;
    private String leadasIdeje;
    private final int kolcsonzoId;
    private final int konyvId;

    public Kolcsonzes(int kolcsonzesId, String kolcsonzesIdeje, String leadasIdeje, int kolcsonzoId, int konyvId) {
        this.kolcsonzesId = kolcsonzesId;
        this.kolcsonzesIdeje = kolcsonzesIdeje;
        this.leadasIdeje = leadasIdeje;
        this.kolcsonzoId = kolcsonzoId;
        this.konyvId = konyvId;
    }

    public int getKolcsonzesId() { return kolcsonzesId; }
    public String getKolcsonzesIdeje() { return kolcsonzesIdeje; }
    public String getLeadasIdeje() { return leadasIdeje; }
    public int getKolcsonzoId() { return kolcsonzoId; }
    public int getKonyvId() { return konyvId; }

    public void setKolcsonzesIdeje(String kolcsonzesIdeje) { this.kolcsonzesIdeje = kolcsonzesIdeje; }
    public void setLeadasIdeje(String leadasIdeje) { this.leadasIdeje = leadasIdeje; }

    @Override
    public String toString() {
        return kolcsonzesId + " | " + kolcsonzoId + " | " + konyvId + " | " + kolcsonzesIdeje + " | " + leadasIdeje;
    }
}