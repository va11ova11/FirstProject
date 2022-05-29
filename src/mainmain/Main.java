package mainmain;

import Dao.CashDAO;
import Dao.FondStructureServicePostgreSql;
import model.FoundStructure;
import model.Person;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String URL = "jdbc:postgresql://localhost:5432/portfolio";
        final String NAME = "postgres";
        final String PASSWORD = "123";
        Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);

        while (true) {
            System.out.println("Что вы хотите?");
            System.out.println("1. Пополнение счёта нажмите");
            System.out.println("2. Посмтореть баланс");
            System.out.println("3. Снять с баланса");
            System.out.println("4. Купить фонд");
            System.out.println("5. Посмотреть портфель");
            Scanner scanner = new Scanner(System.in);
            int command1 = scanner.nextInt();


            //В разработке
            //Пополнение баланса
            if (command1 == 1) {
               CashDAO cashDAO= new CashDAO();
                System.out.println(cashDAO.UpdateBalance());

            }

            //Показать баланс
            if (command1 == 2) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM bank");
                while (resultSet.next()) {
                    System.out.println("Ваш баланс: " + resultSet.getFloat("balance"));
                }
            }

            //Снять с баланса
            if (command1 == 3) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM bank");
                while (resultSet.next()) {
                    float balance = resultSet.getFloat("balance");
                    System.out.println("Ваш баланс: " + balance);

                    System.out.println("Введите сумму снятия: ");
                    Scanner scanner3 = new Scanner(System.in);
                    float SummaSnyatia = scanner3.nextFloat();
                    float NewBalance = balance - SummaSnyatia;
                    System.out.println(NewBalance);

                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank set balance = ? where id = 1;");
                    preparedStatement.setFloat(1, NewBalance);
                    boolean rs = preparedStatement.execute();
                }
            }

            //Покупка фонда + изменение баланса в базе данных
            if (command1 == 4) {
                List<FoundStructure> foundStructure = new FondStructureServicePostgreSql().getAll();
                System.out.println("Если хотите купить фонд нажмите: 1\nВыход обратно в меню нажмите: 2");
                Scanner scanner1 = new Scanner(System.in);
                int Operation = scanner1.nextInt();
                if (Operation == 1) {
                    System.out.println("Укажите Id фонда");
                    int FondId = scanner1.nextInt();
                    float FondPrice = (float) foundStructure.get(FondId).getFondPrice();
                    System.out.println("Вы выбрали фонд: " + foundStructure.get(FondId).getFondName() + "\nЦена за 1 лот: " + FondPrice
                            + "\nГодовая доходность: " + foundStructure.get(FondId).getFondProfitability() + "%");
                    System.out.println("Укажите сколько паёв хотите купить");
                    Scanner scanner2 = new Scanner(System.in);
                    Person person = new FondStructureServicePostgreSql().getBalance();
                    float balance = person.getBalance();
                    float Kol = scanner2.nextInt();
                    float result1 = Kol * FondPrice;
                    float result2 = balance - Kol * FondPrice;
                    System.out.println("Сумма вашей покупки составляет: " + result1);
                    System.out.println("Ваш баланс: " + result2);
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bank SET balance=? WHERE id =1");
                    preparedStatement.setFloat(1, result2);
                    preparedStatement.execute();
                }
            }

        }
    }
}







