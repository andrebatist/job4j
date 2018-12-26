package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Singleton static final field. Eager loading.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 26.12.2018
 */
public class TrackerStaticFinalField {
    private static final TrackerStaticFinalField INSTANCE = new TrackerStaticFinalField();

    private TrackerStaticFinalField() {
    }

    public static TrackerStaticFinalField getInstance() {
        return INSTANCE;
    }

    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    public List<Item> getItems() {
        return items;
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        item.setCreated(System.currentTimeMillis());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод заменяет заявку по id.
     *
     * @param id   Id заявки.
     * @param item Новая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean found = false;
        item.setId(id);
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Метод удаляет заявку по id.
     *
     * @param id Id заявки.
     */
    public boolean delete(String id) {
        boolean found = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                found = true;
                this.items.remove(i);
                break;
            }
        }
        return found;
    }

    /**
     * Метод выводит все созданные заявки.
     *
     * @return Массив заявок.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод поиска заявок по строке в имени.
     *
     * @param key Строка поиска.
     * @return Массив заявок.
     */
    public List<Item> findByName(String key) {
        List<Item> tItems = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                tItems.add(item);
            }
        }
        return tItems;
    }

    /**
     * Метод поиска заявки по id.
     *
     * @param id Id заявки.
     * @return Заявка.
     */
    public Item findById(String id) {
        Item resItem = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                resItem = item;
                break;
            }
        }
        return resItem;
    }
}
