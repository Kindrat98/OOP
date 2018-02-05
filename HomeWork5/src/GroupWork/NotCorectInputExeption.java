package GroupWork;

public class NotCorectInputExeption extends Exception {
    @Override
    public String getMessage() {
        return "You entered not corect Data";
    }
}
