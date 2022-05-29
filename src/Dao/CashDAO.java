package Dao;

import model.Person;

import java.sql.*;
import java.util.Scanner;

public class CashDAO {
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


    public Person UpdateBalance() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM bank WHERE id=1");
        resultSet.next();
        Person person  = new Person();
        System.out.println("Ваш баланс: " + person.setBalance(person.setBalance(resultSet.getFloat("balance"))));
        System.out.println("Введите сумму пополнения: ");
        Scanner scanner = new Scanner(System.in);
        float SummaPopolnenia = scanner.nextFloat();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank SET balance = ? WHERE id = 1");
        preparedStatement.setFloat(1,SummaPopolnenia);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        person.setBalance(resultSet.getFloat("balance"));

        return person;

    }


}
