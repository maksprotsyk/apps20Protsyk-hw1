package ua.edu.ucu.average;


// allows to calculate the deviation
// for the given array of doubles (to the given index)
// you should provide the value for which (item - value)^2 will be calculating
public class Deviation extends AverageCounter {
    double average;

    public double deviation(double[] items, int length, double average){
        this.average = average;
        return calcAverage(items, length);
    }
    public double keyFunction(double value){
        return Math.pow(value - average, 2);
    }
}
