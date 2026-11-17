public class KontoZDebetem extends Konto{
    private double limitDebetu;

    public KontoZDebetem(String wlasiciel, double limitDebetu) {
        super(wlasiciel);
        this.limitDebetu = (limitDebetu > 0) ? limitDebetu : 0.0;

    }
    public double dostepneSrodki(){
        return getSaldo() + limitDebetu;
    }
    @Override
    public boolean czyMozeWyplacic(double kwota){
        return kwota > 0 && kwota <= MAKS_WYPLATA && kwota <= dostepneSrodki();
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" | z debetem, limit %.2f", limitDebetu);

    }
}
