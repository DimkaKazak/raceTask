package models.utils;

import interfaces.Garage;
import models.components.Engine;
import models.components.Wheel;
import models.vehicles.Car;

import java.util.Collection;
import java.util.List;

public class RaceGarage implements Garage {

    @Override
    public boolean checkWheels(Car car) {
        int counter = 0;
        for ( Wheel currWheel : car.getWheels() ) {

            if(currWheel.getFrictionCoef()  > 0.20){
                counter++;
            }

        }

        return counter == 4;
    }

    @Override
    public boolean checkEngine(Car car) {
        return true;
    }

    @Override
    public void changeWheel(Car car, Wheel wheel, int position) {
        List<Wheel> wheels = car.getWheels();
        wheels.remove(position);
        wheels.add(position, wheel);
    }

    @Override
    public void changeWheels(Car car) {
        for (int i = 0; i < car.getWheels().size(); i++){
            changeWheel(car, new Wheel(), i);
        }
    }

    @Override
    public void changeEngine(Car car, Engine engine) {
        car.setEngine(engine);
    }

    @Override
    public void deleteWheel(Car car, int position) {
        List<Wheel> wheels = car.getWheels();
        wheels.remove(position);
    }

    @Override
    public void deleteWheels(Car car) {
        List<Wheel> wheels = car.getWheels();
        wheels.removeAll(wheels);
    }

    @Override
    public void deleteEngine(Car car) {
        car.setEngine(null);
    }

}
