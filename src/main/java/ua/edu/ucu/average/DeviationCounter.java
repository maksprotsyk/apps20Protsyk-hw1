package ua.edu.ucu.average;


// allows to calculate the deviation
// for the given array of doubles (to the given index)
// you should provide the value for which (item - value)^2 will be calculating
public class DeviationCounter extends AverageCounter {
    private double average;

    public double deviation(double[] items, int length, double itemsAverage) {
        average = itemsAverage;
        return Math.sqrt(calcAverage(items, length));
    }
    public double keyFunction(double value) {
        return (value - average) * (value - average);
    }
}
