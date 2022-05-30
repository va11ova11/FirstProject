package Dao;

import model.FoundStructure;
import model.Person;
import model.Portfolio;

import java.sql.SQLException;
import java.util.List;

public interface FondStructureDAO {
    FoundStructure getFondById(int id) throws SQLException;
    List<FoundStructure> getAll() throws SQLException;
    FoundStructure BuyFond() throws SQLException;
    Portfolio getPortfolio() throws SQLException;
}
