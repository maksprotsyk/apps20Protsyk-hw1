package ua.edu.ucu.filters;

import ua.edu.ucu.appliers.ConditionApplier;

// finds items in the doubles array (to the given index)
// which are greater than the given value
public class GreaterThanFinder extends ConditionApplier {
    private double compValue;
    public boolean keyFunction(double value) {
        return compValue <= value;
    }
    public double[] findGreater(double[] items,
                                int length,
                                double newCompValue) {
        compValue = newCompValue;
        return apply(items, length);
    }
}
