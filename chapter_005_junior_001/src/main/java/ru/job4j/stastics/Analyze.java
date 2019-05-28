package ru.job4j.stastics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 28.05.2019
 */
public class Analyze {
    /**
     * Метод возвращает разницу между начальным состоянием массива и измененным.
     *
     * @param previous Предыдущая коллекция.
     * @param current  Новая коллекция.
     * @return Инфо о сравнении.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> currUsersMap = new HashMap<>();
        current.forEach(curr -> currUsersMap.put(curr.id, curr));
        previous.forEach(prev -> {
            User found = currUsersMap.get(prev.id);
            if (found == null) {
                info.deleted++;
            } else {
                if (!found.name.equals(prev.name)) {
                    info.changed++;
                }
            }
        });
        info.added = current.size() - (previous.size() - info.deleted);
        return info;

    }

    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info() {

        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
