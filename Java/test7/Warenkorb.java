import java.text.DecimalFormat;
import java.util.ArrayList;

public class Warenkorb {
    private ArrayList<Artikel> artikelListe;

    public Warenkorb() {
        this.artikelListe = new ArrayList<>();
    }

    public void addArtikel(Artikel artikel) {
        this.artikelListe.add(artikel);
    }

    public void removeArtikel(Artikel artikel) {
        this.artikelListe.remove(artikel);
    }

    public void zeigeWarenkorb() {
        double total = 0;

        for(Artikel artikel : artikelListe) {
            System.out.println(artikel.getInfo());
            total += artikel.getPreis();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        // Ausgabe des Gesamtpreises, des Warenkorbs
        System.out.println("Gesamtpreis: " + f.format(total) + " Euro");
    }
}
