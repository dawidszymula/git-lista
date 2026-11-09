//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Konto k1 = new Konto("Anna Kowalska", 1000);
        Konto k2 = new Konto("Jan Nowak" );
        Konto k3 = new Konto(" ", -50);

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        wykonajOperacje("Wplata 200 na konto nr 2", k2.wplac(200));
        wykonajOperacje("Wplata 300 z konta nr 1", k1.wplac(300));
        wykonajOperacje("Wyplata 500 z konta nr 2", k2.wyplac(500));
        wykonajOperacje("Wplata -50 na konto nr 2", k1.wplac(-50));
        wykonajOperacje("Wplata 6000 na konto nr 1", k1.wplac(6000));
        wykonajOperacje("Wyplata 6000 z konta nr 1", k1.wyplac(6000));
        wykonajOperacje("Wyplata 5000 z konta nr 1", k1.wyplac(5000));

        System.out.println();

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.println("Liczba kont: " + Konto.getLiczbaKont());
        System.out.println("Konto nr 1 ma wiecej niz konto nr 2: ");
        System.out.println(k1.maWiecejNiz(k2) ? "TAK" : "NIE");


        }

        private static void wykonajOperacje(String operacja, boolean wynik) {
            System.out.println(operacja + ": " + (wynik ? "OK" : "ODMOWA"));
        }

    }
