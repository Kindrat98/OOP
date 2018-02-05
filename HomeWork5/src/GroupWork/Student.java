package GroupWork;

public class Student extends Person {

    private int average;

    public Student(String name, String surname, int age, String male, int average)
    {
        super(name, surname, age, male);
        this.average =  average;
    }

    @Override
    public String toString() {
        return "GroupWork.Student" + super.toString() + " Average " + average + "\n";
    }

    public int getAverage() {
        return average;
    }

    public Student setAverage(byte average) {
        this.average = average;
        return this;
    }
}
