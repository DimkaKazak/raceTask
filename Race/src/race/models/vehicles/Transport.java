package race.models.vehicles;

public abstract class Transport {

    protected String name;

    protected Transport(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
