package interfaces;

import models.components.engines.Engine;
import models.vehicles.Car;

public interface EngineService {

     boolean checkEngine(Car car);
     void changeEngine(Car car, Engine engine);
     void deleteEngine(Car car);

}