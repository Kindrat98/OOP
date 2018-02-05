public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(5, 5,"Mursil");
        Cat cat2 = new Cat(2, 9,"Vasa");
        System.out.println(cat1.toString());
        cat1.Eat(15);
        cat1.May();
        cat1.Sleep(15);
        System.out.println(cat1.toString());
        Triangle t1 = new Triangle(0,0,1);
        System.out.println(t1.Square());
        Triangle t2 = new Triangle(3,4,5);
        System.out.println(t2.Square());
        Vector v1 = new Vector(0,1, 0);
        Vector v2 = new Vector(1,0,0);
        Vector v3 = new Vector();
        v3 = v3.Multiply(v2,v1);
        System.out.println(v3.toString());
        Phone p1 = new Phone("51427", "NOKIA X7");
        Phone p2 = new Phone("46256", "Iphone 7");
        Phone p3 = new Phone("15526", "Iphone 7");
        Network network = new Network();
        p1.Registr(network);
        p2.Registr(network);
        p3.Registr(network);
        p1.Call(p2,network);
        Phone p4 = new Phone("15248", "Iphone 6");
        p4.Call(p1,network);


    }
}
