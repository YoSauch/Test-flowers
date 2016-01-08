package flowers.dao;

import flowers.dao.ifaces.IFlowerDAO;
import flowers.dao.xml.XmlSaxHandler;
import flowers.exceptions.FlowersDaoException;
import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XmlFileDAO implements IFlowerDAO {
    private File inputFile;
    private File outputFile;

    private FlowerFactory flowerFactory;

    public XmlFileDAO(String inputPath, String outputPath, FlowerFactory flowerFactory) {
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);

        this.flowerFactory = flowerFactory;
    }

    @Override
    public Bouquet readFlowers() throws FlowersDaoException {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            XmlSaxHandler xmlSaxHandler = new XmlSaxHandler(flowerFactory);
            saxParser.parse(inputFile, xmlSaxHandler);

            return xmlSaxHandler.getBouquet();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new FlowersDaoException();
        }
    }

    @Override
    public void writeResult(Bouquet bouquet) throws FlowersDaoException {

    }
}
