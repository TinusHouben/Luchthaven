import java.util.ArrayList;
// subklasse vliegtuig aanmaken
public class Vliegtuig extends Persoon{
    private String vluchtnummer;
    private String bestemming;
    private int economyPlaatsen;
    private int businessPlaatsen;
    // arraylist waar de passagier van het vliegtuig in staan
    private ArrayList<Passagier> passagiers;
    // arraylist waar de personeelsleden van het vliegtuig in staan
    private ArrayList<Personeel> crewLeden;

// constructor voor het aanmaken van een vliegtuig
    public Vliegtuig(String vluchtnummer, String bestemming, int economyPlaatsen, int businessPlaatsen){
        this.vluchtnummer = vluchtnummer;
        this.bestemming = bestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
        this.passagiers = new ArrayList<>();
        this.crewLeden = new ArrayList<>();
    }
// getters voor de bestemming en het vluchtnummer
    public String getVluchtnummer() {
        return vluchtnummer;
    }

    public String getBestemming() {
        return bestemming;
    }

    // methode om de vluchtinformatie af te printen
    public void printVluchtInformatie() {
        System.out.println("Vluchtnummer: " + vluchtnummer);
        System.out.println("Bestemming: " + bestemming);
        System.out.println("Passagiers aantal: " + passagiers.size());
        System.out.println("Crew aantal: " + crewLeden.size());
    }

    // methode om een passagier toe te voegen aan het vliegtuig
    public void addPassagier(Passagier passagier){
        // if lus om te kijken of er nog plaatsen vrij zijn
        if (passagiers.size() < (economyPlaatsen + businessPlaatsen)) {
            passagiers.add(passagier);

        } else {
            // foutmelding als er geen plaatsen meer zijn
            System.out.println("Het vliegtuig is vol");
        }
    }

    // methode om crewleden aan de vlucht toe te voegen
    public void addCrew(Personeel personeel){
        // if lus om te kijken of er niet te veel crewleden zijn
        if (crewLeden.size() >= 5) {
            crewLeden.add(personeel);
            System.out.println("Crew lid toegevoegd");
        } else
            {
                // foutmelding als er al te veel crewleden zijn
            System.out.println("Er zijn al genoeg crewleden");
            }

    }
}
