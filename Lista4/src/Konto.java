public class Konto {
    private final int numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbOperacji;

    private static int liczbaKont = 0;
    public static final double MAKS_WYPLATA = 5000.0;

    public Konto(String wlasciciel){
        liczbaKont++;
        this.numer = liczbaKont;

        if (wlasciciel == null || wlasciciel.trim().isEmpty()){
            this.wlasciciel = "nieznany";
        }else {
            this.wlasciciel = wlasciciel;
        }
        this.saldo = 0.0;
        this.liczbOperacji = 0;
    }

    public Konto(String wlasciciel, double saldoPoczatkowe){
        this(wlasciciel);
        if(saldoPoczatkowe > 0){
            this.saldo = saldoPoczatkowe;
        }
    }
    public static int getLiczbaKont(){ return liczbaKont; }
    public int getNumer(){ return numer; }
    public String getWlasciciel(){ return wlasciciel; }
    public double getSaldo(){ return saldo; }
    public int getLiczbOperacji(){ return liczbOperacji; }

    public boolean wplac(double kwota){
        if (kwota <= 0) return false;
        saldo+=kwota;
        liczbOperacji++;
        return true;
    }
    public boolean czyMozeWyplacic(double kwota){
        return kwota > 0 && kwota <= saldo && kwota <= MAKS_WYPLATA;
    }
    public boolean wyplac(double kwota){
        if (!czyMozeWyplacic(kwota)) return false;

        saldo -= kwota;
        liczbOperacji++;
        return true;
    }
    public boolean maWiecejNiz(Konto inneKonto){
        return this.saldo > inneKonto.saldo;
    }
    @Override
    public String toString(){
        return String.format("Konto nr %d [%s] saldo: %.2f | operacji: %d", numer, wlasciciel, saldo, liczbOperacji);
    }

}
