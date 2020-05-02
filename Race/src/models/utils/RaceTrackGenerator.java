package models.utils;

import interfaces.TrackGenerator;
import models.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceTrackGenerator implements TrackGenerator {

    @Override
    public Route generateRoute() {
        Random random = new Random();
        List<RoutePoint> routeVectors = new ArrayList<>();
        double x = 0;
        double y = 0;
        for (int i = 0 ; i < random.nextInt(100); i++){
            x += random.nextDouble();
            y +=  random.nextDouble();
            int materialState = random.nextInt(4);
            RoutePoint currRoute = new RoutePoint(x, y, materialState);
            routeVectors.add(currRoute);
        }

        return new Route(routeVectors);
    }

    @Override
    public boolean checkVectorsIntersections(List<RoutePoint> routeVectors) {

        return false;
    }
}
