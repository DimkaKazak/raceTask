package race.models.utils.Garage;

import race.interfaces.garage.EngineService;
import race.models.components.engines.Engine;
import race.models.vehicles.Car;

public class RaceEngineService implements EngineService{

    /**
     * @param car - car, in what we want check engine
     * @return true, if everything okey, else false
     */
    @Override
    public boolean checkEngine(Car car) {
        return false;
    }

    /**
     * @param car - car, in what we want to change engine
     * @param engine - engine, we want to set
     */
    @Override
    public void changeEngine(Car car, Engine engine) {
        car.setEngine(engine);
    }

    /**
     * @param car - car, in what we want to deleteEngine engine
     */
    @Override
    public void deleteEngine(Car car) {
        car.setEngine(null);
    }
}
