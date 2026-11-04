
class Main {

    // Funkcja obliczająca silnię
    static BigInteger silnia(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Silnia nie jest zdefiniowana dla liczb ujemnych."
            )
        }

        BigInteger wynik = 1

        for (int i = 1; i <= n; i++) {
            wynik *= i
        }

        return wynik
    }

    static void main(String[] args) {

        // Sprawdzenie, czy podano argumenty
        if (args.length == 0) {
            println "Błąd: Podaj przynajmniej jedną liczbę całkowitą."
            return
        }

        // Obliczanie silni dla każdego argumentu
        args.each { argument ->
            try {
                int liczba = Integer.parseInt(argument)

                if (liczba < 0) {
                    println "Błąd: Liczba ${liczba} jest ujemna."
                } else {
                    BigInteger wynik = silnia(liczba)

                    println "Silnia liczby ${liczba} wynosi: ${wynik}"
                }

            } catch (NumberFormatException e) {
                println "Błąd: Argument '${argument}' nie jest prawidłową liczbą całkowitą."
            }
        }
    }
}