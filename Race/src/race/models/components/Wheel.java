package race.models.components;

public class Wheel extends TransportComponent {

    private double frictionCoef;

    public Wheel(double frictionCoef) {
        this.frictionCoef = frictionCoef;
    }

    public double getFrictionCoef() {
        return frictionCoef;
    }

    public void setFrictionCoef(double frictionCoef) {
        this.frictionCoef = frictionCoef;
    }
}
