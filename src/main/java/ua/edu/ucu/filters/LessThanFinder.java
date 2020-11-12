package ua.edu.ucu.filters;

import ua.edu.ucu.appliers.ConditionApplier;

// finds items in the doubles array (to the given index)
// which are less than the given value
public class LessThanFinder extends ConditionApplier {
    private double compValue;
    public boolean keyFunction(double value) {
        return compValue > value;
    }
    public double[] findLess(double[] items,
                             int length,
                             double newCompValue) {
        compValue = newCompValue;
        return apply(items, length);
    }
}
