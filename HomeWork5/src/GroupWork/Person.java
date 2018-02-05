package GroupWork;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String male;

    public Person(String name, String surname, int age, String male) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getMale() {
        return male;
    }

    @Override
    public String toString() {
        return "GroupWork.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", male='" + male + '\'' +
                '}';
    }
}
