public class MyList {
    public int array[];

    MyList(int array[]) {
        this.array = array;
    }

    public void addToList(int index, int item) {
        //Ist der Wert zu groß oder zu klein erscheint eine Fehlermeldung
        if(index > this.array.length || index < 0) {
            throw new RuntimeException("Index out of bounce");
        }
        //Der Index wird um eins erhöht
        int newArray[] = new int[this.array.length+1];

        for(int i = 0; i<this.array.length; i++) {
            if(index == i) {
                //Neues Element wird hinzugefügt und der Index um eins erhöht
                newArray[i] = item;
                newArray[i+1] = this.array[i];
            } else if(i > index) {
                newArray[i+1] = this.array[i];
            } else {
                newArray[i] = this.array[i];
            }
        }

        if(newArray.length - 1 == index) {
            newArray[index] = item;
        }

        this.array = newArray;
    }

    public void removeFromList(int index) {
        //Überprüfen ob der Index außerhalb des Bereiches ist
        if(index > this.array.length || index < 0) {
            throw new RuntimeException("Index out of bounce");
        }
        //Die Länge der Arrayliste wird um eins reduziert
        int newArray[] = new int[this.array.length-1];

        for(int i = 0; i<this.array.length-1; i++) {
            if(i >= index) {
                newArray[i] = this.array[i+1];
            } else {
                newArray[i] = this.array[i];
            }
        }

        this.array = newArray;
    }

    public int removeDuplicates() {
        int counter = 0;

        //Entfernen der Duplikate
        for(int i = 0; i < this.array.length; i++) {
            for(int j = 0; j < this.array.length; j++) {
                if(this.array[i] == this.array[j] && i != j) {
                    counter += 1;
                    this.removeFromList(j);
                }
            }
        }

        return counter;
    }

    public void sortList() {
        //Einträge werden der größe nach sortiert
        for(int i = 0; i < this.array.length; i++) {
            int smallestNumber = Integer.MAX_VALUE;
            int smallestNumberIndex = -1;

            for(int j = i; j < this.array.length; j++) {
                if(this.array[j] < smallestNumber) {
                    smallestNumber = this.array[j];
                    smallestNumberIndex = j;
                }
            }

            this.array[smallestNumberIndex] = this.array[i];
            this.array[i] = smallestNumber;
        }
    }

    public void kombiZahl(int zahl) {
        //Ermittlung aller Kombinationen aus drei Zahlen, welche die gleiche Summe wie die Varibale Zahl besitzem
        for(int i = 0; i < this.array.length; i++) {
            for(int j = 0; j < this.array.length; j++) {
                for(int k = 0; k < this.array.length; k++) {
                    if(this.array[i] + this.array[j] + this.array[k] == zahl) {
                        System.out.println("Kombination: " + this.array[i] + " " + this.array[j] + " " + this.array[k]);
                    }
                }
            }
        }
    }

    public String toString() {
        String output = "";

        for(int element : this.array) {
            output += element + " ";
        }

        return output;
    }
}
