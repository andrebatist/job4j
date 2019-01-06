package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 12.11.2018
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Consumer.
     */
    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(this.new AddItem(0, "0. Add new Item"));
        this.actions.add(new MenuTracker.ShowAll(1, "1. Show all items"));
        this.actions.add(new EditItem(2, "2. Edit item"));
        this.actions.add(new DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(5, "5. Find items by name"));
        this.actions.add(new Exit(6, "6. Exit Program"));
    }

    /**
     * Метод заполняет массив ключей операций.
     *
     * @return Массив ключей.
     */
    public List<Integer> setRanges() {
        List<Integer> ranges = new ArrayList<>();
        for (UserAction action : this.actions) {
            ranges.add(Integer.parseInt(action.key()));
        }
        return ranges;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public String select(String key) {
        this.actions.get(Integer.valueOf(key)).execute(this.input, this.tracker);
        return key;
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * Редактирование заявки.
     */
    private class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item newItem = new Item(name, desc);
            if (tracker.replace(id, newItem)) {
                output.accept(newItem.toString());
                output.accept("------------ Заявка " + id + " отредактирована --------------");
            } else {
                output.accept("------------ Заявка с таким id отсутствует --------------");
            }
        }
    }

    /**
     * Добавление новый заявки в хранилище.
     */
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Вывод списка всех заявок.
     */
    private class ShowAll extends BaseAction {
        public ShowAll(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Список всех заявок --------------");
            List<Item> items = tracker.findAll();
            for (Item item : items) {
                output.accept(item.toString());
            }
            output.accept("------------ Конец списка --------------");
        }
    }

    /**
     * Удаление заявки.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                output.accept("------------ Заявка " + id + " удалена --------------");
            } else {
                output.accept("------------ Заявка с таким id отсутствует --------------");
            }
        }
    }

    /**
     * Поиск заявки по id.
     */
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(item.toString());
                output.accept("------------ Заявка " + item.getId() + " найдена --------------");
            } else {
                output.accept("------------ Заявка с таким id не найдена --------------");
            }
        }
    }

    /**
     * Поиск заявок по имени.
     */
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки : ");
            List<Item> items = tracker.findByName(name);
            output.accept("------------ Результат поиска --------------");
            for (Item item : items) {
                output.accept(item.toString());
            }
            output.accept("------------ Конец списка --------------");
        }
    }

    /**
     * Выход из программы.
     */
    private class Exit extends BaseAction {
        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
