public class Fahrrad {
    // Variablen deklarieren
    private Fahrrad next;
    private int ladung;
    private int maxSpeed;

    public Fahrrad(int maxSpeed) {
        this.next = null;
        this.maxSpeed = maxSpeed;
    }

    public Fahrrad getNext() {
        return next;
    }

    public void setNext(Fahrrad next) {
        this.next = next;
    }

    public int getLadung() {
        return ladung;
    }

    public void addLadung(int ladung) {
        this.ladung += ladung;
    }

    public int speed() {
        return Math.max(0, this.maxSpeed - this.ladung);
    }
}
