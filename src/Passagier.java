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

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}