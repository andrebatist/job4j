package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private Map<User, List<Account>> data = new HashMap<>();

    public Data() {

    }

    public Data(Map<User, List<Account>> data) {
        this.data = data;
    }

    public Map<User, List<Account>> getData() {
        return data;
    }

    public void setData(Map<User, List<Account>> data) {
        this.data = data;
    }

    public void addUser(User user) {
        this.data.put(user, new ArrayList<>());
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

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                  BigDecimal amount) {
        Account outAcc = null;
        Map.Entry<User, List<Account>> src = getEntryByPassportAndRequisite(srcPassport);
        int accIndex = getAccountIndexfromEntry(srcPassport, srcRequisite);
        if (accIndex == -1) return false;
        Account srcAcc = src.getValue().get(accIndex);
        if (!checkAccount(srcAcc,amount)) return false;
        Map.Entry<User, List<Account>> out = getEntryByPassportAndRequisite(destPassport);
        if ((src == null) || (out == null)) return false;
        if (!checkAccount(srcAcc, amount)) return false;
        return false;
    }


    private Map.Entry<User, List<Account>> getEntryByPassportAndRequisite(String srcPassport) {
        for (Map.Entry<User, List<Account>> entry : this.data.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport)) {
              //  for (Account account : entry.getValue()) {
                  //  if (account.getRequisites().equals(srcRequisite)) {
                      //  acc = account;
                        return entry;
                  //  }
             //   }
            }
        }
        return null;
    }

    private int getAccountIndexfromEntry(String passport,  String requisite) {
        List<Account> accs = getUserAccounts(passport);
        for (int i=0; i< accs.size(); i++) {
            if (accs.get(i).getRequisites().equals(requisite)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkAccount(Account acc, BigDecimal amount) {
        return  acc.getValue().subtract(amount).doubleValue() > 0;
    }
}
