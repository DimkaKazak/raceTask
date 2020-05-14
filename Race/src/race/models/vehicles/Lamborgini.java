package models.vehicles;

import models.components.Wheel;
import models.components.engines.LamborginiEngine;

import java.util.List;

public class Lamborgini extends Car{

    public Lamborgini(String name, LamborginiEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.95);
    }

}
