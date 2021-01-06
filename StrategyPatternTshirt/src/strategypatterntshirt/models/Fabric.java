package strategypatterntshirt.models;

public enum Fabric {
    WOOL(12), COTTON(15), POLYESTER(17), RAYON(18.3f),
    LINEN(19.4f), CASHMERE(33.76f), SILK(35.93f);

    private final float fabricPrice;

    Fabric(float fabricPrice) {
        this.fabricPrice = fabricPrice;
    }

    public float getFabricPrice() {
        return fabricPrice;
    }

    @Override
    public String toString() {
        return "Fabric{" + "unitPrice=" + this.fabricPrice + '}';
    }

}
