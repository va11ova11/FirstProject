package Dao;
import model.FoundStructure;
import model.Portfolio;

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


    //Получение фонда по Айди
    @Override
    public FoundStructure getFondById(int id) throws SQLException {
        FoundStructure foundStructure = new FoundStructure();
        String Sql = "SELECT id , fondname, fondprice, fondprofitability FROM fond WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(Sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            foundStructure.setID(resultSet.getInt("id"));
            foundStructure.setFondName(resultSet.getString("fondname"));
            foundStructure.setFondPrice(resultSet.getDouble("fondprice"));
            foundStructure.setFondProfitability(resultSet.getDouble("fondprofitability"));
            System.out.println("Фонд "+foundStructure.getId() + "." + foundStructure.getFondName() + "\nЦена фонда " +
                    foundStructure.getFondPrice() +"\nДоходность "
                    + foundStructure.getFondProfitability() + "%");
        }
        return foundStructure;
    }


    //Получения всех фондов с базы и передача их в список
    @Override
    public List<FoundStructure> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM fond");
        System.out.println("№     Тикер       цена за 1 пай  годовая доходность");
        List<FoundStructure> Fonds = new ArrayList<>();
        Fonds.add(0, null);
        for (int i = 1; i < 10; i++) {
            while (resultSet.next()) {

                FoundStructure foundStructure = new FoundStructure();
                foundStructure.setID(resultSet.getInt("id"));
                foundStructure.setFondName(resultSet.getString("fondname"));
                foundStructure.setFondPrice(resultSet.getDouble("fondprice"));
                foundStructure.setFondProfitability(resultSet.getDouble("fondprofitability"));
                Fonds.add(foundStructure);
                System.out.println(foundStructure.getId() + "     " + foundStructure.getFondName() + "        " +
                        foundStructure.getFondPrice() + "          " + foundStructure.getFondProfitability() + "%");
            }
        }
        return Fonds;
    }

        //Получение всех фондов с базы данных + покупка и изменение баланса в базе данных
        @Override
        public FoundStructure BuyFond () throws SQLException {
            List<FoundStructure> Fonds = new FondStructureServicePostgreSql().getAll();
            FoundStructure foundStructure = new FoundStructure();
            Portfolio portfolio  = new Portfolio();
            CashDAOSql cashDAOSql = new CashDAOSql();
            System.out.println("Если хотите купить фонд нажмите: 1\nВыход обратно в меню нажмите: 2");
                Scanner scanner1 = new Scanner(System.in);
                int Operation = scanner1.nextInt();
                if (Operation == 1) {

                    //Получаем фонд по Id
                    System.out.println("Укажите Id фонда");
                    int FondId = scanner1.nextInt();
                    foundStructure = getFondById(FondId);
                    //Получение цены выбранного фонда из списка Фондов
                    float FondPrice = (float) Fonds.get(FondId).getFondPrice();

                    //-----Получение баланса с базы данных
                    float balance = cashDAOSql.getBalance().getBalance();
                    //-------------------

                    System.out.println("Укажите сколько паёв хотите купить");
                    Scanner scanner2 = new Scanner(System.in);

                    //Вычисление баланса после покупки
                    int Kolichestvo = scanner2.nextInt();
                    float SummaPokupki = Kolichestvo * FondPrice;
                    float NewBalance = balance - Kolichestvo * FondPrice;
                    System.out.println("Сумма вашей покупки составляет: " + SummaPokupki);
                    System.out.println("Ваш баланс: " + NewBalance);


                    //Занесение покупки в базу данных
                    String Sql = "insert into portfolio (id, fondname, amountfond, summafond) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(Sql);
                    preparedStatement.setInt(1,foundStructure.getId());
                    preparedStatement.setString(2,foundStructure.getFondName());
                    preparedStatement.setInt(3, foundStructure.setAmountFond(Kolichestvo));
                    preparedStatement.setFloat(4, foundStructure.setSummaFond(SummaPokupki));
                    preparedStatement.execute();


                    //Изменение баланса в базе данных
                    cashDAOSql.updateBalance(NewBalance);

        }
                return foundStructure;
    }


    //Получение портфеля
    @Override
    public Portfolio getPortfolio() throws SQLException {
        Portfolio portfolio = new Portfolio();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM portfolio");
        System.out.println("Ваш портфель на данный момент: ");
        System.out.println("Название Фонда         Количество паёв      Общая сумма" );
        while (resultSet.next()){
            portfolio.setId(resultSet.getInt("id"));
            portfolio.setName(resultSet.getString("fondname"));
            portfolio.setAmountFond(resultSet.getInt("amountfond"));
            portfolio.setSummaFond(resultSet.getFloat("summafond"));
            System.out.println(portfolio.getName() + "   " +
                    portfolio.getAmountFond() + "                   " + portfolio.getSummaFond());
        }
        return portfolio;
    }
}



