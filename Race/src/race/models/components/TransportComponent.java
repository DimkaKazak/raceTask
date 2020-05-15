package race.models.components;

public abstract class TransportComponent {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
