public class Desk {
    private Shape[] Parts;
    private final static int N = 4;

    public Desk(){
        this.Parts = new Shape[N];
    }

    public void Add(Shape shape, int i){
        if((Parts[i] == null)&&(i >= 0)&&(i < 4))  Parts[i] = shape;
        else System.out.println("No plase at this part");
    }

    public void Remove(int i) {
        if ((i >= 0) && (i < 4)) {
            Parts[i] = null;
        }
        else System.out.println("No that place");
    }


    public double SumArea(){
        double sum = 0;
        for (int i = 0; i < 4 ; i++) {
            if(Parts[i] != null){
                sum += Parts[i].getSquare();
                System.out.println(Parts[i].toString());
            }

        }
        return sum;
    }

}
