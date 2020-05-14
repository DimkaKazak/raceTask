package models.vehicles;

import models.components.Wheel;
import models.components.engines.JaguarEngine;

import java.util.List;

public class Jaguar extends Car{
    public Jaguar(String name, JaguarEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.85);
    }
}
