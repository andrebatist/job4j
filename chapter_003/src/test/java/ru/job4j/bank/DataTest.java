package ru.job4j.bank;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 11.12.2018
 */
public class DataTest {
    /**
     * Тест добавление нового пользователя.
     */
    @Test
    public void addNewUser() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        Map<User, List<Account>> expMap = new HashMap<>();
        expMap.put(new User("Victor", "1"), new ArrayList<>());
        Data expect = new Data(expMap);
        assertThat(result, is(expect));
    }

    /**
     * Тест удаление пользователя.
     */
    @Test
    public void deleteUser() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        result.deleteUser(new User("Victor", "1"));
        assertThat(result.getData().size(), is(0));
    }

    /**
     * Тест удаление аккаунта пользователя.
     */
    @Test
    public void deleteAccountFromUser() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        result.addAccountToUser("1", new Account(new BigDecimal(40000.50), "1234"));
        result.addAccountToUser("1", new Account(new BigDecimal(5000.00), "5678"));
        result.deleteAccountFromUser("1", new Account(new BigDecimal(40000.50), "1234"));
        Data expect = new Data(new HashMap<>());
        expect.addUser(new User("Victor", "1"));
        expect.addAccountToUser("1", new Account(new BigDecimal(5000.00), "5678"));
        assertThat(result, is(expect));
    }

    /**
     * Тест получить все аккаунты.
     */
    @Test
    public void getUserAccounts() {
        Data data = new Data(new HashMap<>());
        data.addUser(new User("Victor", "1"));
        data.addAccountToUser("1", new Account(new BigDecimal(40000.50), "1234"));
        data.addAccountToUser("1", new Account(new BigDecimal(5000.00), "5678"));
        List<Account> result = data.getUserAccounts("1");
        List<Account> expect = new ArrayList<>(Arrays.asList(new Account(new BigDecimal(40000.50), "1234"),
                new Account(new BigDecimal(5000.00), "5678")));
        assertThat(result, is(expect));
    }

    /**
     * Тест перевести 40000 с одного счета на другой.
     */
    @Test
    public void when2Accounts2UsersThenTransfer40000() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        result.addAccountToUser("1", new Account(new BigDecimal(40000.50), "1234"));
        result.addUser(new User("Rick", "2"));
        result.addAccountToUser("2", new Account(new BigDecimal(0.00), "4321"));
        assertTrue(result.transferMoney("1", "1234", "2", "4321", new BigDecimal(40000)));
        Data expect = new Data(new HashMap<>());
        expect.addUser(new User("Victor", "1"));
        expect.addAccountToUser("1", new Account(new BigDecimal(0.50), "1234"));
        expect.addUser(new User("Rick", "2"));
        expect.addAccountToUser("2", new Account(new BigDecimal(40000.00), "4321"));
        assertThat(result, is(expect));
    }

    /**
     * Тест певести денег больше чем есть на счете.
     */
    @Test
    public void whenTransferMoreSumThenUserHaveOnAccountThenFalse() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        result.addAccountToUser("1", new Account(new BigDecimal(100.50), "1234"));
        result.addUser(new User("Rick", "2"));
        result.addAccountToUser("2", new Account(new BigDecimal(0.00), "4321"));
        assertFalse(result.transferMoney("1", "1234", "2", "4321", new BigDecimal(10000)));
    }

    /**
     * Тест перевод с неверными данными паспорта и реквизитов.
     */
    @Test
    public void whenTransferByWrongPassportAndReqThenFalse() {
        Data result = new Data(new HashMap<>());
        result.addUser(new User("Victor", "1"));
        result.addAccountToUser("1", new Account(new BigDecimal(100.50), "1234"));
        result.addUser(new User("Rick", "2"));
        result.addAccountToUser("2", new Account(new BigDecimal(0.00), "4321"));
        assertFalse(result.transferMoney("1111", "1234", "2", "4321", new BigDecimal(10000)));
        assertFalse(result.transferMoney("1", "hhhh", "2", "4321", new BigDecimal(10000)));
        assertFalse(result.transferMoney("1", "1234", "2222", "4321", new BigDecimal(10000)));
        assertFalse(result.transferMoney("1111", "1234", "2", "oooo", new BigDecimal(10000)));
    }
}