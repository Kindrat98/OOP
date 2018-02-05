public class Vector {
    private double X;
    private double Y;
    private double Z;

    public Vector(){

    }
    public Vector(double X, double Y, double Z){
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    public double Scalar(Vector A, Vector B){
        return A.getX()*B.getX() + A.getY()*B.getY() + A.getZ()*B.getZ();
    }

    public Vector Plus(Vector A,Vector B){
        return new Vector(A.getX() + B.getX(),A.getY() + B.getY(), A.getZ() + B.getZ());
    }

    public Vector Multiply(Vector A, Vector B){
        double x = A.getY()*B.getZ() - A.getZ()*B.getY();
        double y = A.getZ()*B.getX() - A.getX()*B.getZ();
        double z = A.getX()*B.getY() - A.getY()*B.getX();
        return new Vector(x,y,z);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ(){
        return Z;
    }

    @Override
    public String toString() {
        return "X " + X + " Y " + Y + " Z " + Z + "\n";
    }
}
