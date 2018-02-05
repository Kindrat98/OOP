package GroupWork;

public class AddExeption extends ArrayIndexOutOfBoundsException {
    @Override
    public String getMessage(){
        return "Out of arrayIndex";
    }
}
