package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

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
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if ((person.getName().contains(key))
                    || (person.getSurname().contains(key))
                    || (person.getAddress().contains(key))
                    || (person.getPhone().contains(key))) {
                result.add(person);
            }
        }
        return result;
    }
}
