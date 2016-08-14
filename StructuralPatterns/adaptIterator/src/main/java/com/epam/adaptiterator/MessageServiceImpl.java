package com.epam.adaptiterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Полина on 14.08.2016.
 */
public class MessageServiceImpl implements MessageService{

    private List<Message> messageList;

    public MessageServiceImpl(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Message> list(int startID, int size) {
        if (messageList != null) {
            int start = startID * size;
            int end = start + size;

            if (start > messageList.size()) {
                //Страница за границами размеров списка
                return  new ArrayList<Message>();
            }

            if (end > messageList.size()) {
                //Размер страницы больше размера оставшейся области списка
                end = messageList.size();
            }

            return messageList.subList(start, end);

        } else {
            //Список не определенн
            return new ArrayList<Message>();
        }
    }
}
