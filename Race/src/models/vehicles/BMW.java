package models.vehicles;

import models.components.Engine;
import models.components.Wheel;

import java.util.List;

public class BMW extends Car{

    public BMW(String name, Engine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.75);
    }

}