package flowers.dao;

import flowers.dao.ifaces.IFlowerDAO;
import flowers.exceptions.FlowersDaoException;
import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileDAO implements IFlowerDAO {
    private File inputFile;
    private File outputFile;

    private FlowerFactory flowerFactory;

    public JsonFileDAO(String inputPath, String outputPath, FlowerFactory flowerFactory) {
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);

        this.flowerFactory = flowerFactory;
    }


    @Override
    public Bouquet readFlowers() throws FlowersDaoException {
        Bouquet bouquet = new Bouquet();

        JSONParser jsonParser = new JSONParser();

        try {
            JSONObject rootObject = (JSONObject) jsonParser.parse(new FileReader(inputFile));
            JSONArray flowers = (JSONArray) rootObject.get("flowers");
            for (Object flower: flowers) {
                String name = (String) ((JSONObject)flower).get("name");
                int count = Integer.parseInt((String)((JSONObject)flower).get("count"));

                bouquet.addFlowers(flowerFactory.create(name, count));
            }

        } catch (IOException | ParseException e) {
            throw new FlowersDaoException();
        }

        return bouquet;
    }

    @Override
    public void writeResult(Bouquet bouquet) throws FlowersDaoException {

    }
}
