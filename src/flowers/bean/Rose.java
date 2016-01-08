package flowers.bean;

import flowers.bean.ifaces.Flower;

import java.awt.*;


public class Rose extends Flower {
    private static final int flowerPrice = 50;
    private static final String name = "Rose";

    public Rose() {
        super(name, flowerPrice);
    }

}
