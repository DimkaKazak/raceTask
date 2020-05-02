package interfaces;

import models.Route;
import models.utils.RoutePoint;
import java.util.List;

public interface TrackGenerator {

    public Route generateRoute();
    public boolean checkVectorsIntersections(List<RoutePoint> routeVectors);

}
