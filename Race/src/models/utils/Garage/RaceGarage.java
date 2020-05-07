package models.utils.Garage;

public class RaceGarage {

    private static RaceGarage instance;

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

    private RaceEngineService engineService;
    private RaceWheelService wheelService;

    public RaceEngineService getEngineService() {
        return engineService;
    }

    public RaceWheelService getWheelService() {
        return wheelService;
    }

}
