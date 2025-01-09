/**
 * de klasse personeel bevat de nodige informatie over de rol dan het personeelslid
 * de klasse erft over van de klasse persoon
 */
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
