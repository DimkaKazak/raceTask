package models.utils.Garage;

import interfaces.WheelService;
import models.components.Wheel;
import models.vehicles.Car;

import java.util.List;

public class RaceWheelService implements WheelService {

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
    public void changeWheel(Car car, Wheel wheel, int position) {
        List<Wheel> wheels = car.getWheels();
        wheels.remove(position);
        wheels.add(position, wheel);
    }

    @Override
    public void changeWheels(Car car, List<Wheel> wheels) {

        if (wheels == null || wheels.isEmpty()){
            for (int i = 0; i < car.getWheels().size(); i++){
                changeWheel(car, new Wheel(1), i);
            }
        } else {
            for (int i = 0; i < wheels.size(); i++){
                changeWheel(car, wheels.get(i), i);
            }
        }

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

}
