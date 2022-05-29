package mainmain;

import java.sql.*;

public class Daothrows{

    final String URL = "jdbc:postgresql://localhost:5432/portfolio";
    final String NAME = "postgres";
    final String PASSWORD = "123";
    Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);





    public Daothrows() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM fond");
        while (resultSet.next()) {
            System.out.println(resultSet.getFloat("balance"));
        }
    }
}
