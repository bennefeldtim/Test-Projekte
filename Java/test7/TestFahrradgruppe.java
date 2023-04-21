public class TestFahrradgruppe {
    private Fahrradgruppe myGroup;

    public TestFahrradgruppe() {
        // Testgruppe mit Testdaten
        this.myGroup = new Fahrradgruppe();
        this.myGroup.addFahrrad(new Fahrrad(40));
        this.myGroup.addFahrrad(new Fahrrad(10));
        this.myGroup.addFahrrad(new Fahrrad(30));
        this.myGroup.addFahrrad(new Fahrrad(20));

        this.myGroup.addLadung(50);
    }

    @Override
    public String toString() {
        Fahrrad current = this.myGroup.getStartFahrrad();
        String str = "";

        str += "Reisegeschwindigkeit " + this.myGroup.reisegeschwindigkeit() + "\n";

        while(current != null) {
            str += "Fahrrad " + current + " Speed " + current.speed() + " Ladung " + current.getLadung() + "\n";
            current = current.getNext();
        }

        return str;
    }
}
