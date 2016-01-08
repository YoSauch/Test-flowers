package flowers.dao;

import flowers.dao.ifaces.IFlowerDAO;
import flowers.exceptions.FlowersDaoException;
import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;

import java.io.*;
import java.util.Scanner;

public class TextFileDAO implements IFlowerDAO {

    private File inputFile;
    private File outputFile;

    private FlowerFactory flowerFactory;

    public TextFileDAO(String inputPath, String outputPath, FlowerFactory flowerFactory) {
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);

        this.flowerFactory = flowerFactory;
    }

    @Override
    public Bouquet readFlowers() throws FlowersDaoException {
        InputStream inputStream = null;
        Bouquet resultBouquet = new Bouquet();

        try {
            inputStream = new FileInputStream(inputFile);
            Scanner scanner = new Scanner(inputStream);

            String inputLine;
            String[] inputArr;

            while (scanner.hasNext()) {
                inputLine = scanner.nextLine();
                inputArr = inputLine.split(" ");

                resultBouquet.addFlowers(flowerFactory
                        .create(inputArr[0], Integer.parseInt(inputArr[1])));
            }
        } catch (FileNotFoundException e) {
            throw new FlowersDaoException();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultBouquet;
    }

    @Override
    public void writeResult(Bouquet bouquet) throws FlowersDaoException {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(outputFile);

            outputStream.write(bouquet.toString().getBytes());
        } catch (IOException e) {
            throw new FlowersDaoException();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
