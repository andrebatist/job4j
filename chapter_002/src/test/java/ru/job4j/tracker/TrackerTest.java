package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 5.11.2018
 */
public class TrackerTest {
    /**
     * Тест добавление новой заявки.
     */
//    @Test
//    public void whenAddNewItemToItems() {
//        Tracker tracker = new Tracker();
//        Item newItem = new Item("test1", "testDescription", 123L);
//        tracker.add(newItem);
//        assertThat(tracker.getItems()[0].getName(), is("testDescription"));
//    }
//
//    /**
//     * Тест замены заявки.
//     */
//    @Test
//    public void whenReplaceNameThenReturnNewName() {
//        Tracker tracker = new Tracker();
//        Item previous = new Item("test1", "testDescription", 123L);
//        tracker.add(previous);
//        Item next = new Item("test2", "testDescription2", 1234L);
//        next.setId(previous.getId());
//        tracker.replace(previous.getId(), next);
//        assertThat(tracker.findById(previous.getId()).getName(), is("testDescription2"));
//    }
//
//    /**
//     * Тест удалить вторую по порядку заявку.
//     */
//    @Test
//    public void deleteSecondItem() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "testDescription", 123L));
//        tracker.add(new Item("test2", "testDescription2", 123L));
//        tracker.add(new Item("test3", "testDescription3", 123L));
//        tracker.delete(tracker.getItems()[1].getId());
//        assertThat(tracker.getItems()[1].getName(), is("testDescription3"));
//    }
//
//    /**
//     * Тест удалить первую заявку.
//     */
//    @Test
//    public void deleteFirstItem() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "testDescription", 123L));
//        tracker.add(new Item("test2", "testDescription2", 123L));
//        tracker.delete(tracker.getItems()[0].getId());
//        assertThat(tracker.getItems()[0].getName(), is("testDescription2"));
//    }
//
//    /**
//     * Тест удалить последнюю по порядку заявку.
//     */
//    @Test
//    public void deleteLastItem() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "testDescription", 123L));
//        tracker.add(new Item("test2", "testDescription2", 123L));
//        tracker.delete(tracker.getItems()[1].getId());
//        assertThat(tracker.getItems()[0].getName(), is("testDescription"));
//        assertNull(tracker.getItems()[1]);
//    }
//
//    /**
//     * Тест получить массив всех заявок.
//     */
//    @Test
//    public void findAll() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "testDescription", 123L));
//        Item[] res = tracker.findAll();
//        assertThat(res.length, is(1));
//    }
//
//    /**
//     * Тест найти 2 заяки по строке поиска.
//     */
//    @Test
//    public void findByNameResTwo() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "text", 123L));
//        tracker.add(new Item("test2", "testDescription", 123L));
//        tracker.add(new Item("test3", "text3", 123L));
//        tracker.add(new Item("test4", "testDescription", 123L));
//        Item[] res = tracker.findByName("testDescription");
//        assertThat(res.length, is(2));
//        assertThat(res[0].getName(), is("testDescription"));
//        assertThat(res[1].getName(), is("testDescription"));
//    }
//
//    /**
//     * Тест найти заявку по id.
//     */
//    @Test
//    public void findByIdResult() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "text", 123L));
//        tracker.add(new Item("test2", "testDescription2", 123L));
//        Item res = tracker.findById(tracker.getItems()[0].getId());
//        assertThat(res.getName(), is("text"));
//    }
//
//    /**
//     * Тест вернуть пустую заявку.
//     */
//    @Test
//    public void findByIdResultNull() {
//        Tracker tracker = new Tracker();
//        tracker.add(new Item("test1", "text", 123L));
//        Item res = tracker.findById("1111");
//        assertNull(res);
//    }
}