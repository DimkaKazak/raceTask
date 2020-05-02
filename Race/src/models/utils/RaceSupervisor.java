package models.utils;

import interfaces.Supervisor;
import models.vehicles.Car;

import java.util.List;

public class RaceSupervisor implements Supervisor {

    @Override
    public void startRace() {
        System.out.println("Press ENTER to start race!");
    }

    @Override
    public void endRace() {
        System.out.println("The race is over!");
    }

    @Override
    public void announceTheWinner(Car car) {
        System.out.println(car.getName() + " OUR WINNER!");
    }

    @Override
    public void sayRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            double x = car.getPosition().getX();
            double y = car.getPosition().getY();
            System.out.println(car.getName() + ": x = " + x + " y = " + y);
        }
    }
}
