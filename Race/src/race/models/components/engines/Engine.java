package race.models.components.engines;

import race.models.components.TransportComponent;

/**
 * Engine class
 */
public class Engine extends TransportComponent {

    private double maxSpeed;

    public Engine(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

