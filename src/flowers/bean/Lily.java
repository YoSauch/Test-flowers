package flowers.bean;

import flowers.bean.ifaces.Flower;

import java.awt.*;


public class Lily extends Flower {
    private static final int flowerPrice = 20;
    private static final String name = "Lily";

    public Lily() {
        super(name, flowerPrice);
    }

}
