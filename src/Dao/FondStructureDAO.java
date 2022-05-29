package Dao;

import model.FoundStructure;
import model.Person;

import java.sql.SQLException;
import java.util.List;

public interface FondStructureDAO {
    FoundStructure getFondById(int id) throws SQLException;
    List<FoundStructure> getAll() throws SQLException;
    void BuyFond(FoundStructure foundStructure) throws SQLException;
    void removeFond(FoundStructure foundStructure) throws SQLException;
    Person getBalance() throws SQLException;
}
