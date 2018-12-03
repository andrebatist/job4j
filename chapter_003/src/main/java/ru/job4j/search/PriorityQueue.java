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
        if (this.tasks.size() == 0) {
            this.tasks.addFirst(task);
            return;
        }
        for (int i = 0; i < this.tasks.size(); i++) {
            if ((i == this.tasks.size() - 1) && (this.tasks.get(i).getPriority() < task.getPriority())) {
                this.tasks.addLast(task);
                break;
            } else if (i == this.tasks.size() - 1) {
                this.tasks.add(i, task);
                break;
            }
            if ((this.tasks.get(i).getPriority() < task.getPriority())
                    && (this.tasks.get(i + 1).getPriority() > task.getPriority())) {
                this.tasks.add(i + 1, task);
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
