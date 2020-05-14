package race.interfaces.generator;

import race.models.Route;
import race.models.utils.Points.RoutePoint;
import java.util.List;

public interface TrackGenerator {

    public Route generateRoute();
    public boolean checkVectorsIntersections(List<RoutePoint> routeVectors);

}
