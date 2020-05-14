package race.models.vehicles;

import race.models.components.Wheel;
import race.models.components.engines.PorscheEngine;

import java.util.List;

public class Porsche extends Car{
    public Porsche(String name, PorscheEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.8);
    }
}
