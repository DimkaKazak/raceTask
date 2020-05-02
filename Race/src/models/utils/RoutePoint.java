package models.utils;

public class RoutePoint extends Point2D {

    private MaterialState materialState;

    public RoutePoint(double x, double y, MaterialState materialState) {
        super(x, y);
        this.materialState = materialState;
    }

    public RoutePoint(double x, double y, int materialState) {
        super(x, y);
        setMaterialState(materialState);
    }

    public MaterialState getMaterialState() {
        return materialState;
    }

    public void setMaterialState(int state) {
        switch (state){
            case 0: this.materialState = MaterialState.highway; break;
            case 1: this.materialState = MaterialState.ferry; break;
            case 2: this.materialState = MaterialState.cityRoad; break;
            case 3: this.materialState = MaterialState.countryRoad; break;
            default: throw new RuntimeException("Invalidate State");
        }
    }

    public void setMaterialState(MaterialState materialState) {
        this.materialState = materialState;
    }
}

