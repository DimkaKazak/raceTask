package models.utils;

import interfaces.CarsGenerator;
import models.factory.CarFactory;
import models.vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceCarsGenerator implements CarsGenerator {

    @Override
    public List<Car> generateCars() {
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

            car.setName( car.getName() + " " + (i + 1) );
            if (car != null) cars.add( car );
        }

        return cars;
    }

}