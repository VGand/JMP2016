package com.epam.threadQueue;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Полина on 21.08.2016.
 */
public class SynchronizedQueue {

    private LinkedList<String> linkedList = new LinkedList<String>();

    public void addMessage(String message) {
        linkedList.add(message);
    }

    public String getMessage() {
        return linkedList.poll();
    }

    public Boolean isEmpty() {
        return linkedList.isEmpty();
    }

}
