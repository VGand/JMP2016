package com.epam.adaptiterator;

import java.util.List;

/**
 * Created by Полина on 14.08.2016.
 */
public interface MessageService {

    List<Message> list(int startID, int size);
}
