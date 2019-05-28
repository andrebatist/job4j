package ru.job4j.stastics;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.stastics.Analyze.Info;
import static ru.job4j.stastics.Analyze.User;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 28.05.2019
 */
public class AnalyzeTest {
    @Test
    public void whenEqualsElementsThenRes() {
        Info info = new Analyze().diff(List.of(
                new User(1, "Andre"),
                new User(2, "Victor")
        ), List.of(
                new User(2, "Victor"),
                new User(1, "Andre")
        ));
        Info expect = new Info(0, 0, 0);
        assertThat(expect, is(info));
    }

    @Test
    public void whenOneElAddedThenResAdd() {
        Info info = new Analyze().diff(List.of(
                new User(1, "Victor")
        ), List.of(
                new User(2, "Peter"),
                new User(1, "Victor")
        ));
        Info expect = new Info(1, 0, 0);
        assertThat(expect, is(info));
    }

    @Test
    public void whenOneElDeletedThenResDel() {
        Info info = new Analyze().diff(List.of(
                new User(1, "Victor"),
                new User(2, "Peter")
        ), List.of(
                new User(2, "Peter")
        ));
        Info expect = new Info(0, 0, 1);
        assertThat(expect, is(info));
    }

    @Test
    public void whenChangeElThenResChange() {
        Info info = new Analyze().diff(List.of(
                new User(1, "Andrew"),
                new User(2, "Atlas")
        ), List.of(
                new User(2, "Atlas"),
                new User(1, "Andrew Ryan")
        ));
        Info expect = new Info(0, 1, 0);
        assertThat(expect, is(info));
    }
}