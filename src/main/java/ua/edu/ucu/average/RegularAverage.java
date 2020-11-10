package ua.edu.ucu.average;


// allows to calculate the average of given array (to the given index)
public class RegularAverage extends AverageCounter {
    public double keyFunction(double value) {
        return value;
    }

    public double average(double[] items, int length){
        return calcAverage(items, length);
    }
}
