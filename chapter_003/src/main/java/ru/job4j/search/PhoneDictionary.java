package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 2.12.2018
 */
public class PhoneDictionary {
    /**
     * Список записей.
     */
    private List<Person> persons = new ArrayList<>();

    /**
     * Добавление записи в справочник.
     *
     * @param person Запись.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        return this.persons.stream().filter(person -> (person.getName().contains(key))
                || (person.getSurname().contains(key))
                || (person.getAddress().contains(key))
                || (person.getPhone().contains(key))).collect(Collectors.toList());
    }
}
