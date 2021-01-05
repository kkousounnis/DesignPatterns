package strategypatterntshirt.models;

public class Tshirt {

    private String Name;
    private Color color;
    private Size size;
    private Fabric fabric;

    //color, size και fabric
    public Tshirt() {
    }

    public Tshirt(String Name, Color color, Size size, Fabric fabric) {
        this.Name = Name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
    }

    

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
