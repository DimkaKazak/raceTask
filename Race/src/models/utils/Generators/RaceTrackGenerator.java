package models.utils.Generators;

import interfaces.TrackGenerator;
import models.Route;
import models.utils.Enums.EnumUtil;
import models.utils.Enums.MaterialState;
import models.utils.Points.RoutePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceTrackGenerator implements TrackGenerator {

    private static RaceTrackGenerator instance;

    private RaceTrackGenerator(){}

    public static RaceTrackGenerator getInstance() {

        if(instance == null){
            instance = new RaceTrackGenerator();
        }

        return instance;
    }

    @Override
    public Route generateRoute() {
        Random random = new Random();
        List<RoutePoint> routeVectors = new ArrayList<>();
        double x = 0;
        double y = 0;
        for (int i = 0 ; i < random.nextInt(100); i++){
            x += random.nextDouble();
            y +=  random.nextDouble();
            MaterialState materialState = EnumUtil.getRandomValueFromEnum(MaterialState.class);

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
