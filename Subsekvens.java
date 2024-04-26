class Subsekvens { // lager klassen 
    public final String subsekvens; // tar inn en subsekvens 
    private int antall; // antall 

    public Subsekvens(String subsekvens, int antall) { // kontroktør med instansvaribaler 
        this.subsekvens = subsekvens; 
        this.antall = antall;

    }

    public int hent() { // henter antaller 
        return antall;

    }

    public void endre(int forekomst) { // endrer forekomsten 
        antall = forekomst; // antall blir forekomsten 

    }

    @Override
    public String toString() {  // lager en to string for for å skrive ut objektet etter på 
        return "("+ subsekvens  + ","+  antall + ")";

    }

}