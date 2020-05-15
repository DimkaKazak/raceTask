package race.interfaces;

import race.models.vehicles.Car;

import java.util.List;

public interface Supervisor {

    void startRace();
    void endRace();
    void announceTheWinner(Car car);
    void sayRaceProgress(List<Car> cars);

}
