package models.factory;

import models.components.Engine;
import models.components.Wheel;
import models.vehicles.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CarFactory {

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

    private static List<Wheel> createWheels(){
        List<Wheel> wheels = new ArrayList<>();
        for (int j = 0 ; j < 4 ; j++){
            wheels.add( new Wheel() );
        }
        return wheels;
    }

}
