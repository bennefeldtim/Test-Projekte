import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bild {

    //Variablen deklarieren
    String format;
    int breite;
    int hoehe;
    int maxHelligkeit;
    int[][] daten;

    public void leseBild(String dateiName) {
        Path filePath = Paths.get(dateiName);
        try {
            List<String> lines = Files.readAllLines(filePath);
            Pattern pattern = Pattern.compile("[0-9]+");

            for(int i = 0; i<lines.size(); i++) {
                Matcher matcher = pattern.matcher(lines.get(i));

                switch (i) {
                    case 0:
                        this.format = lines.get(i);
                        break;
                    case 1:
                        int count = 0;

                        while(matcher.find()) {
                            if(count == 0) {
                                //Einlesen der breite
                                this.breite = Integer.parseInt(matcher.group());
                            } else if (count == 1) {
                                //Einlesen der höhe
                                this.hoehe = Integer.parseInt(matcher.group());
                            }

                            count++;
                        }

                        this.daten = new int[this.hoehe][this.breite];
                        break;
                    case 2:
                        //Einlesen der Helligkeit
                        this.maxHelligkeit = Integer.parseInt(lines.get(i));
                        break;
                    default:
                        int index = 0;
                        while(matcher.find()) {
                            //Einlesen der Bilddaten
                            this.daten[i-3][index] = Integer.parseInt(matcher.group());
                            index++;
                        }
                }
            }
        } catch (IOException e) {
            //Fehlermeldung ausgeben
            System.out.println("Fehler: Bild kann nicht eingelesen werden");
        }
    }

    public void schreibeBild(String verzeichnis) {
        // Datei soll im Format yyyy-mm-dd gespeichert werden
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //.pgm als Dateitypen
        Path filePath = Paths.get(verzeichnis, LocalDate.now().format(formatter) + ".pgm");

        String content = this.format + "\n" + this.breite + " " + this.hoehe + "\n" + this.maxHelligkeit + "\n";

        for(int row[] : this.daten) {
            for(int number : row) {
                content += number + " ";
            }

            content = content.substring(0, content.length() - 1);
            content += "\n";
        }

        content = content.substring(0, content.length() - 1);

        try {
            Files.write(filePath, content.getBytes());
        } catch (IOException e) {
            //Ausgabe der Fehlermeldung
            System.out.println("Fehler: Bild kann nicht gespeichert werden");
        }
    }

    public void rotiereBild() {
        //Bild wird um 90 grad nach links rotiert
        int rotated[][] = new int[this.breite][this.hoehe];

        for(int i = 0; i < this.breite; i++) {
            for(int k = 0; k < this.hoehe; k++) {
                System.out.println(this.daten[k][i]);
                rotated[this.breite - i - 1][k] = this.daten[k][i];
            }
        }

        this.daten = rotated;
        int old = this.breite;
        this.breite = this.hoehe;
        this.hoehe = old;
    }
}
