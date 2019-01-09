package ru.job4j.search;

import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 2.12.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        OptionalInt indexOpt = IntStream.range(0, this.tasks.size())
                .filter(i -> this.tasks.get(i).getPriority() > task.getPriority())
                .findFirst();
        int index = indexOpt.isPresent() ? indexOpt.getAsInt() : this.tasks.size();
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
