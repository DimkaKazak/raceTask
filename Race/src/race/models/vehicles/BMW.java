package race.models.vehicles;

import race.models.components.engines.BMWEngine;
import race.models.components.Wheel;

import java.util.List;

public class BMW extends Car{

    public BMW(String name, BMWEngine engine, List<Wheel> wheels) {
        super(name, engine, wheels);
        this.engine.setMaxSpeed(0.75);
    }

}
