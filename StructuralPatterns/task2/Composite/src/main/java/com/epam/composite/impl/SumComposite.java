package com.epam.composite.impl;

import com.epam.composite.ExpressionComposite;

/**
 * Created by Полина on 14.08.2016.
 */
public class SumComposite extends AbstractComposite {

    public SumComposite(ExpressionComposite... expressionComposites) {
        super(expressionComposites);
    }

    public Double makeResult() {
        Double result = new Double(0);
        for(ExpressionComposite expressionComposite :expressionCompositeList) {
            result = result + expressionComposite.makeResult();
        }
        return result;
    }
}
