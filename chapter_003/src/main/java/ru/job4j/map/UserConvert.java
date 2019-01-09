package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 5.12.2018
 */
public class UserConvert {
    /**
     * Преобразование списка пользователей в карту.
     *
     * @param list Список пользователей.
     * @return Карта.
     */
    public HashMap<Integer, User> process(List<User> list) {
        Map<Integer, User> map = list.stream().collect(
                Collectors.toMap(user -> user.getId(), user -> user)
        );
        return new HashMap<>(map);
    }
}
