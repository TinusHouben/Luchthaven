/**
 * de klasse passagier bevat de nodige informatie van het ticket en de bagage van de passagier
 * de klasse erft over van de persoon klasse
 */
public class Passagier extends Persoon {
    private String ticket;
    private String bagage;

    public Passagier(String name, int age, String adres, String ticket, String bagage) {
        super(name, age, adres);
        this.ticket = ticket;
        this.bagage = bagage;
    }

    public String getTicket() {
        return ticket;
    }

    public String getBagage() {
        return bagage;
    }

    public String setTicket(String ticket){
        return ticket;
    }
}