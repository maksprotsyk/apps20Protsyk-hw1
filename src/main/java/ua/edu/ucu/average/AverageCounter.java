package ua.edu.ucu.average;

import ua.edu.ucu.appliers.FunctionApplier;

// allows to calculate the average value of key fucntion
// for the given array of doubles (to the given index)
public abstract class AverageCounter implements FunctionApplier {
    protected double calcAverage(double[] values, int length){
        if (length <= 0){
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < length; i++){
            sum += keyFunction(values[i]);
        }
        return sum/length;
    }
}
