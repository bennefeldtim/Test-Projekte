import java.text.DecimalFormat;

public class DVD extends Artikel {
    //Variablen deklarieren
    private String title;
    private String length;

    public DVD(int artikelNummer, double nettoPreis, String title, String length) {
        super(artikelNummer, nettoPreis);
        this.title = title;
        this.length = length;
    }

    @Override
    // 19% Mwst
    public double getPreis() {
        return getNettoPreis() * 1.19f;
    }

    @Override
    public String getInfo() {
        DecimalFormat f = new DecimalFormat("##.00");

        return "DVD - " + title + " (" + length + ") : " + f.format(this.getPreis()) + " Euro";
    }
}
