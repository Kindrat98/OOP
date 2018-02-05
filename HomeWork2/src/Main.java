public class Main {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Circle s1 = new Circle(new Point(0,0), 1);
        Circle s2 = new Circle(new Point(1,1), 1);
        Rectangle r1 = new Rectangle(new Point(0,0),new Point(1,0),new Point(1,1),new Point(0,1));
        Triangle t1 = new Triangle(new Point(0,0),new Point(0,1),new Point(1,0));
        System.out.println(s1.getSquare());
        System.out.println(s2.getSquare());
        System.out.println(r1.getSquare());
        System.out.println(t1.getSquare());
        desk.Add(s1,0);
        desk.Add(s2,1);
        desk.Add(r1,2);
        desk.Add(t1,3);
        System.out.println(desk.SumArea());
        desk.Remove(2);
        System.out.println(desk.SumArea());


    }
}
