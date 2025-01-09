import java.util.ArrayList;

/**
 * De klasse vliegtuig bevat de nodige informatie over de vlucht, passagiers en het personeel
 */
public class Vliegtuig {
    private String vluchtNummer;
    private String bestemming;
    private int economyPlaatsen;
    private int businessPlaatsen;
    private ArrayList<Passagier> passagiers;
    private ArrayList<Personeel> crewLeden;

    /**
     * constructor voor het aanmaken van een vlucht
     * @param vluchtNummer het nummer van de vlucht
     * @param bestemming de bestemming van de vlucht
     * @param economyPlaatsen de hoeveelheid economy plaatsen aanwezig zijn op het vliegtuig
     * @param businessPlaatsen de hoeveelheid business plaatsen aanwezig zijn op het vliegtuig
     */
    public Vliegtuig(String vluchtNummer, String bestemming, int economyPlaatsen, int businessPlaatsen) {
        this.vluchtNummer = vluchtNummer;
        this.bestemming = bestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
        this.passagiers = new ArrayList<>();
        this.crewLeden = new ArrayList<>();
    }


    public String getVluchtNummer() {
        return vluchtNummer;
    }

    public String getBestemming() {
        return bestemming;
    }

    /**
     * methode voor het afprinten van de vluchtinfo
     */
    public void printVluchtInformatie() {
        System.out.println("Vluchtnummer: " + vluchtNummer);
        System.out.println("Bestemming: " + bestemming);
        System.out.println("Aantal passagiers: " + passagiers.size());
        System.out.println("Aantal crewleden: " + crewLeden.size());
        System.out.println("Crewleden: ");
        for (Personeel p : crewLeden) {
            System.out.println("- " + p.getName() + " (" + p.getRol() + ")");
        }
    }

    /**
     * methode voor het toevoegen van een passagier aan een vlucht
     * @param passagier de passagier die wordt toegevoegd
     */
    public void addPassagier(Passagier passagier) {
        if (passagiers.size() < (economyPlaatsen + businessPlaatsen)) {
            passagiers.add(passagier);
            System.out.println("Passagier " + passagier.getName() + " toegevoegd aan vlucht " + vluchtNummer);
        } else {
            System.out.println("De vlucht is vol.");
        }
    }

    /**
     * methode om personeel toe te voegen aan een vlucht
     * @param personeel het personeel dat wordt toegevoegd
     */
    public void addPersoneel(Personeel personeel) {
        if (crewLeden.size() < 5) {  // Limiet voor crewleden is 5
            crewLeden.add(personeel);
            System.out.println("Personeel " + personeel.getName() + " toegevoegd aan vlucht " + vluchtNummer);
        } else {
            System.out.println("Er is al genoeg personeel op vlucht " + vluchtNummer);
        }
    }



}
