public class Triangle extends Shape{
    private Point A;
    private Point B;
    private Point C;

    public Triangle(Point A, Point B, Point C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public double getPerimetr() {
        return Point.distance(A,B) + Point.distance(B,C) + Point.distance(C,A);
    }

    @Override
    public double getSquare() {
        double p = this.getPerimetr()/2;
        return Math.sqrt(p*(p - Point.distance(A,B))*(p - Point.distance(B,C))*(p - Point.distance(C,A)));
    }
    @Override
    public String toString() {
        return "It is Triangle\n";
    }
}
