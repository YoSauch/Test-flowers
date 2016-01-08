package flowers.bean;

import flowers.bean.ifaces.Flower;

import java.awt.*;


public class Daisy extends Flower {
    private static final int flowerPrice = 10;
    private static final String name = "Daisy";

    public Daisy() {
        super(name, flowerPrice);
    }

}
