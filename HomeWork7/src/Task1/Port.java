package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
    private int dockNumber;
    private ExecutorService executor;
    private List<Ship> shipList;
    private List<Dock> docks;

    public Port(int dockNumber) {
        this.dockNumber = dockNumber;
        docks = new ArrayList<>(dockNumber);
        shipList = new ArrayList<>();
        executor = Executors.newFixedThreadPool(dockNumber);
        dockInit();
    }

    public void add(Ship ship) {
        shipList.add(ship);
    }

    public void unload() {
        while (shipList.size() != 0) {
            for (int i = 0; i < docks.size(); i++) {
                for (Ship ship : shipList) {
                    if (!docks.get(i).isBusy()){
                        docks.get(i).setShip(ship);
                        executor.submit(docks.get(i));
                        shipList.remove(ship);
                    }
                    break;
                }
            }
        }
        executor.shutdown();
    }

    private void dockInit() {
        for (int i = 0; i < dockNumber; i++) {
            docks.add(new Dock());
        }
    }
}