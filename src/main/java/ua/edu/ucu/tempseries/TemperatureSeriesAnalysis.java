package ua.edu.ucu.tempseries;

import ua.edu.ucu.calculator.StatisticCalculator;

import java.util.InputMismatchException;

import java.lang.Math;

public class TemperatureSeriesAnalysis {
    private static final int DefaultBuff = 5;
    public static final double MinimalTemp = -273.0;
    private double[] tempSeries;
    private int length;
    private int buffer;
    private StatisticCalculator calculator;


    public TemperatureSeriesAnalysis() {
        reInit();
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        reInit();
        addTemps(temperatureSeries);

    }

    private void reInit() {
        length = 0;
        tempSeries = new double[DefaultBuff];
        buffer = DefaultBuff;
        calculator = new StatisticCalculator();

    }

    private void changeBuffer(int newBuffer) {
        double[] newSeries = new double[newBuffer];
        int newLength = Math.min(buffer, newBuffer);
        System.arraycopy(
                tempSeries,
                0,
                newSeries,
                0,
                newLength
        );
        tempSeries = newSeries;
        length = newLength;
        buffer = newBuffer;
    }

    private void addTemp(double temp) {
        if (length == buffer){
            changeBuffer(2 * buffer);
        }
        tempSeries[length] = temp;
        length += 1;
    }

    public double average() throws IllegalArgumentException {
        if (length == 0){
            throw new IllegalArgumentException();
        }
        return calculator.average(tempSeries, length);
    }

    public double deviation() throws IllegalArgumentException {
        return calculator.deviation(tempSeries, length);
    }

    public double min() throws IllegalArgumentException {
        return calculator.min(tempSeries, length);
    }

    public double max() throws IllegalArgumentException {
        return calculator.max(tempSeries, length);
    }

    public double findTempClosestToZero() throws IllegalArgumentException {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue)
            throws IllegalArgumentException {
        return calculator.findClosest(tempSeries, length, tempValue);
    }

    public double[] findTempsLessThen(double tempValue) {
        return calculator.findLess(tempSeries, length, tempValue);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return calculator.findGreater(tempSeries, length, tempValue);
    }

    public TempSummaryStatistics summaryStatistics()
            throws IllegalArgumentException {
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        for (double temperature: temps){
            if (temperature < MinimalTemp) {
                throw new InputMismatchException();
            }
        }
        for (double temperature: temps) {
            addTemp(temperature);
        }
        return 0;
    }
}
