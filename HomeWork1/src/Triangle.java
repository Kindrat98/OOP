public class Triangle {
    private double A;
    private double B;
    private double C;

    public Triangle(){}

    public Triangle(double A, double B, double C) {
        if(isTrigtangle(A, B, C)) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
        else  new Triangle();

    }
    private final boolean isTrigtangle(Double A, Double B, Double C){
        if(A <=0 || B <=0 || C <= 0 || A + B < C || A + C < B || B + C < A){
            System.out.println("Not triangle");
            return false;
        }
        else return true;
    }

    public double Square(){
        double p = (A + B + C)/2;
        return Math.sqrt(p*(p-A)*(p-B)*(p-C));
    }
}
