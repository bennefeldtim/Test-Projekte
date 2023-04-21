import java.util.Scanner;
public class Aufgabe1a {
    static int randomNumber = (int)(Math.random() * 101.0);  //[0..100]
    static int tries = 0;

    public static void main(String[] args) {
        zahlRaten();
    }

    public static void zahlRaten(){
        tries++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte eine Zahl zwischen 0 und 100 eingeben");
        int readInt = sc.nextInt();

        if (readInt==randomNumber) {
            System.out.println("Die Zahl " + readInt + " war richtig :) Du hast " + tries + " versuche gebraucht.");
        }else {
            System.out.println("Du hast leider nicht die richtige Zahl erraten");

            if (readInt > randomNumber) {
                System.out.println("Deine Zahl ist leider zu groß");
            }else {
                System.out.println("Deine Zahl ist leider zu klein");
            }
            zahlRaten();
        }
    }

}
