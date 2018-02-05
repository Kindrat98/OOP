public class Point {
    private double X;
    private double Y;

    public Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public static double distance(Point A, Point B){
        return Math.sqrt(Math.pow((A.getX()- B.getX()),2) + Math.pow((A.getY()- B.getY()),2));
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }


}