package flowers.dao.xml;

import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlSaxHandler extends DefaultHandler {
    private FlowerFactory flowerFactory;

    private Bouquet bouquet;

    private String flowerName;
    private int flowerCount;
    private String currentTag;

    public XmlSaxHandler(FlowerFactory flowerFactory) {
        this.flowerFactory = flowerFactory;
        bouquet = new Bouquet();
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        switch (currentTag) {
            case "name":
                flowerName = new String(ch, start, length);
                break;
            case "count":
                flowerCount = Integer.parseInt(new String(ch, start, length));
                break;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if ("flower".equals(qName)) {
            bouquet.addFlowers(flowerFactory.create(flowerName, flowerCount));
        }
        currentTag = "";
    }

    public Bouquet getBouquet() {
        return bouquet;
    }
}
