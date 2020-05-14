package race.models.vehicles;

import race.models.components.Wheel;
import race.models.components.engines.JaguarEngine;

import java.util.List;

public class Jaguar extends Car{
    public Jaguar(String name, JaguarEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.85);
    }
}
