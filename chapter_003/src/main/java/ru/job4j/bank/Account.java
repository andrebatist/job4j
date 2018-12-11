package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.12.2018
 */
public class Account {
    /**
     * Баланс счета.
     */
    private BigDecimal value;
    /**
     * Реквизиты.
     */
    private String requisites;

    public Account(BigDecimal value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return getValue().equals(account.getValue())
                && getRequisites().equals(account.getRequisites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getRequisites());
    }
}
