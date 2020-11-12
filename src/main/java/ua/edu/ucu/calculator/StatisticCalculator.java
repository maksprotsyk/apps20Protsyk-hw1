package ua.edu.ucu.calculator;

import ua.edu.ucu.average.DeviationCounter;
import ua.edu.ucu.average.RegularAverage;
import ua.edu.ucu.extremvals.MaxFinder;
import ua.edu.ucu.extremvals.MinFinder;
import ua.edu.ucu.filters.GreaterThanFinder;
import ua.edu.ucu.filters.LessThanFinder;
import ua.edu.ucu.extremvals.ClosestFinder;

// statistic calculator which allows to get different
// important values for the given doubles array
public class StatisticCalculator {
    private RegularAverage averageCounter;
    private DeviationCounter deviationCounter;
    private MaxFinder maxFinder;
    private MinFinder minFinder;
    private ClosestFinder closestFinder;
    private LessThanFinder lessFinder;
    private GreaterThanFinder greaterFinder;
    public StatisticCalculator() {
        averageCounter = new RegularAverage();
        deviationCounter = new DeviationCounter();
        maxFinder = new MaxFinder();
        minFinder = new MinFinder();
        closestFinder = new ClosestFinder();
        greaterFinder = new GreaterThanFinder();
        lessFinder = new LessThanFinder();
    }

    public double min(double[] items, int length)
            throws IllegalArgumentException {
        return minFinder.findMin(items, length);
    }

    public double max(double[] items, int length)
            throws IllegalArgumentException {
        return  maxFinder.findMax(items, length);
    }

    public double findClosest(double[] items, int length, double value)
            throws IllegalArgumentException {
        return closestFinder.findClosest(items, length, value);

    }

    public double average(double[] items, int length)
            throws IllegalArgumentException {
        return averageCounter.average(items, length);
    }

    public double deviation(double[] items, int length)
            throws IllegalArgumentException {
        return deviationCounter.deviation(
                items,
                length,
                average(items, length)
        );

    }

    public double[] findLess(double[] items, int length, double value) {
        return lessFinder.findLess(items, length, value);
    }

    public double[] findGreater(double[] items, int length, double value) {
        return greaterFinder.findGreater(items, length, value);
    }
}
