package models.vehicles;

import models.components.Wheel;
import models.components.engines.FerrariEngine;

import java.util.List;

public class Ferrari extends Car{

    public Ferrari(String name, FerrariEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(1);
    }

}
