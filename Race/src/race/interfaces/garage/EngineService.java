package race.interfaces.garage;

import race.models.components.engines.Engine;
import race.models.vehicles.Car;

public interface EngineService {

     boolean checkEngine(Car car);
     void changeEngine(Car car, Engine engine);
     void deleteEngine(Car car);

}
