package Dao;

import model.Bank;
import model.Person;

import java.sql.SQLException;

public interface CashDAO {
    //Получить баланс
    Person getBalance() throws SQLException;

    //Пополнить баланс
    Person getPrintBalance() throws SQLException;

    //Обновить баланс при покупке фонда
    void updateBalance(float NewBalance) throws SQLException;

    //Пополнить баланс + изменение баланса в базе данных
    Person cashInBalance() throws SQLException;

    //Снять с баланса + изменение в базе данных
    Person cashOutBalance() throws SQLException;

}
