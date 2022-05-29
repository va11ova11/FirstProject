package Dao;

import model.FoundStructure;
import model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FondStructureServicePostgreSql implements FondStructureDAO {

    final String URL = "jdbc:postgresql://localhost:5432/portfolio";
    final String NAME = "postgres";
    final String PASSWORD = "123";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoundStructure getFondById(int id) throws SQLException {
        FoundStructure foundStructure = new FoundStructure();
        String Sql = "SELECT id , fondname, fondprice, fondprofitability FROM fond WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(Sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            foundStructure.setFondName(resultSet.getString("fondname"));
            foundStructure.setFondPrice(resultSet.getDouble("fondprice"));
            foundStructure.setFondProfitability(resultSet.getDouble("fondprofitability"));
        }
            return foundStructure;
        }



    @Override
    public List<FoundStructure> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM fond");
        System.out.println("№     Тикер       цена за 1 пай  годовая доходность");
        List<FoundStructure> Fonds= new ArrayList<>();
        Fonds.add(0, null);
        for (int i = 1; i<10; i++) {
            while (resultSet.next()) {

                FoundStructure foundStructure = new FoundStructure();
                foundStructure.setID(resultSet.getInt("id"));
                foundStructure.setFondName(resultSet.getString("fondname"));
                foundStructure.setFondPrice(resultSet.getDouble("fondprice"));
                foundStructure.setFondProfitability(resultSet.getDouble("fondprofitability"));
                Fonds.add(foundStructure);
                System.out.println(foundStructure.getId() + "     " + foundStructure.getFondName() + "        " +
                        foundStructure.getFondPrice()+ "          " + foundStructure.getFondProfitability() + "%");

            }
        }
        return Fonds;
    }

    @Override
    public void BuyFond(FoundStructure foundStructure) {


    }
    @Override
    public void removeFond(FoundStructure foundStructure) {

    }

    @Override
    public Person getBalance() throws SQLException {
        Statement statement = connection.createStatement();
        String Sql = "SELECT * FROM bank";
        ResultSet resultSet = statement.executeQuery(Sql);
        Person person = new Person();
        resultSet.next();
        person.setBalance(resultSet.getFloat("balance"));

        return person;
    }



}
