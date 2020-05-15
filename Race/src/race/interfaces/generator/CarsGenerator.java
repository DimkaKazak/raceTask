package race.interfaces.generator;

import race.models.vehicles.Car;

import java.util.List;

public interface CarsGenerator {

     List<Car> generateCarsByRandom();
     List<Car> generateCarsFromProperties(String path);

}
