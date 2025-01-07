public class Personeel extends Persoon{
    private String rol;

    public Personeel(String name, int age, String adres, String rol) {
        super(name, age, adres);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
