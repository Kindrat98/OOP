package Task1;

public class Dock implements Runnable {
    private boolean isBusy;
    private Ship ship;

    public Dock() {
    }

    public boolean isBusy() {
        return isBusy;
    }


    public synchronized void  setBusy(boolean busy) {
        isBusy = busy;
    }

    public synchronized void setShip(Ship ship) {
        this.ship = ship;
        setBusy(true);
    }


    @Override
    public synchronized void run() {
        int DELAY = 500;
        while (ship.getCargo() > 0) {
            ship.incrementCargo();
            System.out.println(ship.getName() + " " + ship.getCargo());
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                setBusy(false);
            }
        }
    }
}