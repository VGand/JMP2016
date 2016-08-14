package com.epam.adaptiterator;

import com.epam.adaptiterator.adapter.AdaptIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Полина on 14.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<Message> messageList = new ArrayList<Message>();
        messageList.add(new Message(1, "message1"));
        messageList.add(new Message(2, "message2"));
        messageList.add(new Message(3, "message3"));
        messageList.add(new Message(4, "message4"));
        messageList.add(new Message(5, "message5"));
        messageList.add(new Message(6, "message6"));

        MessageService messageService = new MessageServiceImpl(messageList);
        Iterator<Message> messageIterator = new AdaptIterator(messageService);

        while (messageIterator.hasNext()) {
            System.out.println(messageIterator.next().toString());
        }
    }
}
