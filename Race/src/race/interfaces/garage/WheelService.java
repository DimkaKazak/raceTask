package race.interfaces.garage;

import race.models.components.Wheel;
import race.models.vehicles.Car;

import java.util.List;

public interface WheelService {

      boolean checkWheels(Car car);
      void changeWheel(Car car, Wheel wheel, int position);
      void changeWheels(Car car, List<Wheel> wheels);
      void deleteWheel(Car car, int position);
      void deleteWheels(Car car);

}
