import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // scanner voor het declareren van variabelen
        Scanner input = new Scanner(System.in);
        int optie;
        // do while zodat de gebruiker een geldige optie moet ingeven
        do {
            // simpel keuzemenu voor de gebruiker
            System.out.println("Kies een optie:");
            System.out.println("1. Nieuwe passagier aanmaken");
            System.out.println("2. Vlucht aanmaken");
            System.out.println("3. Ticket aanmaken");
            System.out.println("4. Persoon boarden");
            System.out.println("5. Personeel toewijzen");
            System.out.println("6. Print vlucht informatie");
            // optie gelijkstellen aan de input van de gebruiker
            optie = input.nextInt();
            // check voor te kijken of de gebruiker een geldige optie in geeft + foutmelding indien foute input
            if (optie <= 0 || optie > 6) {
                System.out.println("U heeft een ongeldige optie ingevoerd.");
            }
            // kijken of het getal tussen de 1 en 6 ligt
        } while (optie <= 0 || optie > 6);


        switch (optie) {
            case 1:
                System.out.println("Naam");
                break;
        }
    }
}