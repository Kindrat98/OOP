public class Cat {
    private int Weight;
    private int Age;
    private String Name;


    public Cat(int age, int weight, String name) {
        this.Age = age;
        this.Name = name;
        this.Weight = weight;
    }

    public void May(){
        System.out.println("Myu");
    }

    public void Eat(int food){
        this.Weight += food/4;
    }

    public void Sleep(int time){
        if(time > 22 || time < 7) System.out.println("I go to sleep");
        else System.out.println("I dont want to sleep");

    }
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Age is " + Age + " Weight is " + Weight + " Name is " + Name + "\n";
    }
}
