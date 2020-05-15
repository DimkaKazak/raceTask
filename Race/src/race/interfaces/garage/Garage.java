package race.interfaces.garage;

import race.models.components.engines.Engine;
import race.models.components.Wheel;
import race.models.vehicles.Car;

public interface Garage {

    public boolean checkWheels(Car car);
    public boolean checkEngine(Car car);
    public void changeWheel(Car car, Wheel wheel, int position);
    public void changeWheels(Car car);
    public void changeEngine(Car car, Engine engine);
    public void deleteWheel(Car car, int position);
    public void deleteWheels(Car car);
    public void deleteEngine(Car car);

}
