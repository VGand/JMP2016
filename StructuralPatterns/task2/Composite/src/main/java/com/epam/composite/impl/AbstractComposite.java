package com.epam.composite.impl;

import com.epam.composite.ExpressionComposite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Полина on 14.08.2016.
 */
public abstract class AbstractComposite implements ExpressionComposite{
    List<ExpressionComposite> expressionCompositeList;

    public AbstractComposite(ExpressionComposite ... expressionComposites) {
        this.expressionCompositeList = new ArrayList<ExpressionComposite>();
        for(ExpressionComposite expressionComposite: expressionComposites) {
            expressionCompositeList.add(expressionComposite);
        }
    }

    public void add(ExpressionComposite composite) {
        expressionCompositeList.add(composite);
    }
}
