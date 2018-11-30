package ru.job4j.bank;

import java.util.*;

public class Bank {
    public static class Visit {
        private final long in;
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

    public static class Info {
        private long max;
        private long start;
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

        public String toTime(long time) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time);
            return String.format("%s:%s", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
        }
    }

    public List<Info> max(List<Visit> visits) {
        int maxSize = 0;
        int count = 0;
        List<List<Visit>> visitsList = new ArrayList<>();
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
        Iterator<List<Visit>> iter = visitsList.iterator();
        while (iter.hasNext()) {
            List<Visit> tmp = iter.next();
            if (tmp.size() != maxSize) {
                iter.remove();
            }
        }
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
