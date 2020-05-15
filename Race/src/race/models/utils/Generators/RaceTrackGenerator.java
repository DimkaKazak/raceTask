package race.models.utils.Generators;

import IO.exception.UnableToReadException;
import IO.exception.UnableToWriteException;
import IO.reader.StreamTextFileReader;
import IO.writer.StreamTextFileWriter;
import race.interfaces.generator.TrackGenerator;
import race.models.Route;
import race.models.utils.Enums.EnumUtil;
import race.models.utils.Enums.MaterialState;
import race.models.utils.Points.RoutePoint;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RaceTrackGenerator: Singleton object ( only one for the whole race )
 */
public class RaceTrackGenerator implements TrackGenerator {

    private static RaceTrackGenerator instance;

    /**
     * Realisation of Singleton pattern
     */
    private RaceTrackGenerator(){}

    public static RaceTrackGenerator getInstance() {

        if(instance == null){
            instance = new RaceTrackGenerator();
        }

        return instance;
    }

    /**
     * @return route, that generates with Random.class
     */
    @Override
    public Route generateRandomRoute() {
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


    /**
     * @param path - read from file with this path
     * @return route, that generates with Random.class
     */
    @Override
    public Route generateRouteFromFile(String path) {
        StreamTextFileReader streamTextFileReader = new StreamTextFileReader(path);
        List<RoutePoint> routeVectors = new ArrayList<>();

        String[] points = new String[]{};
        try {
            points = streamTextFileReader.read().split("\n");
        } catch (UnableToReadException e) {
            e.printStackTrace();
        }

        for (String point : points){
            String[] xy = point.split(",");
            MaterialState materialState = EnumUtil.getRandomValueFromEnum(MaterialState.class);

            RoutePoint currRoutePoint = new RoutePoint(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]), materialState);
            routeVectors.add(currRoutePoint);
        }

        return new Route(routeVectors);
    }

    /**
     * @param routeVectors - RoutePoint from Points package
     * @return true, if vectors don't cross each other, else false
     */
    @Override
    public boolean checkVectorsIntersections(List<RoutePoint> routeVectors) {
        return false;
    }


    /**
     * @param path - to what file we write
     * @param routePoints - what points we write
     */
    public void writePointsToFile(String path, List<RoutePoint> routePoints){
        StreamTextFileWriter streamTextFileWriter = new StreamTextFileWriter();

        for (RoutePoint currentPoint : routePoints){
            try {
                streamTextFileWriter.append(path, currentPoint.getX() + ", " + currentPoint.getY() + "\n");
            } catch (UnableToWriteException e) {
                e.printStackTrace();
            }
        }
    }
}
