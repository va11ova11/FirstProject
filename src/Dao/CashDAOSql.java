package Dao;

import model.Person;

import java.sql.*;
import java.util.Scanner;

public class CashDAOSql implements  CashDAO{
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

    //Показать баланс
    @Override
    public Person getBalance() throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bank");

            resultSet.next();
            Person person = new Person();
            person.setBalance(resultSet.getFloat("balance"));
        System.out.println("----------------------");
            System.out.println("Ваш баланс: " + person.getBalance());
        System.out.println("----------------------");
            return person;
    }


    //Обновить баланс при покупке фонда
    public void updateBalance(float NewBalance) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank SET balance=? WHERE id =1");
        preparedStatement.setFloat(1, NewBalance);
        preparedStatement.execute();

    }

    //Пополнить баланс
    @Override
    public Person cashInBalance() throws SQLException {
        Person person = new Person();
        System.out.println("Ваш баланс: " + person.setBalance(getBalance().getBalance()));

            System.out.println("Введите сумму пополнения: ");
            Scanner scanner = new Scanner(System.in);
            float SummaPopolnenia = scanner.nextFloat();
            float NewBalance = person.setBalance(getBalance().getBalance()) + SummaPopolnenia;

            System.out.println("----------------------");
            System.out.println("Ваш баланс: " + NewBalance);
            System.out.println("----------------------");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank SET balance = ? WHERE id = 1");
            preparedStatement.setFloat(1,NewBalance);
            preparedStatement.execute();

            return person;
    }

    //Снять с баланса
    @Override
    public Person cashOutBalance() throws SQLException {
        Person person = new Person();
        System.out.println("Ваш баланс: " + person.setBalance(getBalance().getBalance()));

            System.out.println("Введите сумму снятия: ");
            Scanner scanner3 = new Scanner(System.in);
            float SummaSnyatia = scanner3.nextFloat();
            float NewBalance = person.getBalance() - SummaSnyatia;

            System.out.println("----------------------");
            System.out.println("Ваш баланс: " + NewBalance);
            System.out.println("----------------------");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank set balance = ? where id = 1;");
            preparedStatement.setFloat(1, NewBalance);
            preparedStatement.execute();

        return person;
    }
}
