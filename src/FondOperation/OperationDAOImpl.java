package FondOperation;

import java.sql.*;

public class OperationDAOImpl implements OperationDAO{

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
    public float getSumPortfolio() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM portfolio_operation");
        float summa_fond = 0;
        while (resultSet.next()){
            summa_fond += resultSet.getFloat("summa_fond");
        }
        return summa_fond;
    }

    @Override
    public float getPresentValueById(int id) throws SQLException {
        String Sql = "SELECT summa_fond FROM portfolio_operation WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(Sql);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        float summa_fond = 0;
        while (resultSet.next()){
           summa_fond =  resultSet.getFloat("summa_fond");
        }

        return summa_fond;
    }
}
