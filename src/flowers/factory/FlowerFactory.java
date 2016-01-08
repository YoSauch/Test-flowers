package flowers.factory;

import flowers.bean.*;
import flowers.bean.ifaces.Flower;
import flowers.exceptions.IncorrectFlowerNameException;
import flowers.exceptions.IllegalFlowersCountException;

import java.util.ArrayList;
import java.util.List;

public class FlowerFactory {

    public List<Flower> create(String name, int numberFlowers) throws IncorrectFlowerNameException,
            IllegalFlowersCountException {
        if (numberFlowers <= 0) {
            throw new IllegalFlowersCountException();
        }

        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < numberFlowers; i++) {
            flowers.add(create(name));
        }

        return flowers;
    }

    public Flower create(String name) throws IncorrectFlowerNameException {
        Flower flower;

        switch (name) {
            case "Sunflower":
                flower = new Sunflower();
                break;
            case "Rose":
                flower = new Rose();
                break;
            case "Lily":
                flower = new Lily();
                break;
            case "Daisy":
                flower = new Daisy();
                break;
            case "Chamomile":
                flower = new Chamomile();
                break;
            default:
                throw new IncorrectFlowerNameException();
        }
        return flower;
    }
}
