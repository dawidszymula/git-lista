//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Konto k1 = new Konto("Anna Kowalska", 1000);
        KontoOszczednosciowe k2 = new KontoOszczednosciowe("Jan Nowak", 1000, 0.02 );
        KontoZDebetem k3 = new KontoZDebetem("FIRMA XYZ", 500);

        k2.naliczOdsetki();
        System.out.println(k2);


        wykonajOperacje("Wplata 100 na konto nr 3", k3.wplac(100));
        wykonajOperacje("Wyplata 300 z konta nr 3", k3.wyplac(300));
        wykonajOperacje("Wyplata 400 z konta nr 3", k3.wyplac(400));
        wykonajOperacje("Wyplata 100 z konta nr 2", k2.wyplac(100));
        wykonajOperacje("Wyplata 100 z konta nr 2", k2.wyplac(100));
        wykonajOperacje("Wyplata 100 z konta nr 2", k2.wyplac(100));


        Konto k3Konto = k3;
        wykonajOperacje("Wyplata 250 z konta nr 3 (zmienna typu Konto)", k3Konto.wyplac(250));


        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.printf("Dostepne srodki konta nr 3: %.2f%n", k3.dostepneSrodki());
        System.out.println("Konto nr 2 ma wiecej niz konto nr 3: " + (k2.maWiecejNiz(k3) ? "TAK" : "NIE"));
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());



        }

        private static void wykonajOperacje(String operacja, boolean wynik) {
            System.out.println(operacja + ": " + (wynik ? "OK" : "ODMOWA"));
        }

    }
