package Dao;

import model.FoundStructure;
import model.Portfolio;

import java.sql.SQLException;
import java.util.List;

public interface FondStructureDAO {

    //Получение всех фондов с базы данных + покупка и изменение баланса в базе данных
    FoundStructure getFondById(int id) throws SQLException;

    //Получение всех фондов с базы и передача их в список
    List<FoundStructure> getAll() throws SQLException;

    //Получение всех фондов с базы данных + покупка и изменение баланса в базе данных
    void BuyFond() throws SQLException;

    //Продажа фонда обновление нового числа фондов + изменение баланса
    List<Portfolio> getPortfolio() throws SQLException;

    //Продажа фонда обновление нового числа фондов + изменение баланса
    void sellFond() throws SQLException;
}
