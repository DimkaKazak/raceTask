package race.models.utils;

import race.interfaces.Supervisor;
import race.models.vehicles.Car;

import java.util.List;


/**
 * This class observes all process of the race and tell results to user
 */
public class RaceSupervisor implements Supervisor {

    /**
     * Realisation of Singleton pattern
     */
    private static RaceSupervisor instance;

    private RaceSupervisor(){}

    public static RaceSupervisor getInstance(){
        if(  instance == null){
            instance = new RaceSupervisor();
        }
        return instance;
    }

    @Override
    public void startRace() {
        System.out.println("Press ENTER to start race!");
    }

    @Override
    public void endRace() {
        System.out.println("The race is over!");
    }

    @Override
    public void announceTheWinner(Car car) {
        System.out.println(car.getName() + " OUR WINNER!");
    }

    @Override
    public void sayRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            double x = car.getPosition().getX();
            double y = car.getPosition().getY();
            System.out.println(car.getName() + ": x = " + x + " y = " + y);
        }
    }
}
