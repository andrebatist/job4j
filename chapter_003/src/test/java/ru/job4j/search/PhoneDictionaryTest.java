package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 2.12.2018
 */
public class PhoneDictionaryTest {
    /**
     * Тест на поиск с одним результатом.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест на поиск с двумя результами.
     */
    @Test
    public void whenFindByNameThenTwoPersons() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Popov", "534872", "Bryansk"));
        phones.add(new Person("Petr", "Popovsky", "8805553535", "Omsk"));
        List<Person> persons = phones.find("Popov");
        assertThat(persons.size(), is(2));
    }
}