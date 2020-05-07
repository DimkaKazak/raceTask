package models.factory;

import models.components.Engine;
import models.components.Wheel;
import models.vehicles.*;

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
        String carPath = "models.vehicles." + name;
        switch (name){
            case "BMW": return getBMW(carPath);
            case "Ferrari": return getFerrari(carPath);
            case "Jaguar": return getJaguar(carPath);
            case "Lamborgini": return getLamborgini(carPath);
            case "Porsche": return getPorsche(carPath);
            default: return getDefaultCar(carPath);
        }
    }


    /**
     * @param carInput - name of the class, that must build
     * @return default Car realisation
     */
    private static Car getDefaultCar(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (Car) curClass.getConstructor(FerrariClassParams).newInstance("Default Car", new Engine(0.7), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param carInput - name of the class, that must build
     * @return Ferrari object from vehicles package
     */
    private static Ferrari getFerrari(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (Ferrari) curClass.getConstructor(FerrariClassParams).newInstance("Ferrari", new Engine(0), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param carInput - name of the class, that must build
     * @return BMW object from vehicles package
     */
    private static BMW getBMW(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (BMW) curClass.getConstructor(FerrariClassParams).newInstance("BMW", new Engine(0), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param carInput - name of the class, that must build
     * @return Jaguar object from vehicles package
     */
    private static Jaguar getJaguar(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (Jaguar) curClass.getConstructor(FerrariClassParams).newInstance("Jaguar", new Engine(0), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param carInput - name of the class, that must build
     * @return Lamborgini object from vehicles package
     */
    private static Lamborgini getLamborgini(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (Lamborgini) curClass.getConstructor(FerrariClassParams).newInstance("Lamborgini", new Engine(0), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param carInput - name of the class, that must build
     * @return Porsche object from vehicles package
     */
    private static Porsche getPorsche(String carInput){

        Class<?> curClass;
        try {
            curClass = Class.forName(carInput);
            Class[] FerrariClassParams = {String.class, Engine.class, List.class};
            List<Wheel> wheels = createWheels();
            return  (Porsche) curClass.getConstructor(FerrariClassParams).newInstance("Ferrari", new Engine(0), wheels);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
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

}
