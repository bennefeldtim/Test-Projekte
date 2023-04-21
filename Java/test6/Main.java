import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        PasswortGenerator generator = new PasswortGenerator();
        //Merksatz für Passwort festlegen
        generator.erstellePasswort("Java ist auch eine Insel (von Christian Ullenboom)");
        //Ausgabe des Passworts
        System.out.println(generator);
        //Merksatz für Passwort festlegen
        generator.erstellePasswort("java ist eine objekt-orientierte sprache!");
        //Ausgabe des Passworts
        System.out.println(generator);

        Bild bild = new Bild();
        //Dateieingabe
        bild.leseBild("C:\\Users\\Tim\\Downloads\\java.pgm");
        //Aufrufen der Funktion
        bild.rotiereBild();
        //Dateiausgabe
        bild.schreibeBild("C:\\Users\\Tim\\Downloads");
    }
}
