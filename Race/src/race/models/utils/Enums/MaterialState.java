package race.models.utils.Enums;

/**
 * Use to describe road quality
 */
public enum MaterialState{
    highway("highway", 0.9f),
    ferry("ferryRoad", 0.5f),
    cityRoad("cityRoad", 0.85f),
    countryRoad("countryRoad", 0.4f);

    private String roadType;
    private float frictionCoef;

    MaterialState(String roadType, float frictionCoef){
        this.roadType = roadType;
        this.frictionCoef = frictionCoef;
    }

    public String getRoadType(){
        return roadType;
    }

    public float getFrictionCoef() {
        return frictionCoef;
    }
}
