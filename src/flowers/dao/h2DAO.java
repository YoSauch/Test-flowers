package flowers.dao;

import flowers.dao.ifaces.IFlowerDAO;
import flowers.exceptions.FlowersDaoException;
import flowers.factory.FlowerFactory;
import flowers.process.Bouquet;

import java.sql.*;

public class h2DAO implements IFlowerDAO {
    private static final String DRIVER_NAME = "org.h2.Driver";
    private static final String DATABASE_CONNECTION_STRING = "jdbc:h2:~/flowerShop";

    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private FlowerFactory flowerFactory;

    public h2DAO(FlowerFactory flowerFactory) {
        this.flowerFactory = flowerFactory;

        try {
            Class.forName(DRIVER_NAME).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bouquet readFlowers() throws FlowersDaoException {
        Bouquet bouquet = new Bouquet();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_CONNECTION_STRING, USER, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM FLOWERS");

            while (resultSet.next()) {
                String flowerName = resultSet.getString("NAME");
                int flowerCount = resultSet.getInt("COUNT");
                bouquet.addFlowers(flowerFactory.create(flowerName, flowerCount));
            }

        } catch (SQLException e) {
            throw new FlowersDaoException(e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new FlowersDaoException(e.getMessage());
            }
        }

        return bouquet;
    }

    @Override
    public void writeResult(Bouquet bouquet) throws FlowersDaoException {

    }
}
