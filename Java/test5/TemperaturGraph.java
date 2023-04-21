import java.util.Arrays;

public class TemperaturGraph {
    private Integer[] temperaturen;
    private int jahr;

    TemperaturGraph(int jahr) {
        // Festlegung des jahres
        this.jahr = jahr;
        //12 Temperaturwerte
        temperaturen = new Integer[12];
    }

    public void addTempratur(int monat, int temperatur) {
        if(monat < 1 || monat > 12) {
            //Überprüfen, ob die zahl im richtigen bereich liegt
            System.out.println("Falscher Monatswert nur 1 - 12");
            return;
        } else if(temperatur < 0) {
            //Überprüfen, ob nur Werte über 0 eingegeben worden sind
            System.out.println("Nur Temperaturen ab 0 Grad erlaubt");
            return;
        }

        this.temperaturen[monat-1] = temperatur;
    }

    public void plotGraph() {
        //Deklaration min und max Temperatur Variablen
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;

        for(int i = 0; i < this.temperaturen.length; i++) {
            if(this.temperaturen[i] == null) {
                return;
            }

            if(this.temperaturen[i] < minTemp) {
                minTemp = this.temperaturen[i];
            }

            if(this.temperaturen[i] > maxTemp) {
                maxTemp = this.temperaturen[i];
            }
        }
        //Ausgabe des Jahrs der Temperaturwerte
        System.out.println("Jahr: " + this.jahr);

        for(int temp = maxTemp; temp > minTemp - 1; temp--) {
            String output = temp + (temp < 10 ? "  " : " ");

            for(int tempPoint : this.temperaturen) {
                //Wenn die Bedingung erfüllt ist wird eine # ausgegeben
                if(tempPoint >= temp) {
                    output += " #";
                } else {
                //Wenn nicht erfüllt, dann wird nichts ausgegeben
                    output += "  ";
                }
            }

            System.out.println(output);
        }
    }

    //Umwandlung in einen String
    @Override
    public String toString() {
        return "TemperaturGraph{" +
            "temperaturen=" + Arrays.toString(temperaturen) +
            ", jahr=" + jahr +
            '}';
    }
}
