package com.epam.composite;

/**
 * Created by Полина on 14.08.2016.
 */
public interface ExpressionComposite {
    void add(ExpressionComposite composite);
    Double makeResult();
}
