package com.epam.composite.impl;

import com.epam.composite.ExpressionComposite;

/**
 * Created by Полина on 14.08.2016.
 */
public class ValueComposite implements ExpressionComposite{

    private Double value;

    public ValueComposite(Double value) {
        this.value = value;
    }

    public void add(ExpressionComposite composite) {
    }

    public Double makeResult() {
        return value;
    }
}
