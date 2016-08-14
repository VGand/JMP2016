package com.epam.composite.impl;

import com.epam.composite.ExpressionComposite;

/**
 * Created by Полина on 14.08.2016.
 */
public class MultiComposite extends AbstractComposite {
    public MultiComposite(ExpressionComposite... expressionComposites) {
        super(expressionComposites);
    }

    public Double makeResult() {
        Double result = new Double(1);
        for(ExpressionComposite expressionComposite : expressionCompositeList) {
            result = result * expressionComposite.makeResult();
        }
        return result;
    }
}
