package models;

import models.utils.*;
import models.vehicles.Car;

import java.util.List;

public class CarRace{

    private RaceSupervisor supervisor;
    private RaceGarage garage;
    private Route route;
    private List<Car> cars;

    public CarRace(){
        this.supervisor = new RaceSupervisor();
        this.garage = new RaceGarage();
        this.route = new RaceTrackGenerator().generateRoute();
        this.cars = new RaceCarsGenerator().generateCars();

        Point2D startPoint = route.getVectors().get(0);
        for (Car car : cars ) {
            car.getPosition().setX( startPoint.getX() );
            car.getPosition().setY( startPoint.getY() );
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public RaceGarage getGarage() {
        return garage;
    }

    public RaceSupervisor getSupervisor() {
        return supervisor;
    }

    public Route getRoute() {
        return route;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setGarage(RaceGarage garage) {
        this.garage = garage;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setSupervisor(RaceSupervisor supervisor) {
        this.supervisor = supervisor;
    }
}
