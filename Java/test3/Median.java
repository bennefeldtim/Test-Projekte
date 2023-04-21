import java.util.Arrays;
public class Median {

    public static void main(String[] args) {
        //Definition der Arrays mit dem Typ Integer
        int [] array = new int [] {12, 16, 2, 63, 55, 8};
        int [] array1 = new int [] {42,7,543,77,87,876,143};
        //Ausgabe des Medians der Arrays
        System.out.println(median(array));
        System.out.println(median(array1));
    }

    public static int median(int[] array){
        //Aufruf der sort() Methode
        Arrays.sort(array);
        int length = array.length;
        //Implementieren der Formel zur Berechnung des Medians
        if(length % 2 != 0){
            return array[(length)/2];
        }else{
            //integer cast
            return (int)(0.5*(array[length/2-1]+array[length/2]));
        }


    }

}