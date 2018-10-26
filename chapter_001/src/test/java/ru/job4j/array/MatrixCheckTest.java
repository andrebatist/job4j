package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 25.10.2018
 */
public class MatrixCheckTest {
    /**
     * Test размер 2 true.
     */
    @Test
    public void whenDataMonoByTrueThenTrueSizeTwo() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test размер 3 true.
     */
    @Test
    public void whenDataMonoByTrueThenTrueSizeThree() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test размер 3 false.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalseSizeThree() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test размер 4 true.
     */
    @Test
    public void whenDataMonoByTrueThenTrueSizeFour() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true},
                {false, true, true, true},
                {true, true, true, true},
                {true, false, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test размер 4 false.
     */
    @Test
    public void whenDataMonoByTrueThenFalseSizeFour() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true},
                {false, true, true, true},
                {true, true, true, true},
                {false, false, true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}