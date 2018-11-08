package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 5.11.2018
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    public Item[] getItems() {
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
        this.items[this.position++] = item;
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
    public void replace(String id, Item item) {
        item.setId(id);
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод удаляет заявку по id.
     *
     * @param id Id заявки.
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i + 1);
                this.position--;
                break;
            }
        }
    }

    /**
     * Метод выводит все созданные заявки.
     *
     * @return Массив заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод поиска заявок по строке в имени.
     *
     * @param key Строка поиска.
     * @return Массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] tItems = new Item[this.position];
        int count = 0;
        for (Item item : this.items) {
            if (item == null) {
                break;
            }
            if (item.getName().equals(key)) {
                tItems[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(tItems, count);
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
            if ((item != null) && (item.getId().equals(id))) {
                resItem = item;
                break;
            }
        }
        return resItem;
    }
}
