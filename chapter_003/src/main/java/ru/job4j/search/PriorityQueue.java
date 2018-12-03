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
        int index = 0;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() > task.getPriority()) {
                index = i;
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
