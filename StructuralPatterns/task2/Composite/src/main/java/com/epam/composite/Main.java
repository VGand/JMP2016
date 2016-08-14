package com.epam.composite;

import com.epam.composite.impl.MultiComposite;
import com.epam.composite.impl.SumComposite;
import com.epam.composite.impl.ValueComposite;

/**
 * Created by Полина on 14.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        ExpressionComposite multiComposite1 = new MultiComposite(new ValueComposite(2D), new ValueComposite(3D));
        ExpressionComposite multiComposite2 = new MultiComposite(new ValueComposite(4D), new ValueComposite(1D));
        ExpressionComposite sumComposite = new SumComposite();
        sumComposite.add(multiComposite1);
        sumComposite.add(multiComposite2);

        System.out.println(sumComposite.makeResult());
    }
}
