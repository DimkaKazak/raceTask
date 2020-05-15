package race.models.utils.Enums;

public enum Engine {
    BMWEngine("BMW", 0.75),
    CarEngine("Car", 0.7),
    FerrariEngine("Ferrari", 1),
    JaguarEngine("Jaguar", 0.85),
    LamborginiEngine("Lamborgini", 0.95),
    PorscheEngine("Porsche", 0.8);

    private final String type;
    private final double maxSpeed;

    Engine(String type, double maxSpeed) {
        this.type = type;
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
