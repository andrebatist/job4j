package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 5.11.2018
 */
public class Tracker {
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
        item.setId(id);
        OptionalInt index = IntStream.range(0, this.items.size())
                .filter(i -> id.equals(this.items.get(i).getId()))
                .findFirst();
        if (!index.isPresent()) {
            return false;
        }
        this.items.set(index.getAsInt(), item);
        return true;
    }

    /**
     * Метод удаляет заявку по id.
     *
     * @param id Id заявки.
     */
    public boolean delete(String id) {
        return this.items.removeIf(item -> item.getId().equals(id));
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
        return this.items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * Метод поиска заявки по id.
     *
     * @param id Id заявки.
     * @return Заявка.
     */
    public Item findById(String id) {
        return this.items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
