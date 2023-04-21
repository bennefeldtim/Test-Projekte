public class Main {
    public static void main(String[] args) {
        TestFahrradgruppe group = new TestFahrradgruppe();
        System.out.println(group);

        Warenkorb warenkorb = new Warenkorb();
        warenkorb.addArtikel(new Buch(1, 10, "Max Mustermann, Java das Buch", 2011));
        warenkorb.addArtikel(new Buch(2, 20, "Max Mustermann, Java noch ein Buch", 2021));
        warenkorb.addArtikel(new DVD(3, 10, "Java: Der Film", "2:21"));
        warenkorb.addArtikel(new Kleidung(4, 30, "T-Shirt", "M", "blau"));
        warenkorb.zeigeWarenkorb();
    }
}
