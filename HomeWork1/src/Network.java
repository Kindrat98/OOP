import java.util.ArrayList;

public class Network {
    private ArrayList<Phone> Phones;


    public Network(){
        this.Phones = new ArrayList<>();
    }

    public Network(ArrayList<Phone> Phones){
        this.Phones.addAll(Phones);
    }

    public void Add(Phone phone){
        Phones.add(phone);

    }

    public boolean Check(Phone input){
        return Phones.contains(input);
    }
}
