// (super) klasse persoon aanmaken
public class Persoon {
    private String name;
    private int age;
    private  String adres;

// constructor voor het maken van de basis van een persoon
    public Persoon(String name, int age, String adres) {
        this.name = name;
        this.age = age;
        this.adres = adres;
    }
// getters voor naam, leeftijd en adres van een persoon
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdres() {
        return adres;
    }

}

