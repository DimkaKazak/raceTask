package race.models.utils.Garage;

/**
 * Garage: Singleton object ( only one for the whole race )
 */
public class RaceGarage {

    private static RaceGarage instance;

    /**
     * Realisation of Singleton pattern
     */
    private RaceGarage(RaceEngineService engineService, RaceWheelService wheelService){
        this.engineService = engineService;
        this.wheelService = wheelService;
    }

    public static RaceGarage getInstance() {
        if (instance == null){
            instance = new RaceGarage(new RaceEngineService(), new RaceWheelService() );
        }
        return instance;
    }

    /**
     * Services that Garage has
     */
    private RaceEngineService engineService;
    private RaceWheelService wheelService;

    public RaceEngineService getEngineService() {
        return engineService;
    }

    public RaceWheelService getWheelService() {
        return wheelService;
    }

}
