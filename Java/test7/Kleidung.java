import java.text.DecimalFormat;

public class Kleidung extends Artikel {
    private String type;
    private String size;
    private String color;

    public Kleidung(int artikelNummer, double nettoPreis, String type, String size, String color) {
        super(artikelNummer, nettoPreis);
        this.type = type;
        this.size = size;
        this.color = color;
    }

    @Override
    // 12% Mwst
    public double getPreis() {
        return getNettoPreis() * 1.12f;
    }

    @Override
    public String getInfo() {
        DecimalFormat f = new DecimalFormat("##.00");

        return "Kleidung - " + type + ", " + this.color +  " (" + size + ") : " + f.format(this.getPreis()) + " Euro";
    }
}
