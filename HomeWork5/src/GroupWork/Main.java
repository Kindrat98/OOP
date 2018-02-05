package GroupWork;

import GroupWork.Group;

public class Main {
    public static void main(String[] args) {
        Group ka51 = new Group();
        Student s1 = new Student("Ivan", "Korol", 18, "M" ,85);
        Student s2 = new Student("Ivan", "Avran", 16, "M",75);
        Student s3 = new Student("Ivan", "Fytv", 18, "M",90);
        Student s4 = new Student("Ivan", "Kffl", 18, "M",75);
        Student s5 = new Student("Ivan", "Kil", 17, "M",75);
        Student s6 = new Student("Jonn", "Loll", 18, "M",98);
        Student s7 = new Student("Suzana", "Koroll", 18, "F",90);
        Student s8 = new Student("Ivan", "Korol", 18, "M",74);
        Student s9 = new Student("Ivan", "Gin", 19, "M",70);
        Student s10 = new Student("Ivan", "Gini", 19, "M",80);
        Student s11 = new Student("Ivanka", "Gina", 19, "F",95);
        ka51.add(s1);
        ka51.add(s2);
        ka51.add(s3);
        ka51.add(s4);
        ka51.add(s5);
        ka51.add(s6);
        ka51.add(s7);
        ka51.add(s8);
        ka51.add(s9);
        ka51.add(s10);
        ka51.add(s11);
        System.out.println(ka51.toString());
        ka51.remove(5);
        ka51.writeToFile("GroupResult.txt");
        System.out.println(ka51.toString());
        System.out.println("Army\n");
        Student[] army = ka51.areReadyToArmy();
        for (Student item:army ) {
            if (item != null){
                System.out.println(item);
            }
        }
        Group copy = new Group();
        Group.reagFromFile("GroupResult.txt",copy);
        System.out.println("Copy of last \n \n");
        System.out.println(copy.toString());
    }
}
