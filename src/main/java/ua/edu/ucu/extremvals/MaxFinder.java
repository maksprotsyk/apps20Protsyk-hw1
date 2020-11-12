package ua.edu.ucu.extremvals;

// allows to find maximum of the doubles array (to the given index)
public class MaxFinder extends ExtremFinder {
    public double keyFunction(double value) {
        return value;
    }

    public double findMax(double[] items, int length)
            throws IllegalArgumentException {
        return findExtVal(items, length);
    }
}
