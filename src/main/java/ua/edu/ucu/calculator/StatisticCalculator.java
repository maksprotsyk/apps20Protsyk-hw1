package ua.edu.ucu.calculator;

import ua.edu.ucu.average.Deviation;
import ua.edu.ucu.average.RegularAverage;
import ua.edu.ucu.extrem_values.MaxFinder;
import ua.edu.ucu.extrem_values.MinFinder;
import ua.edu.ucu.filters.GreaterThanFinder;
import ua.edu.ucu.filters.LessThanFinder;
import ua.edu.ucu.extrem_values.ClosestFinder;

// statistic calculator which allows to get different
// important values for the given doubles array
public class StatisticCalculator {
    RegularAverage averageCounter;
    Deviation deviationCounter;
    MaxFinder maxFinder;
    MinFinder minFinder;
    ClosestFinder closestFinder;
    LessThanFinder lessFinder;
    GreaterThanFinder greaterFinder;
    public StatisticCalculator(){
        averageCounter = new RegularAverage();
        deviationCounter = new Deviation();
        maxFinder = new MaxFinder();
        minFinder = new MinFinder();
        closestFinder = new ClosestFinder();
        greaterFinder = new GreaterThanFinder();
        lessFinder = new LessThanFinder();
    }

    public double min(double[] items, int length) throws IllegalArgumentException{
        return minFinder.findMin(items, length);
    }

    public double max(double[] items, int length) throws IllegalArgumentException{
        return  maxFinder.findMax(items, length);
    }

    public double findClosest(double[] items, int length, double value) throws IllegalArgumentException{
        return closestFinder.findClosest(items, length, value);

    }

    public double average(double[] items, int length) throws IllegalArgumentException{
        return averageCounter.average(items, length);
    }

    public double deviation(double[] items, int length) throws IllegalArgumentException{
        return deviationCounter.deviation(items, length, average(items, length));

    }

    public double[] findLess(double[] items, int length, double value){
        return lessFinder.findLess(items, length, value);
    }

    public double[] findGreater(double[] items, int length, double value){
        return greaterFinder.findGreater(items, length, value);
    }
}
