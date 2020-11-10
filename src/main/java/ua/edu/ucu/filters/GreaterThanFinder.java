package ua.edu.ucu.filters;

import ua.edu.ucu.appliers.ConditionApplier;

// finds items in the doubles array (to the given index)
// which are greater than the given value
public class GreaterThanFinder extends ConditionApplier {
    double compValue;
    public Boolean keyFunction(double value) {
        return compValue < value;
    }
    public double[] findGreater(double[] items, int length, double compValue){
        this.compValue = compValue;
        return apply(items, length);
    }
}
