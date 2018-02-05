public class Rectangle extends Shape{
    private Point A;
    private Point B;
    private Point C;
    private Point D;

    public Rectangle(Point A, Point B, Point C, Point D){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }


    @Override
    public double getPerimetr() {
        return Point.distance(A,B) + Point.distance(B,C) + Point.distance(C,D) + Point.distance(D,A);
    }

    @Override
    public double getSquare() {
        double a = Math.pow(Point.distance(A,B),2);
        double b = Math.pow(Point.distance(B,C),2);
        double c = Math.pow(Point.distance(C,D),2);
        double d = Math.pow(Point.distance(D,A),2);
        double e = Math.pow(Point.distance(A,C),2);
        double f = Math.pow(Point.distance(D,B),2);
        return Math.sqrt(4*e*f - Math.pow((b + d - a - c), 2))/4;
    }

    @Override
    public String toString() {
        return "It is Rectangle\n";
    }
}