package com.epam.adaptiterator.adapter;

import com.epam.adaptiterator.Message;
import com.epam.adaptiterator.MessageService;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Полина on 14.08.2016.
 */
public class AdaptIterator implements Iterator<Message> {

    private MessageService messageService;
    private int pageNumber = 0;
    private List<Message> currentPage = null;

    public AdaptIterator(MessageService messageService) {
        this.messageService = messageService;
    }

    public boolean hasNext() {
        currentPage = messageService.list(pageNumber++, 1);
        return currentPage.size() > 0;
    }

    public Message next() {
        return currentPage.get(0);
    }
}
