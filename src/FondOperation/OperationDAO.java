package FondOperation;

import java.sql.SQLException;

public interface OperationDAO {

    //Получение суммы всего портфеля
    float getSumPortfolio() throws SQLException;

    //Получение текущей суммы фонда
    float getPresentValueById(int id) throws SQLException;
}
