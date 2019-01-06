package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 8.11.2018
 */
public class StartUI {
    /**
     * Ключи операций.
     */
    private List<Integer> ranges = new ArrayList<>();
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Consumer.
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        this.ranges = menu.setRanges();
        do {
            System.out.println("Меню");
            menu.show();
            String key = menu.select(String.valueOf(input.ask("Select:", ranges)));
            if ("6".equals(key)) {
                exit = true;
            }
        } while (!exit);
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(
                new ConsoleInput()
        ), new Tracker(), System.out::println).init();
    }
}
