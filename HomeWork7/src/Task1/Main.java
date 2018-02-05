package Task1;
public class Main {
    public static void main(String[] args) {
        Port port = new Port(2);
        port.add(new Ship("BlackPearl",10));
        port.add(new Ship("GreenDuck",10));
        port.add(new Ship("BlueCat",10));
        port.unload();
    }
}