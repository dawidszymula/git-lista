public class Samochod {
    private String marka;
    private String model;
    private int rok_produkcji;
    private int predkosc;
    private int max_Predkosc;

    public Samochod(String marka, String model, int rok_produkcji, int max_Predkosc) {
        this.marka = marka;
        this.model = model;
        this.rok_produkcji = rok_produkcji;
        this.predkosc = 0;
        this.max_Predkosc = max_Predkosc;

    }
    public int getMax_Predkosc() {
        return max_Predkosc;
    }

    public void pokazInfo() {
        System.out.println(this.toString());
    }

    public void przyspiesz(int wartosc) {
        if (wartosc > 0) {
            predkosc += wartosc;
            if (predkosc > max_Predkosc) {
                predkosc = max_Predkosc;
            }
        }
    }

    public void hamuj(int wartosc) {
        if (wartosc > 0) {
            predkosc -= wartosc;
            if (predkosc < 0) {
                predkosc = 0;
            }
        }
    }

    @Override
    public String toString(){
        return marka + " " + model + "(" + rok_produkcji + "), prędkość: " + predkosc + "km/h";
    }

}


class Main {
    public static void main(String[] args) {
        Samochod auto1 = new Samochod("Toyota", "Corolla", 2019);
        Samochod auto2 = new Samochod("Porshe", "911", 2023);
        auto1.pokazInfo();
        auto2.pokazInfo();

        auto1.przyspiesz(50);

        auto1.pokazInfo();
        auto2.pokazInfo();

        auto1.hamuj(70);
        auto1.pokazInfo();



    }
}