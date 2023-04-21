public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    private int findGCD(int a, int b) {
        if (a == 0) return b;
        return findGCD(b % a, a);
    }

    //Addition des bruchs
    public Bruch add(Bruch f) {
        int nenner = findGCD(this.nenner, f.nenner);
        nenner = this.nenner * f.nenner / nenner;

        int zaehler = this.zaehler * (nenner / this.nenner) + f.zaehler * (nenner / f.nenner);

        return new Bruch(zaehler, nenner);
    }
    //Multiplikation des Bruchs
    public Bruch multiply(Bruch f) {
        return new Bruch(this.zaehler * f.zaehler, this.nenner * f.nenner);
    }

    //Umwandlung des Bruchs zu einem String
    @Override
    public String toString() {
        return this.zaehler + "/" + this.nenner;
    }
}


