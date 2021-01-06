package strategypatterntshirt.models;

public enum Size {
    XS(18), S(25.3f), M(27.45f), L(35.04f), XL(18.23f), XXL(14.34f), XXXL(10.23f);
    
    private final float sizePrice;

    Size(float sizePrice) {
        this.sizePrice = sizePrice;
    }

    public float getSizePrice() {
        return sizePrice;
    }

    @Override
    public String toString() {
        return "Size{" + "sizePrice=" + this.sizePrice + '}';
    }
}
