public class Main {
    public static void main(String[] args) {
        //Arrayliste Initialisieren
        MyList MyList = new MyList(new int[]{43, 1, 1, 1, 75, 5, 5, 7, 10, 7, 8, 4, 33, 1, 7, 6});
        //Ausgabe der Arrayliste
        System.out.println(MyList);


        //Eigene Tests, um funktionalitäten der Funktionen zu testen

        /*
        MyList.addToList(5, 99);
        System.out.println(MyList);
        MyList.removeFromList(5);
        System.out.println(MyList);
        MyList.addToList(5, 99);
        System.out.println(MyList);
        System.out.println(MyList.removeDuplicates());
        System.out.println(MyList);
         */

        //Arrayliste wird sortiert
        MyList.sortList();
        // Sortierte Arrayliste wird ausgegeben
        System.out.println(MyList);
        MyList.kombiZahl(25);
    }
}
