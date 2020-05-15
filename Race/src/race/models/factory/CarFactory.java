package race.models.factory;

import race.models.components.engines.*;
import race.models.components.Wheel;
import race.models.vehicles.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * Use this class for building cars
 */
public class CarFactory {


    /**
     * @param name - name of the class, that must build
     * @return one of the car from vehicles package
     */
    public static Car getCarByName(String name){
        String carPath = "race.models.vehicles." + name;
        Class<?> curClass = null;

        try {
            curClass = Class.forName(carPath);
            Class[] classParams;
            List<Wheel> wheels = createWheels();
            Engine engine = createEngine(name);

            switch (name){
                case "BMW":{
                    classParams = new Class[]{String.class, BMWEngine.class, List.class};
                    return (BMW) curClass.getConstructor(classParams).newInstance(name, (BMWEngine) engine, wheels);
                }
                case "Car":{
                    classParams = new Class[]{String.class, Engine.class, List.class};
                    return (Car) curClass.getConstructor(classParams).newInstance("Default " + name, engine, wheels);
                }
                case "Ferrari":{
                    classParams = new Class[]{String.class, FerrariEngine.class, List.class};
                    return (Ferrari) curClass.getConstructor(classParams).newInstance(name, (FerrariEngine) engine, wheels);
                }
                case "Jaguar":{
                    classParams = new Class[]{String.class, JaguarEngine.class, List.class};
                    return (Jaguar) curClass.getConstructor(classParams).newInstance(name, (JaguarEngine) engine, wheels);
                }
                case "Lamborgini":{
                    classParams = new Class[]{String.class, LamborginiEngine.class, List.class};
                    return (Lamborgini) curClass.getConstructor(classParams).newInstance(name, (LamborginiEngine) engine, wheels);
                }
                case "Porsche":{
                    classParams = new Class[]{String.class, PorscheEngine.class, List.class};
                    return (Porsche) curClass.getConstructor(classParams).newInstance(name, (PorscheEngine) engine, wheels);
                }
                default: return new Car("Default Car", engine, wheels);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }



    /**
     * @return wheels that must be added to building car
     */
    private static List<Wheel> createWheels(){
        List<Wheel> wheels = new ArrayList<>();
        for (int j = 0 ; j < 4 ; j++){
            wheels.add( new Wheel(1) );
        }
        return wheels;
    }

    /**
     * @param type - the type of car (BMW, Ferrari and so on in {@link race.models.utils.Enums.Car})
     * @return engine that must be added to building car
     */
    private static Engine createEngine(String type){
        String enginePath;
        if (type.toLowerCase().equals("car")){  enginePath = "race.models.components.engines.Engine";}
        else { enginePath = "race.models.components.engines." + type + "Engine";}

        Class<?> curClass;

        try{
            curClass = Class.forName(enginePath);
            Class[] EngineClassParams = {double.class};
            Constructor constructor = curClass.getConstructor(EngineClassParams);

            switch (type){
                case "BMW": return (BMWEngine) constructor.newInstance(race.models.utils.Enums.Engine.BMWEngine.getMaxSpeed());
                case "Car": return (Engine) constructor.newInstance(race.models.utils.Enums.Engine.CarEngine.getMaxSpeed());
                case "Ferrari": return (FerrariEngine) constructor.newInstance(race.models.utils.Enums.Engine.FerrariEngine.getMaxSpeed());
                case "Jaguar": return (JaguarEngine) constructor.newInstance(race.models.utils.Enums.Engine.JaguarEngine.getMaxSpeed());
                case "Lamborgini": return (LamborginiEngine) constructor.newInstance(race.models.utils.Enums.Engine.LamborginiEngine.getMaxSpeed());
                case "Porsche": return (PorscheEngine) constructor.newInstance(race.models.utils.Enums.Engine.PorscheEngine.getMaxSpeed());
                default: return null;
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}
