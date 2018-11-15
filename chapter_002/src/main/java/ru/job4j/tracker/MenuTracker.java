package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Редактирование заявки.
 */
class EditItem implements UserAction {

    @Override
    public String key() {
        return "2";
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

    @Override
    public String info() {
        return "2. Edit item";
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
        this.actions.add(this.new AddItem());
        this.actions.add(new MenuTracker.ShowAll());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new Exit());
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
    private class AddItem implements UserAction {
        @Override
        public String key() {
            return "0";
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

        @Override
        public String info() {
            return "0. Add new Item";
        }
    }

    /**
     * Вывод списка всех заявок.
     */
    private static class ShowAll implements UserAction {
        @Override
        public String key() {
            return "1";
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

        @Override
        public String info() {
            return "1. Show all items";
        }
    }

    /**
     * Удаление заявки.
     */
    private class DeleteItem implements UserAction {
        @Override
        public String key() {
            return "3";
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

        @Override
        public String info() {
            return "3. Delete item";
        }
    }

    /**
     * Поиск заявки по id.
     */
    private class FindItemById implements UserAction {
        @Override
        public String key() {
            return "4";
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

        @Override
        public String info() {
            return "4. Find item by Id";
        }
    }

    /**
     * Поиск заявок по имени.
     */
    private class FindItemsByName implements UserAction {
        @Override
        public String key() {
            return "5";
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

        @Override
        public String info() {
            return "5. Find items by name";
        }
    }

    /**
     * Выход из программы.
     */
    private class Exit implements UserAction {
        @Override
        public String key() {
            return "6";
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return "6. Exit Program";
        }
    }
}
