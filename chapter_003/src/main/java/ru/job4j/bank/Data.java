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
        Map.Entry<User, List<Account>> src = getEntryByPassportAndRequisite(srcPassport, srcRequisite);
        Map.Entry<User, List<Account>> dest = getEntryByPassportAndRequisite(destPassport, destRequisite);
        if ((src == null) || (dest == null)) {
            return false;
        }
        int srcAccIndex = getAccountIndexFromList(src.getValue(), srcRequisite);
        Account srcAcc = src.getValue().get(srcAccIndex);
        if (!checkAccountBalance(srcAcc, amount)) {
            return false;
        }
        int destAccIndex = getAccountIndexFromList(dest.getValue(), destRequisite);
        Account destAcc = dest.getValue().get(destAccIndex);
        return updateAccountsData(amount, src, dest, srcAccIndex, srcAcc, destAccIndex, destAcc);
    }

    /**
     * Обновление данных счетов.
     *
     * @param amount       Сумма.
     * @param src          Запись о пользователе отправителе.
     * @param dest         Запись о пользователе получателе.
     * @param srcAccIndex  Индекс счета отправителя.
     * @param srcAcc       Счет отправителя.
     * @param destAccIndex Индекс счета получателя.
     * @param destAcc      Счет получателя.
     * @return Обновились ли данные.
     */
    private boolean updateAccountsData(BigDecimal amount, Map.Entry<User, List<Account>> src, Map.Entry<User,
            List<Account>> dest, int srcAccIndex, Account srcAcc, int destAccIndex, Account destAcc) {
        updateAccounts(srcAcc, destAcc, amount);
        src.getValue().set(srcAccIndex, srcAcc);
        dest.getValue().set(destAccIndex, destAcc);
        this.data.put(src.getKey(), src.getValue());
        this.data.put(dest.getKey(), dest.getValue());
        return true;
    }

    /**
     * Получение записи по паспорту и реквизитам.
     *
     * @param passport  Паспорт.
     * @param requisite Реквизиты.
     * @return Запись пользователя.
     */
    private Map.Entry<User, List<Account>> getEntryByPassportAndRequisite(String passport, String requisite) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                for (Account account : entry.getValue()) {
                    if (account.getRequisites().equals(requisite)) {
                        return entry;
                    }
                }
                break;
            }
        }
        return null;
    }

    /**
     * Получение индекса счета.
     *
     * @param list      Список счетов.
     * @param requisite Реквизиты.
     * @return Индекс.
     */
    private int getAccountIndexFromList(List<Account> list, String requisite) {
        for (Account acc : list) {
            if (acc.getRequisites().equals(requisite)) {
                return list.indexOf(acc);
            }
        }
        return -1;
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

    /**
     * Обновление счетов отправителя и получателя.
     *
     * @param src    Счет отправителя.
     * @param dest   Счет получателя.
     * @param amount Сумма перевода.
     */
    private void updateAccounts(Account src, Account dest, BigDecimal amount) {
        src.setValue(src.getValue().subtract(amount));
        dest.setValue(dest.getValue().add(amount));
    }

}
