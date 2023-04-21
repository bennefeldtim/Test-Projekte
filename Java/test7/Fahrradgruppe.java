public class Fahrradgruppe {
    private Fahrrad startFahrrad;

    public Fahrradgruppe() {
        this.startFahrrad = null;
    }

    // Einfügen eines neuen Fahrrads
    public void addFahrrad(Fahrrad f) {
        if(this.startFahrrad == null) {
            this.startFahrrad = f;
            return;
        }

        f.setNext(this.startFahrrad);
        this.startFahrrad = f;
    }

    public Fahrrad getStartFahrrad() {
        return startFahrrad;
    }

    // Berechnung der geringsten Reisegeschwindigkeit aller Fahrräder
    public int reisegeschwindigkeit() {
        int lowest = Integer.MAX_VALUE;

        Fahrrad current = this.startFahrrad;

        while(current != null) {
            if(current.speed() < lowest) lowest = current.speed();
            current = current.getNext();
        }

        return lowest;
    }

    // Hinzufügung neuer Säcke
    public void addLadung(int anzahl) {
        int fahrradCount = 0;
        Fahrrad current = startFahrrad;
        while (current != null) {
            fahrradCount++;
            current = current.getNext();
        }
        // Verteilung der Ladung auf alle Fahrräder

        int sacksPerBike = anzahl / fahrradCount;
        current = startFahrrad;
        while (current != null) {
            current.addLadung(sacksPerBike);
            current = current.getNext();
        }

        int remainingSacks = anzahl % fahrradCount;
        if (remainingSacks > 0 && startFahrrad != null) {
            startFahrrad.addLadung(remainingSacks);
        }
    }
}
