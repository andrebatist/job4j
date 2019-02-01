package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 30.01.2019
 */
public class StoreTest {
    @Test
    public void whenStoresThenResult() {
        User user = new User("1");
        User user2 = new User("2");
        UserStore userStore = new UserStore(new SimpleArray<>(4));
        userStore.add(user);
        userStore.add(user2);
        User searchUser = userStore.findById("2");
        assertThat(userStore.getValues().get(1), is(searchUser));
        userStore.delete("1");
        assertThat(userStore.getValues().get(0), is(user2));
        User replaceUser = new User("3");
        userStore.replace("2", replaceUser);
        assertThat(userStore.getValues().get(0), is(replaceUser));
        Role role = new Role("1");
        Role role2 = new Role("2");
        RoleStore roleStore = new RoleStore(new SimpleArray<>(4));
        roleStore.add(role);
        roleStore.add(role2);
        Role searchRole = roleStore.findById("2");
        assertThat(roleStore.getValues().get(1), is(searchRole));
        roleStore.delete("1");
        assertThat(roleStore.getValues().get(0), is(role2));
        Role replaceRole = new Role("3");
        roleStore.replace("2", replaceRole);
        assertThat(roleStore.getValues().get(0), is(replaceRole));
    }
}
