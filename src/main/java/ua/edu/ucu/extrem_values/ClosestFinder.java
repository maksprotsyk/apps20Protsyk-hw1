package ua.edu.ucu.extrem_values;

// allows to find the closest value to the given one
// in the array of doubles (to the given index)
public class ClosestFinder extends ExtremFinder {
    double num;

    public double findClosest(double[] items, int length, double num) throws IllegalArgumentException{
        this.num = num;
        return findExtVal(items, length);
    }

    public double keyFunction(double value) {
        return -Math.abs(value - num);
    }
}
