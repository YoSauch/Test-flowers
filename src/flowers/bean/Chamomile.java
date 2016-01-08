package flowers.bean;

import flowers.bean.ifaces.Flower;

import java.awt.*;


public class Chamomile extends Flower {
    private static final int flowerPrice = 10;
    private static final String name = "Chamomile";

    public Chamomile() {
        super(name, flowerPrice);
    }

}
