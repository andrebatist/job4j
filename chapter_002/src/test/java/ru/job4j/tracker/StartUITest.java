package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 10.11.2018
 */
public class StartUITest {
    /**
     * Дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Символ разделителя.
     */
    private final String ln = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Тест на ввод пользователем добавления записи.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест на ввод пользователем редактирования записи.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест на ввод пользователем удаления записи.
     */
    @Test
    public void whenDeleteThenTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }

    /**
     * Тест на вывод всех заявок.
     */
    @Test
    public void whenShowAllThenOutTwoItems() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first", "desc"));
        Item second = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String outStr = new String(out.toByteArray());
        String content = new StringBuilder()
                .append("------------ Список всех заявок --------------")
                .append(ln)
                .append(first)
                .append(ln)
                .append(second)
                .append(ln)
                .append("------------ Конец списка --------------")
                .toString();
        assertTrue(outStr.contains(content));
    }

    /**
     * Тест на поиск заявки по id.
     */
    @Test
    public void whenFindItemByIdOutItemFound() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        String outStr = new String(out.toByteArray());
        String content = new StringBuilder()
                .append("------------ Поиск заявки по id --------------")
                .append(ln)
                .append(item)
                .append(ln)
                .append("------------ Заявка " + item.getId() + " найдена --------------")
                .toString();
        assertTrue(outStr.contains(content));
    }

    /**
     * Тест на поиск заявок по имени.
     */
    @Test
    public void whenFindItemsByNameThenTwoItemsFound() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("text", "desc1"));
        Item second = tracker.add(new Item("text", "desc2"));
        Item third = tracker.add(new Item("name", "desc3"));
        Input input = new StubInput(new String[]{"5", "text", "6"});
        new StartUI(input, tracker).init();
        String outStr = new String(out.toByteArray());
        String content = new StringBuilder()
                .append("------------ Результат поиска --------------")
                .append(ln)
                .append(first)
                .append(ln)
                .append(second)
                .append(ln)
                .append("------------ Конец списка --------------")
                .toString();
        assertTrue(outStr.contains(content));
    }

}