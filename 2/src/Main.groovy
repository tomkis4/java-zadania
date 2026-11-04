
import java.util.Scanner

class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in)

        // Pobranie nazwy lub ścieżki pliku od użytkownika
        print "Podaj nazwę pliku lub ścieżkę do pliku: "
        String sciezka = scanner.nextLine()

        File plik = new File(sciezka)

        println "\n================================="
        println "       OBSŁUGA PLIKÓW GROOVY"
        println "================================="

        // Menu wyboru operacji
        println "Wybierz operację:"
        println "1 - Odczytaj zawartość pliku"
        println "2 - Dopisz tekst do pliku"
        println "3 - Odczytaj i dopisz tekst"
        println "4 - Zakończ program"

        print "Twój wybór: "
        String wybor = scanner.nextLine()

        switch (wybor) {

            case "1":
                // Odczytywanie pliku
                odczytajPlik(plik)
                break

            case "2":
                // Dopisywanie tekstu
                dopiszTekst(plik, scanner)
                break

            case "3":
                // Odczytanie i dopisanie tekstu
                odczytajPlik(plik)
                dopiszTekst(plik, scanner)
                break

            case "4":
                println "Zakończono program."
                break

            default:
                println "Nieprawidłowy wybór operacji."
        }

        scanner.close()
    }

    // Funkcja odczytująca zawartość pliku
    static void odczytajPlik(File plik) {

        println "\n--- ODCZYT PLIKU ---"

        if (plik.exists()) {

            try {
                String zawartosc = plik.getText("UTF-8")

                println "Zawartość pliku:"
                println zawartosc

            } catch (Exception e) {
                println "Błąd podczas odczytu pliku: ${e.message}"
            }

        } else {
            println "Plik nie istnieje."
        }
    }

    // Funkcja dopisująca tekst do pliku
    static void dopiszTekst(File plik, Scanner scanner) {

        println "\n--- DOPISYWANIE TEKSTU ---"

        try {

            // Sprawdzenie, czy plik istnieje
            if (!plik.exists()) {
                plik.createNewFile()
                println "Utworzono nowy plik."
            }

            print "Wpisz tekst, który chcesz dodać: "

            String nowyTekst = scanner.nextLine()

            // Dopisanie tekstu na końcu pliku
            plik.append(
                    nowyTekst + System.lineSeparator(),
                    "UTF-8"
            )

            println "Tekst został pomyślnie dopisany do pliku."

        } catch (Exception e) {
            println "Błąd podczas zapisywania pliku: ${e.message}"
        }
    }
}
