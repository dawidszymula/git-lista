public class KontoOszczednosciowe extends Konto {
    private double oprocentowanie;
    private int liczbaWyplat;

    public static int LIMIT_WYPLAT = 2;

    public KontoOszczednosciowe(String wlasciciel, double oprocentowanie) {
        super(wlasciciel);
        this.oprocentowanie = Sprawdzenie(oprocentowanie);
        this.liczbaWyplat = 0;
    }

    public KontoOszczednosciowe(String wlasciciel, double saldoPoczatkowe, double oprocentowanie) {
        super(wlasciciel, saldoPoczatkowe);
        this.oprocentowanie = Sprawdzenie(oprocentowanie);
        this.liczbaWyplat = 0;

    }

    private double Sprawdzenie(double opr){
        if(opr < 0.0 || opr > 0.10){
            return 0.0;
        }
        return opr;
    }
    public double getOprocentowanie() { return oprocentowanie; }
    public int getLiczbaWyplat() { return liczbaWyplat; }

    public void naliczOdsetki(){
        double noweSaldo = getSaldo() + (getSaldo() * oprocentowanie);
        ustawSaldo(noweSaldo);
    }
    @Override
    public boolean czyMozeWyplacic(double kwota){
        return liczbaWyplat < LIMIT_WYPLAT && super.czyMozeWyplacic(kwota);
    }
    @Override
    public boolean wyplac(double kwota){
        if (super.wyplac(kwota)){
            liczbaWyplat++;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" | oszczednosciowe %.2f%%, wyplat: %d/%d", oprocentowanie * 100, liczbaWyplat, LIMIT_WYPLAT);

        }


}
