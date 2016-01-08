package flowers.factory;

import flowers.dao.JsonFileDAO;
import flowers.dao.TextFileDAO;
import flowers.dao.XmlFileDAO;
import flowers.dao.h2DAO;
import flowers.dao.ifaces.IFlowerDAO;

public class FlowerDaoFactory {

    public IFlowerDAO getDao(String name, FlowerFactory flowerFactory) {
        IFlowerDAO flowerDAO = null;

        switch (name) {
            case "json":
                flowerDAO = new JsonFileDAO(
                        "./resources/in_flowers.json",
                        "./resources/in_flowers.json",
                        flowerFactory);
                break;
            case "txt":
                flowerDAO = new TextFileDAO(
                        "./resources/in_flowers.txt",
                        "./resources/in_flowers.txt",
                        flowerFactory);
                break;
            case "xml":
                flowerDAO = new XmlFileDAO(
                        "./resources/in_flowers.xml",
                        "./resources/in_flowers.xml",
                        flowerFactory);
                break;
            case "db":
                flowerDAO = new h2DAO(flowerFactory);
                break;
        }

        return flowerDAO;
    }

}
