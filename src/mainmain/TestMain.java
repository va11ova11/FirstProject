package mainmain;

import Dao.FondStructureServicePostgreSql;
import model.FoundStructure;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws SQLException {
        List<FoundStructure> foundStructure = new FondStructureServicePostgreSql().getAll();
        System.out.println("Введите айди фонда");
        Scanner scanner = new Scanner(System.in);
        int FondId = scanner.nextInt();
        System.out.println(foundStructure.get(FondId).getId() + "  " + foundStructure.get(FondId).getFondName() + "  " + foundStructure.get(FondId).getFondPrice()
        + "  " + foundStructure.get(FondId).getFondProfitability() + "%");
    }
}
