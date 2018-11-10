package ru.job4j.tracker;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.11.2018
 */
public class StubInput implements Input {
    /**
     * Массив строк ввода.
     */
    private final String[] value;
    /**
     * Указатель ячейки для строки ввода.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

}
