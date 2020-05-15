package race.models.utils.Points;

import race.models.utils.Enums.MaterialState;

/**
 * Use this class for marking points of the road
 */
public class RoutePoint extends Point2D {

    private MaterialState materialState;

    public RoutePoint(double x, double y, MaterialState materialState) {
        super(x, y);
        this.materialState = materialState;
    }

    public MaterialState getMaterialState() {
        return materialState;
    }

    public void setMaterialState(MaterialState materialState) {
        this.materialState = materialState;
    }
}

