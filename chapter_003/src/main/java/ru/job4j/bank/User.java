package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.12.2018
 */
public class User {
    /**
     * Имя.
     */
    private String name;
    /**
     * Паспорт.
     */
    private String passport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getName(), user.getName())
                && Objects.equals(getPassport(), user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassport());
    }
}
