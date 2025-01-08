// sub klasse personeel om een crewlid aan te maken en een rol toe te voegen
public class Personeel extends Persoon{
    private String rol;

// constructor die overerft van de super klasse die een crewlid aanmaakt
    public Personeel(String name, int age, String adres, String rol) {
        super(name, age, adres);
        this.rol = rol;
    }
// getter vpor de rol
    public String getRol() {
        return rol;
    }
}
