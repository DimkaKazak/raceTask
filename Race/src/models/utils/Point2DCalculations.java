package models.utils;

public class Point2DCalculations {

    public static double calculateDistance(Point2D current, Point2D other){

        double deltaX = other.getX() - current.getX();
        double deltaY = other.getY() - current.getY();

        return Math.sqrt( deltaX * deltaX + deltaY * deltaY );
    }

    public static double calculateCos(Point2D current, Point2D other){

        double distance = calculateDistance(current, other);
        double deltaX = other.getX() - current.getX();

        return deltaX / distance;
    }

    public static double calculateSin(Point2D current, Point2D other){

        double distance = calculateDistance(current, other);
        double deltaY = other.getY() - current.getY();

        return deltaY / distance;
    }

}
