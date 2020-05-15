package race.models;

import IO.FileConstants;
import race.models.utils.*;
import race.models.utils.Garage.RaceGarage;
import race.models.utils.Generators.RaceCarsGenerator;
import race.models.utils.Generators.RaceTrackGenerator;
import race.models.utils.Points.Point2D;
import race.models.vehicles.Car;

import java.util.List;

/**
 * Contains supervisor for telling progress to user, One garage on whole race, one route and cars that participate in race
 */
public class CarRace{

    private RaceSupervisor supervisor;
    private RaceGarage garage;
    private Route route;
    private List<Car> cars;

    public CarRace(){
        this.supervisor = RaceSupervisor.getInstance();
        this.garage = RaceGarage.getInstance();
        this.route = RaceTrackGenerator.getInstance().generateRouteFromFile(FileConstants.POINTS_FILE_PATH);
        this.cars =  RaceCarsGenerator.getInstance().generateCarsFromProperties(FileConstants.PROPERTIES_FILE_PATH);

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
