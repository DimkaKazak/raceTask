import models.CarRace;
import models.components.Wheel;
import models.utils.MaterialState;
import models.utils.RoutePoint;
import models.utils.Point2D;
import models.vehicles.Car;

import java.util.*;

import static models.utils.Point2DCalculations.*;

public class Main {

    private static double eps = Math.pow(10, -7);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Start race? (y/n) ");

        if(in.next().equals("y")) {
            CarRace carRace= new CarRace();
            double[] carProgressDistances = new double[carRace.getCars().size()];
            int[] carProgressPoint = new int[carRace.getCars().size()];

            for (int i = 0 ; i < carRace.getCars().size() ; i++){
                carProgressDistances[i] = 0D;
                carProgressPoint[i] = 0;
            }

            int counter = 0;

            System.out.println("Press F to tick race");
            boolean isContinue = true;

            double totalDistance = carRace.getRoute().getTotalDistance();
            List<Car> cars = carRace.getCars();
            List<RoutePoint> routeVectors = carRace.getRoute().getVectors();

            while (isContinue){

                if(in.next().equals("f")){

                    for (int i = 0; i < cars.size(); i++){
                        Car currentCar =  cars.get(i);

                        if (!carRace.getGarage().checkWheels(currentCar)){
                            carRace.getGarage().changeWheels(currentCar);
                            continue; // car need one turn to repair wheels
                        }

                        double minFrictionCoef = currentCar.getWheels()
                                .stream().min(Comparator.comparing(Wheel::getFrictionCoef))
                                .get().getFrictionCoef();

                        double carDistance = currentCar.getEngine().getSpeed() * minFrictionCoef;

                        rescaleFrictionCoef(carRace, currentCar, carProgressPoint[i]);

                        Point2D currentPosition = currentCar.getPosition();
                        RoutePoint prevPoint = carRace.getRoute().getVectors().get(carProgressPoint[i]);
                        RoutePoint nextPoint = carRace.getRoute().getVectors().get(carProgressPoint[i] + 1);
                        double distanceFromPrevPoint = calculateDistance(prevPoint, currentPosition);
                        double distanceOfTheCurrentRoad = calculateDistance(prevPoint, nextPoint);
                        double cos = calculateCos(prevPoint, nextPoint);
                        double sin = calculateSin(prevPoint, nextPoint);

                        if ( carDistance + distanceFromPrevPoint < distanceOfTheCurrentRoad){
                            currentPosition.setX(currentPosition.getX() + carDistance * cos);
                            currentPosition.setY(currentPosition.getY() + carDistance * sin);
                            carProgressDistances[i] += carDistance;
                        } else {
                            currentPosition.setX(nextPoint.getX());
                            currentPosition.setY(nextPoint.getY());
                            carProgressDistances[i] += distanceOfTheCurrentRoad - distanceFromPrevPoint;
                            carProgressPoint[i] += 1;
                        }
                    }

                }
                carRace.getSupervisor().sayRaceProgress(cars);

                if (isFinished(carProgressDistances, totalDistance)){
                    isContinue = false;
                }

                System.out.println("Press F to continue race");
                counter++;
            }
            announceWinner(carProgressDistances, cars, totalDistance);
        } else {
            System.out.println("Good Bye");
        }

        in.close();
    }

    private static boolean isFinished(double[] carProgresses, double totalDistance){
        for (double progress : carProgresses){
            if(progress > totalDistance - eps) return true;
        }
        return false;
    }

    private static void announceWinner(double[] carProgresses, List<Car> cars, double totalDistance){
        System.out.println();
        for ( int i = 0 ; i < carProgresses.length ; i++){
            if (carProgresses[i] > totalDistance - eps) System.out.println(cars.get(i).getName() + " is Winner");
        }
    }

    private static void rescaleFrictionCoef(CarRace carRace, Car car, int progressPoint){
        MaterialState materialState = carRace.getRoute()
                .getVectors()
                .get(progressPoint)
                .getMaterialState();

        for (Wheel wheel : car.getWheels() ){
            double rand = generateRandomDouble(-0.1, 0.1);

            switch (materialState){
                case ferry: wheel.setFrictionCoef( wheel.getFrictionCoef() * (0.5 + rand) ); break;
                case highway: wheel.setFrictionCoef( wheel.getFrictionCoef() * (0.9 + rand) ); break;
                case cityRoad: wheel.setFrictionCoef( wheel.getFrictionCoef() * (0.85 + rand) ); break;
                case countryRoad: wheel.setFrictionCoef( wheel.getFrictionCoef() * (0.4 + rand) ); break;
            }
        }

    }

    private static double generateRandomDouble(double min, double max){
        Random random = new Random();
        double dif = max - min;
        return min + random.nextDouble() * dif;
    }
}