package ru.job4j.bank;

import java.util.*;

/**
 * Пик посетителей в банке.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.11.2018
 */
public class Bank {
    public static class Visit {
        /**
         * Время прихода.
         */
        private final long in;
        /**
         * Время ухода.
         */
        private final long out;

        public Visit(final long in, final long out) {
            this.in = in;
            this.out = out;
        }

        public long getIn() {
            return this.in;
        }

        public long getOut() {
            return this.out;
        }
    }

    /**
     * Информация о пике визитов.
     */
    public static class Info {
        /**
         * Максимальное количество посетителей.
         */
        private long max;
        /**
         * Время начала промежутка.
         */
        private long start;
        /**
         * Время окончания промежутка.
         */
        private long end;

        public Info() {
            this(0, 0, 0);
        }

        public Info(long max, long start, long end) {
            this.max = max;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Info info = (Info) o;

            if (max != info.max) {
                return false;
            }
            if (start != info.start) {
                return false;
            }
            return end == info.end;
        }

        @Override
        public int hashCode() {
            int result = (int) (max ^ (max >>> 32));
            result = 31 * result + (int) (start ^ (start >>> 32));
            result = 31 * result + (int) (end ^ (end >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "max=" + max
                    + ", start=" + this.toTime(this.start)
                    + ", end=" + this.toTime(this.end)
                    + '}';
        }

        /**
         * Преобразование времени в читабельный вид.
         *
         * @param time Время в миллисекундах.
         * @return Строка в читабельном виде.
         */
        public String toTime(long time) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time);
            return String.format("%s:%s", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
        }
    }

    /**
     * Возращает список информации о пике посетителей.
     *
     * @param visits Список посещений.
     * @return Список с информацией о пике посетителей.
     */
    public List<Info> max(List<Visit> visits) {
        int maxSize = 0;
        List<List<Visit>> visitsList = new ArrayList<>();
        maxSize = getMaxSizeAndSetVisitsList(visits, maxSize, visitsList);
        removeExcessVisits(maxSize, visitsList);
        return getInfos(maxSize, visitsList);
    }

    /**
     * Возвращает максимальное количество посещений и формирует список связанных по времени визитов.
     *
     * @param visits     Список визитов.
     * @param maxSize    Максимальное количество посещений.
     * @param visitsList Список связанных по времени визитов.
     * @return Максимальное количество посещений.
     */
    private int getMaxSizeAndSetVisitsList(List<Visit> visits, int maxSize, List<List<Visit>> visitsList) {
        int count = 0;
        for (int i = 0; i < visits.size(); i++) {
            List<Visit> temp = new ArrayList<>();
            temp.add(visits.get(i));
            count++;
            for (int j = i; j < visits.size() - 1; j++) {
                long diff = visits.get(j + 1).out - visits.get(j + 1).in;
                if ((visits.get(i).in + diff < visits.get(j + 1).out)
                        && (visits.get(i).out > visits.get(j + 1).in)) {
                    temp.add(visits.get(j + 1));
                    count++;
                }
            }
            if (count > maxSize) {
                maxSize = count;
            }
            visitsList.add(temp);
            count = 0;
        }
        return maxSize;
    }

    /**
     * Удаление лишних визитов.
     *
     * @param maxSize    Максимальное количество посещений.
     * @param visitsList Список посещений.
     */
    private void removeExcessVisits(int maxSize, List<List<Visit>> visitsList) {
        Iterator<List<Visit>> iter = visitsList.iterator();
        while (iter.hasNext()) {
            List<Visit> tmp = iter.next();
            if (tmp.size() != maxSize) {
                iter.remove();
            }
        }
    }

    /**
     * Возвращает информацию о пике посетителей.
     *
     * @param maxSize    Максимальное количество посещений.
     * @param visitsList Список посещений.
     * @return Информация о пике посетителей.
     */
    private List<Info> getInfos(int maxSize, List<List<Visit>> visitsList) {
        List<Info> periods = new ArrayList<>();
        for (List<Visit> tmp : visitsList) {
            LongSummaryStatistics summaryStatisticsMax = tmp.stream()
                    .mapToLong(Visit::getIn)
                    .summaryStatistics();
            LongSummaryStatistics summaryStatisticsMin = tmp.stream()
                    .mapToLong(Visit::getOut)
                    .summaryStatistics();
            Info info = new Info(maxSize, summaryStatisticsMax.getMax(), summaryStatisticsMin.getMin());
            periods.add(info);
        }
        return periods;
    }
}
