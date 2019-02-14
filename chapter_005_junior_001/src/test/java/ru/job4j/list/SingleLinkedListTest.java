package ru.job4j.list;

import org.junit.Test;

public class SingleLinkedListTest {
    @Test
    public void whenXThenY() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        /*Iterator<Integer> it = list.iterator();
        it.next();
        it.hasNext();
        it.next();
        it.hasNext();
        it.next();
        it.hasNext();
        it.next();
        it.hasNext();*/
    }
}