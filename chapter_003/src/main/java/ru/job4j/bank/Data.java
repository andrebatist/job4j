package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.12.2018
 */
public class Data {
    /**
     * Карта пользователя со списком счетов.
     */
    private Map<User, List<Account>> data;

    public Data(Map<User, List<Account>> data) {
        this.data = data;
    }

    public Map<User, List<Account>> getData() {
        return data;
    }

    public void setData(Map<User, List<Account>> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Data)) {
            return false;
        }
        Data data1 = (Data) o;
        return Objects.equals(getData(), data1.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData());
    }

    /**
     * Добавление пользователя.
     *
     * @param user Пользователь.
     */
    public void addUser(User user) {
        this.data.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя.
     *
     * @param user Пользователь.
     */
    public void deleteUser(User user) {
        this.data.remove(user);
    }

    /**
     * Добавление аккаунта пользователю.
     *
     * @param passport Паспорт.
     * @param account  Счет.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
                break;
            }
        }
    }

    /**
     * Удаление счета пользователя.
     *
     * @param passport Паспорт.
     * @param account  Счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                this.data.get(entry.getKey()).remove(account);
                break;
            }
        }
    }

    /**
     * Получить список счетов пользователя.
     *
     * @param passport Паспорт.
     * @return Список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Перевод средств с одного счета на другой.
     *
     * @param srcPassport   Паспорт отправителя.
     * @param srcRequisite  Реквизиты отправителя.
     * @param destPassport  Паспорт получателя.
     * @param destRequisite Реквизиты получателя.
     * @param amount        Сумма перевода.
     * @return Прошел ли перевод.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite,
                                 BigDecimal amount) {
        Account srcAcc = getAccountByPassportAndRequisite(srcPassport, srcRequisite);
        Account destAcc = getAccountByPassportAndRequisite(destPassport, destRequisite);
        if ((srcAcc == null) || (destAcc == null) || (!checkAccountBalance(srcAcc, amount))) {
            return false;
        }
        srcAcc.transfer(true, amount);
        destAcc.transfer(false, amount);
        updateData(srcPassport, srcAcc);
        updateData(destPassport, destAcc);
        return true;
    }

    /**
     * Обновление данных карты.
     *
     * @param passport Паспорт.
     * @param account  Счет.
     */
    private void updateData(String passport, Account account) {
        User user = getUserByPassport(passport);
        int index = getUserAccounts(passport).indexOf(account);
        List<Account> accountList = this.data.get(user);
        accountList.set(index, account);
        this.data.put(user, accountList);
    }

    /**
     * Получение пользователя по паспорту.
     *
     * @param passport Паспорт.
     * @return Пользователь.
     */
    private User getUserByPassport(String passport) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Получение счета по паспорту и реквизитам.
     *
     * @param passport  Паспорт.
     * @param requisite Реквизиты.
     * @return Счет.
     */
    private Account getAccountByPassportAndRequisite(String passport, String requisite) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                for (Account account : entry.getValue()) {
                    if (account.getRequisites().equals(requisite)) {
                        return account;
                    }
                }
                break;
            }
        }
        return null;
    }

    /**
     * Проверка баланса счета.
     *
     * @param acc    Счет.
     * @param amount Сумма перевода.
     * @return Достаточно ли стредств.
     */
    private boolean checkAccountBalance(Account acc, BigDecimal amount) {
        return acc.getValue().compareTo(amount) >= 0;
    }

}
