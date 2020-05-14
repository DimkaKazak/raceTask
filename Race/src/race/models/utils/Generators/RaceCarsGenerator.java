package race.models.utils.Generators;

import IO.FileConstants;
import IO.exception.UnableToReadException;
import IO.reader.PropertyFileReader;
import race.interfaces.generator.CarsGenerator;
import race.models.factory.CarFactory;
import race.models.vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RaceCarsGenerator: Singleton object ( only one for the whole race )
 */
public class RaceCarsGenerator implements CarsGenerator {


    /**
     * Realisation of Singleton pattern
     */
    private static RaceCarsGenerator instance;

    private RaceCarsGenerator(){}

    public static RaceCarsGenerator getInstance() {

        if(instance == null){
            instance = new RaceCarsGenerator();
        }

        return instance;
    }

    /**
     * @return cars, that generate with Random.class
     */
    @Override
    public List<Car> generateCarsByRandom() {
        Random random = new Random();
        List<Car> cars = new ArrayList<>();

        for (int i = 0 ; i < random.nextInt(10) ; i++){

            Car car = null;
            switch ( random.nextInt(5) ){
                case 0: car =  CarFactory.getCarByName("BMW"); break;
                case 1: car =  CarFactory.getCarByName("Ferrari"); break;
                case 2: car =  CarFactory.getCarByName("Jaguar"); break;
                case 3: car =  CarFactory.getCarByName("Lamborgini"); break;
                case 4: car =  CarFactory.getCarByName("Porsche"); break;
                default: car = CarFactory.getCarByName("Car"); break;
            }

            if (car != null){
                car.setName( car.getName() + " " + (i + 1) );
                cars.add( car );
            }

        }

        return cars;
    }

    /**
     * @param path - read from file with this path
     * @return cars, that generate with Random.class
     */
    @Override
    public List<Car> generateCarsFromProperties(String path) {
        List<Car> cars = new ArrayList<>();
        PropertyFileReader propertyFileReader = new PropertyFileReader(path);
        try {
            propertyFileReader.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }

        String[] enemyCars = propertyFileReader.getPropertyValue("enemy").split(";");
        for (String enemy : enemyCars ) {
            cars.add( CarFactory.getCarByName(enemy) );
        }

        return cars;
    }


}
