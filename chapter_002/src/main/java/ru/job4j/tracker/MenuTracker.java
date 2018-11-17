package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Редактирование заявки.
 */
class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите id заявки :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item newItem = new Item(name, desc);
        if (tracker.replace(id, newItem)) {
            System.out.println(newItem);
            System.out.println("------------ Заявка " + id + " отредактирована --------------");
        } else {
            System.out.println("------------ Заявка с таким id отсутствует --------------");
        }
    }
}

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
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
    public int[] setRanges() {
        int[] ranges = new int[this.actions.size()];
        int k = 0;
        for (UserAction action : this.actions) {
            ranges[k] = Integer.parseInt(action.key());
            k++;
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
                System.out.println(action.info());
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
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Вывод списка всех заявок.
     */
    private static class ShowAll extends BaseAction {
        public ShowAll(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список всех заявок --------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
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
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка " + id + " удалена --------------");
            } else {
                System.out.println("------------ Заявка с таким id отсутствует --------------");
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
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
                System.out.println("------------ Заявка " + item.getId() + " найдена --------------");
            } else {
                System.out.println("------------ Заявка с таким id не найдена --------------");
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
            System.out.println("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки : ");
            Item[] items = tracker.findByName(name);
            System.out.println("------------ Результат поиска --------------");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка --------------");
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
