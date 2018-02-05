public class Circle extends Shape{
    private Point Center;
    private double Radius;

    public Circle(Point Center, double Radius){
        this.Center = Center;
        this.Radius = Radius;
    }

    @Override
    public double getPerimetr() {
        return 2*Math.PI*Radius;
    }

    @Override
    public double getSquare() {
        return Math.PI*Radius*Radius;
    }

    @Override
    public String toString() {
        return "It is Circle\n";
    }
}
