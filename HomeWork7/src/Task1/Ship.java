package Task1;

public class Ship implements Runnable {
    private String name;
    private int cargo;


    public Ship(String name, int cargo) {
        this.name = name;
        this.cargo = cargo;
    }

    public void setDock(Dock dock){
        dock.setBusy(true);
    }

    public String getName() {
        return name;
    }

    public void incrementCargo(){
        cargo -=1;
    }


    public int getCargo() {
        return cargo;
    }

    public Ship setCargo(int cargo) {
        this.cargo = cargo;
        return this;
    }

    @Override
    public void run() {

    }
}