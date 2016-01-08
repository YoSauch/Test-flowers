package flowers.bean;

import flowers.bean.ifaces.Flower;

import java.awt.*;


public class Sunflower extends Flower {
    private static final int flowerPrice = 30;
    private static final String name = "Sunflower";

    public Sunflower() {
        super(name, flowerPrice);
    }

}
