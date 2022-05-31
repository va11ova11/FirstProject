package Dao;

import model.FoundStructure;

import java.sql.SQLException;
import java.util.List;

public interface FondStructureDAO {
    FoundStructure getFondById(int id) throws SQLException;
    List<FoundStructure> getAll() throws SQLException;
    void BuyFond() throws SQLException;
    void getPortfolio() throws SQLException;
    void sellFond() throws SQLException;
}
