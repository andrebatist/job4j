package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Data {
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
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data1 = (Data) o;
        return Objects.equals(getData(), data1.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData());
    }

    public void addUser(User user) {
        this.data.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.data.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                this.data.get(entry.getKey()).remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite,
                                 BigDecimal amount) {
        Map.Entry<User, List<Account>> src = getEntryByPassportAndRequisite(srcPassport, srcRequisite);
        Map.Entry<User, List<Account>> dest = getEntryByPassportAndRequisite(destPassport, destRequisite);
        if ((src == null) || (dest == null)) return false;
        int srcAccIndex = getAccountIndexFromList(src.getValue(), srcRequisite);
        Account srcAcc = src.getValue().get(srcAccIndex);
        if (!checkAccountBalance(srcAcc, amount)) return false;
        int destAccIndex = getAccountIndexFromList(dest.getValue(), destRequisite);
        Account destAcc = dest.getValue().get(destAccIndex);
        return updateAccountsData(amount, src, dest, srcAccIndex, srcAcc, destAccIndex, destAcc);
    }

    private boolean updateAccountsData(BigDecimal amount, Map.Entry<User, List<Account>> src, Map.Entry<User,
            List<Account>> dest, int srcAccIndex, Account srcAcc, int destAccIndex, Account destAcc) {
        updateAccounts(srcAcc, destAcc, amount);
        src.getValue().set(srcAccIndex, srcAcc);
        dest.getValue().set(destAccIndex, destAcc);
        this.data.put(src.getKey(), src.getValue());
        this.data.put(dest.getKey(), dest.getValue());
        return true;
    }


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

    private int getAccountIndexFromList(List<Account> list, String requisite) {
        for (Account acc : list) {
            if (acc.getRequisites().equals(requisite)) {
                return list.indexOf(acc);
            }
        }
        return -1;
    }

    private boolean checkAccountBalance(Account acc, BigDecimal amount) {
        return acc.getValue().compareTo(amount) >= 0;
    }

    private void updateAccounts(Account src, Account dest, BigDecimal amount) {
        src.setValue(src.getValue().subtract(amount));
        dest.setValue(dest.getValue().add(amount));
    }

}
