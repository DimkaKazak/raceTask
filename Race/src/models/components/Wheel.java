package models.components;

public class Wheel extends TransportComponent {

    private double frictionCoef;

    public Wheel() {
        this.frictionCoef = 1;
    }

    public double getFrictionCoef() {
        return frictionCoef;
    }

    public void setFrictionCoef(double frictionCoef) {
        this.frictionCoef = frictionCoef;
    }
}
