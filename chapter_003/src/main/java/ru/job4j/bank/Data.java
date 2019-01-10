package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.*;

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
        Optional<Map.Entry<User, List<Account>>> opt = getUserListEntry(passport);
        if (!opt.isPresent()) {
            return;
        }
        opt.get().getValue().add(account);
    }

    /**
     * Получить данные пользователя по паспорту.
     *
     * @param passport Паспорт.
     * @return Данные пользователя.
     */
    private Optional<Map.Entry<User, List<Account>>> getUserListEntry(String passport) {
        return this.data.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Удаление счета пользователя.
     *
     * @param passport Паспорт.
     * @param account  Счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        Optional<Map.Entry<User, List<Account>>> opt = getUserListEntry(passport);
        if (!opt.isPresent()) {
            return;
        }
        this.data.get(opt.get().getKey()).remove(account);
    }

    /**
     * Получить список счетов пользователя.
     *
     * @param passport Паспорт.
     * @return Список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        Optional<Map.Entry<User, List<Account>>> opt = getUserListEntry(passport);
        return opt.map(Map.Entry::getValue).orElse(null);
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
        return srcAcc.transfer(destAcc, amount);
    }

    /**
     * Получение счета по паспорту и реквизитам.
     *
     * @param passport  Паспорт.
     * @param requisite Реквизиты.
     * @return Счет.
     */
    private Account getAccountByPassportAndRequisite(String passport, String requisite) {
        Optional<Map.Entry<User, List<Account>>> opt = getUserListEntry(passport);
        if (!opt.isPresent()) {
            return null;
        }
        Optional<Account> accOpt = opt.get().getValue().stream()
                .filter(account -> account.getRequisites().equals(requisite))
                .findFirst();
        return accOpt.isPresent() ? accOpt.get() : null;
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
