package flowers.dao.ifaces;

import flowers.exceptions.FlowersDaoException;
import flowers.process.Bouquet;

public interface IFlowerDAO {

    Bouquet readFlowers() throws FlowersDaoException;
    void writeResult(Bouquet bouquet) throws FlowersDaoException;
}
