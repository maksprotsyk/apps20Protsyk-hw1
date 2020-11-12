package ua.edu.ucu.extremvals;

import ua.edu.ucu.appliers.FunctionApplier;

// allows to implements classes that find value (in array)
// of argument for which key function reaches the maximum value
// (to the given index)
public abstract class ExtremFinder implements FunctionApplier {
    private static final double DELTA = 0.00001;
    protected double findExtVal(double[] items, int length)
            throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        double max = items[0];
        double maxVal = keyFunction(max);
        double newVal;
        for (int i = 1; i < length; i++) {
            newVal = keyFunction(items[i]);
            if (maxVal < newVal) {
                max = items[i];
                maxVal = newVal;
            }
            else if ((Math.abs(maxVal - newVal) < DELTA) && (items[i] > max)) {
                max = items[i];
            }
        }
        return max;
    }
}
