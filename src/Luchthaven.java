
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Luchthaven {
    private ArrayList<Vliegtuig> vlieugtuigen;
    private ArrayList<Passagier> passagiers;

    public Luchthaven() {
        vlieugtuigen = new ArrayList<>();
        passagiers = new ArrayList<>();
    }

    /**
     * voegt een nieuwe vlucht toe aan de luchthaven
     * @param vluchtNummer
     * @param bestemming
     * @param economyPlaatsen
     * @param businessPlaatsen
     */
    public void addVliegtuig(String vluchtNummer, String bestemming, int economyPlaatsen, int businessPlaatsen) {
        Vliegtuig vliegtuig1 = new Vliegtuig(vluchtNummer, bestemming, economyPlaatsen, businessPlaatsen);
        vlieugtuigen.add(vliegtuig1);
    }

    /**
     * voegt een nieuwe passagier toe aan de luchthaven
     * @param name
     * @param age
     * @param adres
     * @param ticket
     * @param bagage
     */
    public void addPassagier(String name, int age, String adres, String ticket, String bagage) {
        if (name == null || name.isEmpty()) {
            System.out.println("Naam van passagier kan niet leeg zijn.");
            return;
        } else{
            Passagier passagier1 = new Passagier(name, age, adres, ticket, bagage);
            passagiers.add(passagier1);
            System.out.println("Passagier toegevoegd: " + passagier1.getName());

        }

    }

    /**
     * maakt een ticket voor een passagier
     * @param passagier1
     * @param klasse
     * @param vliegtuig1
     */
    public void maakTicket(Passagier passagier1, String klasse, Vliegtuig vliegtuig1) {
        // Voeg het vluchtnummer toe aan het ticket van de passagier
        String ticket = "Passagier: " + passagier1.getName() + " Klasse: " + klasse + " Vluchtnummer: " + vliegtuig1.getVluchtNummer();
        passagier1.setTicket(ticket);
    }

    /**
     * zorgt dat een passagier geboard wordt
     * @param passagier1
     * @param vliegtuig1
     */
    public void Boarding(Passagier passagier1, Vliegtuig vliegtuig1) {
        if (vliegtuig1 != null) {
            vliegtuig1.addPassagier(passagier1);
            System.out.println("Passagier " + passagier1.getName() + " is geboard!");
        } else {
            System.out.println("De vlucht is volzet of niet gevonden!");
        }
    }

    /**
     * print de informatie van een vlucht af
     * @param vliegtuig1
     */
    public void printVliegtuigInformatie(Vliegtuig vliegtuig1) {
        vliegtuig1.printVluchtInformatie();
    }

    /**
     * drukt de lijst met al de passagiers af
     */
    public void printPassagiers() {
        if (passagiers.isEmpty()) {
            System.out.println("Er zijn geen passagiers.");
        } else {
            for (Passagier passagier : passagiers) {
                System.out.println("Naam: " + passagier.getName() + ", Leeftijd: " + passagier.getAge() + ", Adres: " + passagier.getAdres() + ", Ticket: " + passagier.getTicket() + ", Bagage: " + passagier.getBagage());
            }
        }
    }

    /**
     * de basis van de applicatie met een keuzemeny waarmee de gebruiker passagiers kan aanmaken, vluchten aanmaken, tickets aanmaken
     * personen boarden , personeel toewijzen, vlucht informatie naar een txt bestand sturen en een flightcheck uitvoeren
     * @param args
     */
    public static void main(String[] args) {
        Luchthaven luchthaven = new Luchthaven();
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
            System.out.println("7. Flightcheck uitvoeren");
            System.out.println("8. Sluit programma");

            optie = input.nextInt();
            input.nextLine();

            if (optie <= 0 || optie > 7) {
                System.out.println("U heeft een ongeldige optie ingevoerd.");
            }


            switch (optie) {
                case 1:
                    System.out.println("Naam passagier: ");
                    String naam = input.nextLine();
                    System.out.println("Leeftijd: ");
                    int leeftijd = input.nextInt();
                    input.nextLine();
                    System.out.println("Adres: ");
                    String adres = input.nextLine();
                    System.out.println("Bagage (koffer, rugzak, geen: ");
                    String bagage = input.nextLine();
                    luchthaven.addPassagier(naam, leeftijd, adres, "", bagage);
                    System.out.println("U heeft succesvol een passagier aangemaakt.");
                    luchthaven.printPassagiers();

                    break;

                    case 2:
                    System.out.println("Vluchtnummer: ");
                    String vluchtNummer = input.nextLine();
                    System.out.println("Bestemming: ");
                    String bestemming = input.nextLine();
                    System.out.println("Economy plaatsen: ");
                    int economyPlaatsen = input.nextInt();
                    System.out.println("Business plaatsen: ");
                    int businessPlaatsen = input.nextInt();
                    luchthaven.addVliegtuig(vluchtNummer, bestemming, economyPlaatsen, businessPlaatsen);
                    System.out.println("U heeft succesvol een vlucht aangemaakt.");
                    break;

                    case 3:
                        System.out.println("Naam passagier: ");
                        String ticketNaam = input.nextLine();
                        System.out.println("Voer een klasse in (economy/business): ");
                        String klasse = input.nextLine();
                        System.out.println("Voer een vluchtnummer in : ");
                        String vluchtNummerTicket = input.nextLine();

                        Vliegtuig vliegtuig = luchthaven.vlieugtuigen.stream().filter(v -> v.getVluchtNummer().equals(vluchtNummerTicket)).findFirst().orElse(null);
                        Passagier passagier = luchthaven.passagiers.stream().filter(p -> p.getName().equals(ticketNaam)).findFirst().orElse(null);

                        if (vliegtuig != null && passagier != null) {
                            luchthaven.maakTicket(passagier, klasse, vliegtuig);
                            System.out.println("U heeft succesvol een ticket aangemaakt.");
                        } else {
                            System.out.println("U heeft een foute passagier of vluchtnummer ingegeven.");
                        }
                        break;


                     case 4:
                         System.out.println("Naam passagier: ");
                         String naamBoarding = input.nextLine();
                         System.out.println("Vluchtnummer: ");
                         String vluchtNummerBoarding = input.nextLine();
                         Vliegtuig vliegtuigBoarding = luchthaven.vlieugtuigen.stream().filter(vliegtuig1 -> vliegtuig1.getVluchtNummer() != null && vliegtuig1.getVluchtNummer().equals(vluchtNummerBoarding)).findFirst().orElse(null);
                         Passagier passagierBoarding = luchthaven.passagiers.stream().filter(passagier1 -> passagier1.getName() != null && passagier1.getName().equals(naamBoarding)).findFirst().orElse(null);

                         if (vliegtuigBoarding != null && passagierBoarding != null) {
                              luchthaven.Boarding(passagierBoarding, vliegtuigBoarding);
                               vliegtuigBoarding.printVluchtInformatie();
                         } else {
                              System.out.println("U heeft een foute naam of vluchtnummer ingegeven.");
                         }
                         break;


                         case 5:
                             System.out.println("Naam: ");
                             String personeelNaam = input.nextLine();
                             System.out.println("Leeftijd: ");
                             int personeelLeeftijd = input.nextInt();
                             input.nextLine();
                             System.out.println("Adres: ");
                             String personeelAdres = input.nextLine();
                             System.out.println("Rol (Piloot, Steward, Bagagepersoneel): ");
                             String rol = input.nextLine();
                             System.out.println("Vluchtnummer: ");
                             String vluchtNummerPersoneel = input.nextLine();

                             Vliegtuig vliegtuigPersoneel = luchthaven.vlieugtuigen.stream().filter(vliegtuig1 -> vliegtuig1.getVluchtNummer() != null && vliegtuig1.getVluchtNummer().equals(vluchtNummerPersoneel)).findFirst().orElse(null);

                             if (vliegtuigPersoneel != null) {
                                 Personeel personeel = new Personeel(personeelNaam, personeelLeeftijd, personeelAdres, rol);
                                 vliegtuigPersoneel.addPersoneel(personeel);
                                 System.out.println("U heeft een personeelslid aan de vlucht toegevoegd.");
                             } else {
                                 System.out.println("U heeft een fout vluchtnummer ingegeven.");
                             }
                             break;

                         case 6:
                             System.out.println("De vlucht informatie is bezig met opslaan in Vluchten.txt...");

                             try (BufferedWriter writer = new BufferedWriter(new FileWriter("Vluchten.txt"))) {

                                 if (luchthaven.passagiers.isEmpty()) {
                                     writer.write("Er zijn geen passagiers.\n");
                                 } else {

                                     for (Passagier p : luchthaven.passagiers) {1
                                         String vluchtnummerUitTicket = "11";

                                         if (p.getTicket() != null && !p.getTicket().isEmpty()) {
                                             int index = p.getTicket().indexOf("Vluchtnummer:");
                                             if (index != -1) {
                                                 vluchtnummerUitTicket = p.getTicket().substring(index + 14).trim();  // 14 is de lengte van "Vluchtnummer: "
                                             }
                                         }

                                         writer.write("Naam: " + p.getName() + "\n");
                                         writer.write("Leeftijd: " + p.getAge() + "\n");
                                         writer.write("Adres: " + p.getAdres() + "\n");
                                         writer.write("Ticket: " + p.getTicket() + "\n");
                                         writer.write("Bagage: " + p.getBagage() + "\n");
                                         writer.write("Vluchtnummer: " + vluchtnummerUitTicket + "\n");
                                     }
                                 }

                                 System.out.println("De vluchtinformatie is succesvol opgeslagen in Vluchten.txt.\n");

                             } catch (IOException e) {
                                 System.out.println("Er is een fout opgetreden bij het schrijven naar het bestand.");
                                 e.printStackTrace();
                             }

                             break;

                        case 7:
                            System.out.println("Vluchtnummer: ");
                            String vluchtNummerFlightCheck = input.nextLine();

                            Vliegtuig vliegtuigFlightCheck = luchthaven.vlieugtuigen.stream().filter(v -> v.getVluchtNummer().equals(vluchtNummerFlightCheck)).findFirst().orElse(null);

                            if (vliegtuigFlightCheck != null) {
                                System.out.println("Flightcheck voor vlucht " + vluchtNummerFlightCheck + " was succesvol.");
                            } else {
                                System.out.println("Je hebt een fout vluchtnummer ingegeven.");
                            }
                            break;


                        case 8:
                            System.out.println("U heeft de applicatie succesvol gesloten.");
                            break;

                        default:
                            System.out.println("Er is iets fout gegaan.");
                            break;

            }
                    } while (optie != 8);
    }
}