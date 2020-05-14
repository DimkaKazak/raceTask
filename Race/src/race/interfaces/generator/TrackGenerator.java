package race.interfaces.generator;

import race.models.Route;
import race.models.utils.Points.RoutePoint;
import java.util.List;

public interface TrackGenerator {

    Route generateRandomRoute();
    Route generateRouteFromFile(String path);
    boolean checkVectorsIntersections(List<RoutePoint> routeVectors);

}
