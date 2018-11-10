package ru.job4j.strategy;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.11.2018
 */
public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        builder.append("++++")
                .append(ln)
                .append("++++")
                .append(ln)
                .append("++++")
                .append(ln)
                .append("++++");
        return builder.toString();
    }

}
