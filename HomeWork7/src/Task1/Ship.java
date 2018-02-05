package Task1;

public class Ship implements Runnable {
    private String name;
    public int cargo;


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


    @Override
    public void run() {

    }
}