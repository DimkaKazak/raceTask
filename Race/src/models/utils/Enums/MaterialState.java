package models.utils.Enums;

public enum MaterialState{
    highway("highway"),
    ferry("ferryRoad"),
    cityRoad("cityRoad"),
    countryRoad("countryRoad");

    private String roadType;

    MaterialState(String roadType){
        this.roadType = roadType;
    }

    public String getRoadType(){
        return roadType;
    }
}
