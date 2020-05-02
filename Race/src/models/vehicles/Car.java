package models.vehicles;

import models.components.Engine;
import models.components.Wheel;
import models.utils.Point2D;

import java.util.List;

public class Car extends Transport {

    Engine engine;
    List<Wheel> wheels;
    Point2D position;

    public Car(String name, Engine engine, List<Wheel> wheels) {
        super(name);
        this.engine = engine;

        if(validateWheelsSize(wheels)){
            this.wheels = wheels;
        } else {
            throw new RuntimeException("Car must have 4 wheels in our race");
        }

        this.position = new Point2D(0,0);
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public boolean validateWheelsSize(List<Wheel> wheels){
        return wheels.size() == 4;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
