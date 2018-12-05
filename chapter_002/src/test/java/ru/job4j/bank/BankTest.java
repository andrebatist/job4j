package ru.job4j.bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.11.2018
 */
public class BankTest {
    /**
     * Тест с одним визитом.
     */
    @Test
    public void whenOneVisit() {
        List<Bank.Visit> visits = Arrays.asList(
                new Bank.Visit(time(8, 10), time(8, 20))
        );
        assertThat(
                new Bank().max(visits),
                is(
                        Arrays.asList(
                                new Bank.Info(
                                        1, time(8, 10), time(8, 20)
                                )
                        )
                )
        );
    }

    /**
     * Тест с пересечением двух визитов.
     */
    @Test
    public void whenCrossTwoVisit() {
        List<Bank.Visit> visits = Arrays.asList(
                new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15))
        );
        assertThat(
                new Bank().max(visits),
                is(
                        Arrays.asList(
                                new Bank.Info(
                                        2, time(8, 30), time(8, 50)
                                )
                        )
                )
        );
    }

    /**
     * Тест с 6 визитами.
     */
    @Test
    public void whenSixVisitsThenMax3() {
        List<Bank.Visit> visits = Arrays.asList(
                new Bank.Visit(time(8, 5), time(8, 15)),
                new Bank.Visit(time(9, 0), time(9, 30)),
                new Bank.Visit(time(9, 15), time(10, 1)),
                new Bank.Visit(time(11, 10), time(11, 30)),
                new Bank.Visit(time(11, 15), time(11, 50)),
                new Bank.Visit(time(11, 20), time(11, 40))
        );
        new Bank().max(visits);
        assertThat(
                new Bank().max(visits),
                is(
                        Arrays.asList(
                                new Bank.Info(
                                        3, time(11, 20), time(11, 30)
                                )
                        )
                )
        );
    }

    /**
     * Тест с двумя пиками посещений.
     */
    @Test
    public void whenSixVisitsThenTwoMaximum() {
        List<Bank.Visit> visits = Arrays.asList(
                new Bank.Visit(time(8, 5), time(8, 15)),
                new Bank.Visit(time(9, 0), time(9, 30)),
                new Bank.Visit(time(9, 15), time(10, 1)),
                new Bank.Visit(time(11, 10), time(11, 30)),
                new Bank.Visit(time(11, 15), time(11, 50)),
                new Bank.Visit(time(11, 20), time(11, 40)),
                new Bank.Visit(time(13, 0), time(13, 30)),
                new Bank.Visit(time(13, 2), time(13, 20)),
                new Bank.Visit(time(14, 0), time(14, 40)),
                new Bank.Visit(time(14, 1), time(14, 20)),
                new Bank.Visit(time(14, 10), time(15, 0))
        );
        new Bank().max(visits);
        assertThat(
                new Bank().max(visits),
                is(
                        Arrays.asList(
                                new Bank.Info(
                                        3, time(11, 20), time(11, 30)
                                ),
                                new Bank.Info(
                                        3, time(14, 10), time(14, 20)
                                )
                        )
                )
        );
    }

    /**
     * Преобразование часов и минут в миллисекунды.
     *
     * @param hour   Часы.
     * @param minute Минуты.
     * @return Время в миллисекундах.
     */
    private long time(int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}