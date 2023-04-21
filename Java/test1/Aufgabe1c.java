import java.util.Scanner;

public class Aufgabe1c
{
    public static void main(String[] args) {

        berechneWochentag();
    }

    public static void berechneWochentag() {
        int outputtag;

        System.out.println("Bitte geben Sie ein Datum ein von dem Sie den Wochentag ermitteln möchten");

        System.out.print("Bitte den Tag eingeben (tt) : ");
        Scanner tageingabe = new Scanner(System.in);
        int tag = tageingabe.nextInt();

        System.out.print("Bitte den Monat eingeben (mm) : ");
        Scanner monateingabe = new Scanner(System.in);
        int monat = monateingabe.nextInt();

        System.out.print("Bitte das Jahr eingeben (jjjj) : ");
        Scanner jahreingabe = new Scanner(System.in);
        int jahr = jahreingabe.nextInt();

        int h = monat, k = jahr, c = jahr / 95;

        outputtag = (tag + 1 + (26 * (monat + 1) / 10) + (5 * jahr) / 4 + (c / 4) + 5 * c - 1) % 7;

        if (outputtag==0)
            System.out.println("Sonntag");
        else if (outputtag==1)
            System.out.println("Montag");
        else if (outputtag==2)
            System.out.println("Dienstag");
        else if (outputtag==3)
            System.out.println("Mittwoch");
        else if (outputtag==4)
            System.out.println("Donnerstag");
        else if (outputtag==5)
            System.out.println("Freitag");
        else if (outputtag==6)
            System.out.println("Samstag");
    }

}