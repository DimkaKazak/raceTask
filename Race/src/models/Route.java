package models;

import models.utils.RoutePoint;

import java.util.List;

import static models.utils.Point2DCalculations.calculateDistance;

public class Route {

    private double totalDistance;
    private List<RoutePoint> vectors;

    public Route(List<RoutePoint> vectors){
        this.vectors = vectors;
        this.totalDistance = calculateTotalDistance(vectors);
    }

    private double calculateTotalDistance(List<RoutePoint> vectors){
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

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setVectors(List<RoutePoint> vectors) {
        this.vectors = vectors;
    }
}
