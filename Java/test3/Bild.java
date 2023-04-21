import java.util.ArrayList;

public class Bild {
    private int bild[][];

    public Bild(int bild[][]) {
        this.bild = bild;
    }
    public Bild flipAndInvert(){
        //Neue Arrayliste wird erstellt
        ArrayList<int[]> newBild = new ArrayList<>();
        for(int i = this.bild.length-1; i>=0; i--){
            for(int y = 0 ;y<this.bild[i].length;y++){
                this.bild[i][y] = this.bild[i][y] ^1;
            }
            newBild.add(this.bild[i]);
        }
        //Konventieren von Arrayliste zu Array
        this.bild = newBild.toArray(new int[0][]);
        return this;
    }
    public void ausgabe(){
        //Ausgabe des Arrays
        for(int row[]: this.bild){
            for(int element: row){
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }
    }
}
