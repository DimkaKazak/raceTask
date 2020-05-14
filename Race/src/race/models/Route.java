package models;


import models.utils.Points.RoutePoint;

import java.util.List;

import static models.utils.Points.Point2DCalculations.calculateDistance;

/**
 * Route on which cars ride
 */
public class Route {

    private double totalDistance;
    private List<RoutePoint> vectors;

    public Route(List<RoutePoint> vectors){
        this.vectors = vectors;
        this.totalDistance = calculateTotalDistance(vectors);
    }


    /**
     *
     * @param vectors - all vectors of the road (or in other words: all 2DRoutePoints)
     * @return total distance of the road
     */
    private static double calculateTotalDistance(List<RoutePoint> vectors){
        double totalDistance = 0;
        for (int i = 0 ; i < vectors.size() - 1 ; i++){
            RoutePoint currentVector = vectors.get(i);
            RoutePoint nextVector = vectors.get(i + 1);

            totalDistance += calculateDistance(currentVector, nextVector);
        }
        return totalDistance;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public List<RoutePoint> getVectors() {
        return vectors;
    }

    public void setVectors(List<RoutePoint> vectors) {
        this.vectors = vectors;
    }
}
