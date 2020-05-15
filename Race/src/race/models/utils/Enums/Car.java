package race.models.utils.Enums;

public enum Car {

    BMW("BMW"),
    DefaultCar("DefaultCar"),
    Ferrari("Ferrari"),
    Jaguar("Jaguar"),
    Lamborgini("Lamborgini"),
    Porsche("Porsche");

    private final String type;

    Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
