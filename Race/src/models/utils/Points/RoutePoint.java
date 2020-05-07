package models.utils.Points;

import models.utils.Enums.MaterialState;
import models.utils.Points.Point2D;

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

