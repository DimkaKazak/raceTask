package models.utils.Points;

/**
 * Use this class for calculations between 2 dimensional points
 */
public class Point2DCalculations {

    /**
     * @param current - first point
     * @param other - next point
     * @return distance between current and other points
     */
    public static double calculateDistance(Point2D current, Point2D other){

        double deltaX = other.getX() - current.getX();
        double deltaY = other.getY() - current.getY();

        return Math.sqrt( deltaX * deltaX + deltaY * deltaY );
    }


    /**
     * @param current - first point
     * @param other - next point
     * @return cosinus between current and other points
     */
    public static double calculateCos(Point2D current, Point2D other){

        double distance = calculateDistance(current, other);
        double deltaX = other.getX() - current.getX();

        return deltaX / distance;
    }

    /**
     * @param current - first point
     * @param other - next point
     * @return sinus between current and other points
     */
    public static double calculateSin(Point2D current, Point2D other){

        double distance = calculateDistance(current, other);
        double deltaY = other.getY() - current.getY();

        return deltaY / distance;
    }

}
