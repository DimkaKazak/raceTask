package models.utils.Garage;

import interfaces.EngineService;
import models.components.Engine;
import models.vehicles.Car;

public class RaceEngineService implements EngineService{

    @Override
    public boolean checkEngine(Car car) {
        return false;
    }

    @Override
    public void changeEngine(Car car, Engine engine) {
        car.setEngine(engine);
    }

    @Override
    public void deleteEngine(Car car) {
        car.setEngine(null);
    }
}
