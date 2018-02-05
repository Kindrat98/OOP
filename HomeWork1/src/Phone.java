public class Phone {
    private String Number;
    private String Model;

    public Phone(String Number, String Model){
        this.Model = Model;
        this.Number = Number;
    }

    public void Registr(Network network){
        network.Add(this);
    }

    public void Call(Phone phone, Network network){
        if(network.Check(phone)&&network.Check(this)) System.out.println("Calling");
        else System.out.println("No number or you is not in network");
    }

    public String getNumber() {
        return Number;
    }


    public boolean equals(Phone phone) {
        if (this == phone) return true;

        if (phone == null) return false;

        return this.Number.equalsIgnoreCase(phone.getNumber());
    }

    @Override
    public int hashCode() {
        return Number.hashCode();
    }
}
