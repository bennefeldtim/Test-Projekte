import java.util.Arrays;

public class VergleichVonArrays {

    public static void main(String[] args) {
        //Definition der beides Arrays die verglichen werden sollen
        int array1[] = {4, 5, 1, 3};
        int array2[] = {1, 5, 3, 3};
        //Ausgabe von true oder false
        System.out.println(isEqual(array1,array2));
    }

    public static boolean isEqual(int[] a, int[] b){
        //Überprüfen ob die Längen der beiden Arrays übereinstimmen
        if(a.length!=b.length){
            return false;
        }
        boolean matched = false;
        //Array Inhalte werden miteinander verglichen
        for (int elementA:a ) {
            for (int elementB: b ) {
                if(elementA == elementB){
                    matched = true;
                    break;
                }
            }
            if(matched == true){
                matched = false;
            }else{
                return false;
            }
        }
        return true;
    }
}