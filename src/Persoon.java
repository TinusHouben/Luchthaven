public class Persoon {
    private String name;
    private int age;
    private  String adres;

    public Persoon(String name, int age, String adres) {
        this.name = name;
        this.age = age;
        this.adres = adres;
    }

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

