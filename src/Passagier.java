// sub klasse passagier om een passagier aan te maken
public class Passagier extends Persoon {
    private String ticket;
    private String bagage;

// constructor die overerft van de superklasse om een passagier aan te maken
    public Passagier(String name, int age, String adres, String ticket, String bagage) {
        super(name, age, adres);
        this.ticket = ticket;
        this.bagage = bagage;
    }
// getters voor ticket en bagage van een passagier
    public String getTicket() {
        return ticket;
    }

    public String getBagage() {
        return bagage;
    }


    }
}