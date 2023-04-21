import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Bruch festlegen
        Bruch bruch1 = new Bruch(1, 2);
        Bruch bruch2 = new Bruch(1, 4);

        //Ausgabe Addition
        System.out.println(bruch1.add(bruch2));
        //Ausgabe Mulitplikation
        System.out.println(bruch1.multiply(bruch2));

        String[] myArr = {"Rahmen", "sind", "toll"};
        String[] myArr2 = {"Das ist", "ein", "Test"};

        //Ausführen der printBorder Funktionen
        printBorder(myArr);
        printBorder(myArr2);

        TemperaturGraph graph = new TemperaturGraph(2021);
        // Erzeugung von Random Zahlen
        Random random = new Random();
        for(int i = 1; i < 13; i++) {
            graph.addTempratur(i, random.nextInt(25 - 10) + 10);
        }
        //Ausgabe der Zahlen
        System.out.println(graph);
        //Ausgabe der Zahlen in form eines Diagramms
        graph.plotGraph();
    }

    public static void printBorder(String[] array) {
        int longestText = 0;

        for(String text : array) {
            if(text.length() > longestText) {
                longestText = text.length();
            }
        }
        //Ausgabe des Rahmens
        System.out.println("*".repeat(longestText+4));

        for(String text : array) {
            int textLength = text.length();

            System.out.println("* " + text + " ".repeat(longestText - textLength) + " *");
        }

        System.out.println("*".repeat(longestText+4));
    }
}
