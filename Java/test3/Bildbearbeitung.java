
public class Bildbearbeitung {
    public static void main(String[] args) {
        //Definieren von Arrays
        int array[][] = {
                {0,0,1,1,0},
                {0,1,0,1,1},
                {1,0,0,1,1},
                {0,1,0,1,0}
        };
        Bild bild = new Bild(array);
        System.out.println("Originalbild");
        //Ausgabe des Original Arrays
        bild.ausgabe();
        //Array wird inventiert
        bild.flipAndInvert();
        System.out.println("Bild nach flipAndinvert()");
        //Inventierten Array ausgeben
        bild.ausgabe();
    }
}
