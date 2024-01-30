package entity;

public class ProductExo5 {

    private int sellin;

    private int quality;

    private String label;

    private boolean isDairyProduct;

    public ProductExo5(){
        isDairyProduct = false;
    }

    private void updateQuality(int qualityChange){
        if (isDairyProduct) qualityChange *=2;
        quality += qualityChange;
        if (quality < 0 ) quality = 0;
        if (quality > 50 ) quality = 50;
    }

    public void update() {
        sellin--;
        if (label == "brie vieilli") {
            updateQuality(1);
            return;
        }
        if (sellin < 0) {
            updateQuality(-2);
        } else {
            updateQuality(-1);
        }

    }


    public void setLabel(String label) {
        this.label = label;
    }

    public void setIsDairyProduct(boolean dairyProduct) {
        this.isDairyProduct = dairyProduct;
    }

    public int getSellin() {
        return sellin;
    }

    public void setSellin(int sellin) {
        this.sellin = sellin;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
