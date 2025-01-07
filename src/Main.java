import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int optie;
        do {
            System.out.println("Kies een optie:");
            System.out.println("1. Nieuwe passagier aanmaken");
            System.out.println("2. Vlucht aanmaken");
            System.out.println("3. Ticket aanmaken");
            System.out.println("4. Persoon boarden");
            System.out.println("5. Personeel toewijzen");
            System.out.println("6. Print vlucht informatie");
            optie = input.nextInt();

            if (optie <= 0 || optie > 6) {
                System.out.println("U heeft een ongeldige optie ingevoerd.");
            }
        } while (optie <= 0 || optie > 6);
    }
}