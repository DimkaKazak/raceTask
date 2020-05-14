package models.vehicles;

import models.components.Wheel;
import models.components.engines.PorscheEngine;

import java.util.List;

public class Porsche extends Car{
    public Porsche(String name, PorscheEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.8);
    }
}
