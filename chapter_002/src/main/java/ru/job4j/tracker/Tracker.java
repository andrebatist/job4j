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
        for (int i = 0; i < this.items.length; i++) {
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
        int index = -1;
        boolean found = false;
        for (int i = 0; i < this.items.length; i++) {
            if ((this.items[i] != null) && (this.items[i].getId().equals(id))) {
                index = i;
                found = true;
                if (i + 1 == this.items.length) {
                    this.items[i] = null;
                }
            }
            if ((found) && (i + 1 < this.items.length)) {
                this.items[i] = this.items[i + 1];
            }
            if ((i + 1 == this.items.length) && (index > 0)) {
                this.items[i] = null;
                break;
            }
        }
        if ((this.position != 0) && (found)) {
            this.position--;
        }
    }

    /**
     * Метод выводит все созданные заявки.
     *
     * @return Массив заявок.
     */
    public Item[] findAll() {
        Item[] tItems = new Item[100];
        int count = 0;
        for (Item item : this.items) {
            if (item != null) {
                tItems[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(tItems, count);
    }

    /**
     * Метод поиска заявок по строке в имени.
     *
     * @param key Строка поиска.
     * @return Массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] tItems = new Item[100];
        char[] kChars = key.toCharArray();
        int count = 0;
        for (Item item : this.items) {
            if (item == null) {
                continue;
            }
            boolean res = true;
            char[] chars = item.getName().toCharArray();
            for (int j = 0; j < kChars.length; j++) {
                if (kChars[j] != chars[j]) {
                    res = false;
                    break;
                }
            }
            if (res) {
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
        Item resItem = new Item();
        boolean found = false;
        for (Item item : this.items) {
            if ((item != null) && (item.getId().equals(id))) {
                found = true;
                resItem = item;
                break;
            }
        }
        if (!found) {
            resItem = null;
        }
        return resItem;
    }
}
