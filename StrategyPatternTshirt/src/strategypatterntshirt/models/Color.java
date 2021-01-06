
package strategypatterntshirt.models;


public enum Color {
    RED (1), ORANGE(0.5f), YELLOW(0.75f), GREEN(2.2f),
    BLUE(1.3f), INDIGO(2.7f), VIOLET(3.8f);
    
    private final float colorPrice;

    Color(float colorPrice) {
        this.colorPrice = colorPrice;
    }

    public float getColorPrice() {
        return colorPrice;
    }

    @Override
    public String toString() {
        return "Color{" + "colorPrice=" + this.colorPrice + '}';
    }
}


