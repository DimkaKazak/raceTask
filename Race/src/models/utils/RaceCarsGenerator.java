package models.utils;

import interfaces.CarsGenerator;
import models.components.Engine;
import models.components.Wheel;
import models.vehicles.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceCarsGenerator implements CarsGenerator {

    @Override
    public List<Car> generateCars() {
        Random random = new Random();
        List<Car> cars = new ArrayList<>();
        for (int i = 0 ; i < random.nextInt(10) ; i++){
            String carName = random.nextBoolean() ?  "BMW" + (i + 1): "Ferrari" + (i + 1);

            Engine carEngine;
            if ( carName.equals("BMW" + (i+1)) ){
                carEngine = new Engine(0.8);
            } else {
                carEngine = new Engine(1);
            }

            List<Wheel> wheels = new ArrayList<>();
            for (int j = 0 ; j < 4 ; j++){
                wheels.add( new Wheel() );
            }

            cars.add( new Car(carName, carEngine, wheels) );
        }

        return cars;
    }

}
