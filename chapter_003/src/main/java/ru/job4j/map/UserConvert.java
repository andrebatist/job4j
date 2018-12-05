package ru.job4j.map;

import java.util.HashMap;
import java.util.List;

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
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
