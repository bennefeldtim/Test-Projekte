import java.text.DecimalFormat;

public class Buch extends Artikel {
    //Variablen deklarieren
    private String title;
    private int year;

    public Buch(int artikelNummer, double nettoPreis, String title, int year) {
        super(artikelNummer, nettoPreis);
        this.title = title;
        this.year = year;
    }

    @Override
    // 7% Mwst
    public double getPreis() {
        return getNettoPreis() * 1.07f;
    }

    @Override
    public String getInfo() {
        DecimalFormat f = new DecimalFormat("##.00");

        return "Buch - " + title + " (" + year + ") : " + f.format(this.getPreis()) + " Euro";
    }
}
