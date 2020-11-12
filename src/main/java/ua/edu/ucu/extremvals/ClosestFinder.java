package ua.edu.ucu.extremvals;

// allows to find the closest value to the given one
// in the array of doubles (to the given index)
public class ClosestFinder extends ExtremFinder {
    private double num;

    public double findClosest(double[] items, int length, double newNum)
            throws IllegalArgumentException {
        num = newNum;
        return findExtVal(items, length);
    }

    public double keyFunction(double value) {
        return -Math.abs(value - num);
    }
}
