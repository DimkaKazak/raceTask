package race.models.vehicles;

import race.models.components.Wheel;
import race.models.components.engines.LamborginiEngine;

import java.util.List;

public class Lamborgini extends Car{

    public Lamborgini(String name, LamborginiEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.95);
    }

}
