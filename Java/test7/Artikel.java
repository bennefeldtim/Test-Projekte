public abstract class Artikel {
    //Variablen deklarieren
    private int artikelNummer;
    private double nettoPreis;

    public Artikel(int artikelNummer, double nettoPreis) {
        this.artikelNummer = artikelNummer;
        this.nettoPreis = nettoPreis;
    }

    public double getNettoPreis() {
        return nettoPreis;
    }

    public int getArtikelNummer() {
        return artikelNummer;
    }

    public abstract double getPreis();

    public abstract String getInfo();
}
