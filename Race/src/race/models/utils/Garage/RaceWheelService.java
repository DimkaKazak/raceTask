package race.models.utils.Garage;

import race.interfaces.garage.WheelService;
import race.models.components.Wheel;
import race.models.vehicles.Car;

import java.util.List;

public class RaceWheelService implements WheelService {

    /**
     * @param car - car in what we want to check wheels
     * @return true, if everything okay, else false
     */
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

    /**
     * @param car - car in what we want to change wheels
     * @param wheel - wheel we want to change
     * @param position - 1,2,3,4 wheel's position in car
     */
    @Override
    public void changeWheel(Car car, Wheel wheel, int position) {
        List<Wheel> wheels = car.getWheels();
        wheels.remove(position);
        wheels.add(position, wheel);
    }

    /**
     * @param car - car in what we want to check wheels
     * @param wheels - wheels we want to change
     */
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

    /**
     * @param car - car in what we want to delete wheel
     * @param position - 1,2,3,4 wheel's position in car
     */
    @Override
    public void deleteWheel(Car car, int position) {
        List<Wheel> wheels = car.getWheels();
        wheels.remove(position);
    }

    /**
     * @param car - car in what we want to delete wheels
     */
    @Override
    public void deleteWheels(Car car) {
        List<Wheel> wheels = car.getWheels();
        wheels.removeAll(wheels);
    }

}
