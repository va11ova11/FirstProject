package mainmain;
import Dao.CashDAOSql;
import Dao.FondStructureServicePostgreSql;
import model.Portfolio;

import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {

        //Менюшка
        while (true) {
            System.out.println("Что вы хотите?");
            System.out.println("1. Пополнение счёта нажмите");
            System.out.println("2. Посмтореть баланс");
            System.out.println("3. Снять с баланса");
            System.out.println("4. Купить фонд");
            System.out.println("5. Посмотреть портфель");
            Scanner scanner = new Scanner(System.in);
            int command1 = scanner.nextInt();


            //Пополнение баланса
            if (command1 == 1) {
              CashDAOSql cashDAOSql = new CashDAOSql();
              cashDAOSql.cashInBalance();
            }

            //Показать баланс
            if (command1 == 2) {
                CashDAOSql cashDAO= new CashDAOSql();
                cashDAO.getBalance();
            }

            //Снять с баланса
            if (command1 == 3) {
                CashDAOSql cashDAOSql = new CashDAOSql();
                cashDAOSql.cashOutBalance();
            }

            //Покупка фонда + изменение баланса в базе данных
            if (command1 == 4) {
                FondStructureServicePostgreSql fondStructureServicePostgreSql = new FondStructureServicePostgreSql();
                fondStructureServicePostgreSql.BuyFond();
            }

            //Вывод портфеля с фондами
            if (command1 ==5){
                FondStructureServicePostgreSql fondStructureServicePostgreSql = new FondStructureServicePostgreSql();
                fondStructureServicePostgreSql.getPortfolio();
        }
        }
    }
}







