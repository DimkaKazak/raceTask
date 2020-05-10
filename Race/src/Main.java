import models.CarRace;
import models.components.Wheel;
import models.factory.CarFactory;
import models.utils.Points.Point2D;
import models.utils.Points.Point2DCalculations;
import models.utils.Points.RoutePoint;
import models.vehicles.Car;

import java.util.*;

public class Main {

    private static double eps = Math.pow(10, -7);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Start race? (y/n) ");
        
        if(in.next().equals("y")) {

            System.out.println("Please, choose your car: BMW, Ferrari, Jaguar, Lamborgini, Porsche, Car (as Default)\n");
            String userCarName = in.next();
            Car userCar = CarFactory.getCarByName(userCarName);

            if (userCar == null){
                userCar = CarFactory.getCarByName("Car");
                System.out.println("We have some problems with this car, but we have another one. Get it and ride!");
            }

            CarRace carRace = new CarRace();

            if (userCar != null) {
                userCar.setName(userCar.getName() + " (Your car)");
                userCar.setPosition(carRace.getRoute().getVectors().get(0));
                carRace.getCars().add(userCar);
            }

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

            while (isContinue){

                if(in.next().equals("f")){

                    for (int i = 0; i < cars.size(); i++){
                        Car currentCar =  cars.get(i);

                        if (!carRace.getGarage().getWheelService().checkWheels(currentCar)){
                            carRace.getGarage().getWheelService().changeWheels(currentCar, null);
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

                        double distanceFromPrevPoint = Point2DCalculations.calculateDistance(prevPoint, currentPosition);
                        double distanceOfTheCurrentRoad = Point2DCalculations.calculateDistance(prevPoint, nextPoint);

                        double cos;
                        double sin;
                        try{
                            cos = Point2DCalculations.calculateCos(prevPoint, nextPoint);
                            sin = Point2DCalculations.calculateSin(prevPoint, nextPoint);
                        } catch (ArithmeticException e){
                            e.printStackTrace();
                            continue;
                        }

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
        float materialFrictionCoef = carRace.getRoute()
                .getVectors()
                .get(progressPoint)
                .getMaterialState()
                .getFrictionCoef();

        for (Wheel wheel : car.getWheels() ){
            double rand = generateRandomDouble(-0.1, 0.1);
            wheel.setFrictionCoef( wheel.getFrictionCoef() * (materialFrictionCoef + rand) );
        }

    }

    private static double generateRandomDouble(double min, double max){
        Random random = new Random();
        double dif = max - min;
        return min + random.nextDouble() * dif;
    }
}