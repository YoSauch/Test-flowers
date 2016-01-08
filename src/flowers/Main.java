package flowers;

import flowers.dao.ifaces.IFlowerDAO;
import flowers.factory.FlowerDaoFactory;
import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String method = "";
        System.out.println("Enter 1 to read from database");
        System.out.println("Enter 2 to read from json");
        System.out.println("Enter 3 to read from txt");
        System.out.println("Enter 4 to read from xml");
        if (sc.hasNextLine()) {
            method = sc.nextLine();
        }

        switch (method) {
            case "1":
                method = "db";
                break;
            case "2":
                method = "json";
                break;
            case "3":
                method = "txt";
                break;
            case "4":
                method = "xml";
                break;
            default:
                System.out.println("You entered wrong value");
                return;
        }

        FlowerDaoFactory flowerDaoFactory = new FlowerDaoFactory();

        IFlowerDAO flowerDAO;
        flowerDAO = flowerDaoFactory.getDao(method, new FlowerFactory());
        Bouquet bouquet = flowerDAO.readFlowers();

        System.out.println(bouquet.toString());

    }
}
