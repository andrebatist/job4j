package ru.job4j.search;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 2.12.2018
 */
public class Person {
    /**
     * Имя.
     */
    private String name;
    /**
     * Фамилия.
     */
    private String surname;
    /**
     * Телефон.
     */
    private String phone;
    /**
     * Адрес.
     */
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
