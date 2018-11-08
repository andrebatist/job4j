package ru.job4j.tracker;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 8.11.2018
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявок по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    private final String[] menu = new String[]
            {"0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item",
                    "4. Find item by Id", "5. Find items by name", "6. Exit Program"};

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            }
            if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            }
            if (EDIT.equals(answer)) {
                this.editItem();
            }
            if (DELETE.equals(answer)) {
                this.deleteItem();
            }
            if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            }
            if (FIND_BY_NAME.equals(answer)) {
                this.findItemsByName();
            }
            if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит список всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("Id : " + item.getId() + " Имя : " + item.getName() + " Описание : " + item.getDesc());
        }
        System.out.println("------------ Конец списка --------------");
    }

    /**
     * Метод редактирования заявки.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item newItem = new Item(name, desc);
            this.tracker.replace(id, newItem);
            item = this.tracker.findById(id);
            System.out.println("Id : " + item.getId() + " Имя : " + item.getName() + " Описание : " + item.getDesc());
            System.out.println("------------ Заявка " + item.getId() + " отредактирована --------------");
        } else {
            System.out.println("------------ Заявка с таким id отсутствует --------------");
        }
    }

    /**
     * Метод удаления заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.tracker.delete(id);
            System.out.println("------------ Заявка " + id + " удалена --------------");
        } else {
            System.out.println("------------ Заявка с таким id отсутствует --------------");
        }
    }

    /**
     * Метод поиска заявки по id.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Id : " + item.getId() + " Имя : " + item.getName() + " Описание : " + item.getDesc());
            System.out.println("------------ Заявка " + item.getId() + " найдена --------------");
        } else {
            System.out.println("------------ Заявка с таким id не найдена --------------");
        }
    }

    /**
     * Метод поиска заявок по имени.
     */
    private void findItemsByName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки : ");
        Item[] items = this.tracker.findByName(name);
        System.out.println("------------ Результат поиска --------------");
        for (Item item : items) {
            System.out.println("Id : " + item.getId() + " Имя : " + item.getName() + " Описание : " + item.getDesc());
        }
        System.out.println("------------ Конец списка --------------");
    }

    /**
     * Метод отображает меню.
     */
    private void showMenu() {
        System.out.println("Меню");
        System.out.println(this.generateMenuItems(this.menu));
    }

    /**
     * Метод генерирует строку с элементами меню.
     *
     * @param items Массив с пунктами меню.
     * @return строка с разделителями.
     */
    private String generateMenuItems(String[] items) {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        int k = 0;
        for (String str : items) {
            k++;
            builder.append(str);
            if (k < items.length) {
                builder.append(ln);
            }
        }
        return builder.toString();
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
