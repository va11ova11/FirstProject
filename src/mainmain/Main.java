package mainmain;

import Dao.CashDAOSql;
import Dao.FondStructureServicePostgreSql;
import FondOperation.OperationDAOImpl;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        CashDAOSql cashDAOSql = new CashDAOSql();
        CashDAOSql cashDAOSql1 = new CashDAOSql();
        CashDAOSql cashDAOSql2 = new CashDAOSql();
        FondStructureServicePostgreSql fondStructureServicePostgreSql = new FondStructureServicePostgreSql();
        FondStructureServicePostgreSql fondStructureServicePostgreSql1 = new FondStructureServicePostgreSql();
        FondStructureServicePostgreSql fondStructureServicePostgreSql2 = new FondStructureServicePostgreSql();


        //Менюшка
        while (true) {
            System.out.println("Что вы хотите?");
            System.out.println("1. Пополнение счёта нажмите");
            System.out.println("2. Посмтореть баланс");
            System.out.println("3. Снять с баланса");
            System.out.println("4. Купить фонд");
            System.out.println("5. Продать фонд");
            System.out.println("6. Посмотреть портфель");
            Scanner scanner = new Scanner(System.in);
            int command1 = scanner.nextInt();

            switch (command1) {
                case 1:
                    //Пополнение баланса
                    cashDAOSql.cashInBalance();
                    break;

                case 2:
                    //Показать баланс
                    cashDAOSql1.getPrintBalance();
                    break;

                case 3:
                    //Снять с баланса
                    cashDAOSql2.cashOutBalance();
                    break;

                case 4:
                    //Покупка фонда + изменение баланса в базе данных
                    fondStructureServicePostgreSql.BuyFond();
                    break;

                case 5:
                    //Продать фонд + изменение баланса в базе данных
                    fondStructureServicePostgreSql1.sellFond();

                case 6:
                    //Вывод портфеля с фондами
                    fondStructureServicePostgreSql2.getPortfolio();

//                case 8:
//                    OperationDAOImpl operationDAO = new OperationDAOImpl();
//                    System.out.println(operationDAO.getPresentValueById(1));
            }
        }
    }
}








