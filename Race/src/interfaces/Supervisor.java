package interfaces;

import models.vehicles.Car;

import java.util.List;

public interface Supervisor {

    public void startRace();
    public void endRace();
    public void announceTheWinner(Car car);
    public void sayRaceProgress(List<Car> cars);

}
