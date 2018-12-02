package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 2.12.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int count = this.tasks.size();
        if (this.tasks.size() == 0) {
            this.tasks.addFirst(task);
            return;
        }
        if (task.getPriority() < this.tasks.get(count - 1).getPriority()) {
            this.tasks.add(count - 1, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
