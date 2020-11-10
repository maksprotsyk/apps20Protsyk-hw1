package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis series;
    final double delta = 0.00001;

    @Before
    public void createEmpty(){
        series = new TemperatureSeriesAnalysis();
    }

    @Test
    public void testAverageOne() {
        double[] oneElement = {100.0};
        double correct = 100.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.average(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageEmpty() {
        series.average();
    }

    @Test
    public void testAverageMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double correct = 1.75;
        series.addTemps(manyElements);
        assertEquals(correct, series.average(), delta);
    }

    @Test
    public void testDeviationOne() {
        double[] oneElement = {3.0};
        double correct = 0.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.deviation(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmpty() {
        series.deviation();
    }

    @Test
    public void testDeviationMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double correct = 18.6875;
        series.addTemps(manyElements);
        assertEquals(correct, series.deviation(), delta);
    }

    @Test
    public void testMinOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.min(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinEmpty() {
        series.min();
    }

    @Test
    public void testMinMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double correct = -3.0;
        series.addTemps(manyElements);
        assertEquals(correct, series.min(), delta);
    }

    @Test
    public void testMaxOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.max(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmpty() {
        series.max();
    }

    @Test
    public void testMaxMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double correct = 7.0;
        series.addTemps(manyElements);
        assertEquals(correct, series.max(), delta);
    }

    @Test
    public void testClosestToZeroOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.findTempClosestToZero(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroEmpty() {
        series.findTempClosestToZero();
    }

    @Test
    public void testClosestToZeroMany() {
        double[] manyElements = {-2.0, -3.0, 2.0, 5.0};
        double correct = 2.0;
        series.addTemps(manyElements);
        assertEquals(correct, series.findTempClosestToZero(), delta);
    }

    @Test
    public void testClosestToValueOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.findTempClosestToValue(6.0), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueEmpty() {
        series.findTempClosestToValue(2.0);
    }

    @Test
    public void testClosestToValueMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double correct = 5.0;
        series.addTemps(manyElements);
        assertEquals(correct, series.findTempClosestToValue(4.0), delta);
    }

    @Test
    public void testFindLessOne() {
        double[] oneElement = {3.0};
        double[] correct = {3.0};
        series.addTemps(oneElement);
        assertArrayEquals(correct, series.findTempsLessThen(4.0), delta);
    }


    @Test
    public void testFindLessEmpty() {
        double[] correct = {};
        assertArrayEquals(correct, series.findTempsLessThen(4.0), delta);
    }

    @Test
    public void testFindLessMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] correct = {-2.0, -3.0};
        series.addTemps(manyElements);
        assertArrayEquals(correct, series.findTempsLessThen(4.0), delta);
    }

    @Test
    public void testFindGreaterOne() {
        double[] oneElement = {3.0};
        double[] correct = {};
        series.addTemps(oneElement);
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), delta);
    }

    @Test
    public void testFindGreaterEmpty() {
        double[] correct = {};
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), delta);
    }

    @Test
    public void testFindGreaterMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] correct = {7.0, 5.0};
        series.addTemps(manyElements);
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), delta);
    }

    @Test
    public void testStatisticsOne() {
        double[] oneElement = {3.0};
        series.addTemps(oneElement);
        TempSummaryStatistics result = series.summaryStatistics();
        assertEquals(oneElement[0], result.avgTemp, delta);
        assertEquals(0.0, result.devTemp, delta);
        assertEquals(oneElement[0], result.minTemp, delta);
        assertEquals(oneElement[0], result.maxTemp, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStatisticsEmpty() {
        series.summaryStatistics();
    }

    @Test
    public void testStatisticsMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        series.addTemps(manyElements);
        TempSummaryStatistics result = series.summaryStatistics();
        assertEquals(1.75, result.avgTemp, delta);
        assertEquals(18.6875, result.devTemp, delta);
        assertEquals(-3.0, result.minTemp, delta);
        assertEquals(7.0, result.maxTemp, delta);
    }

    @Test
    public void testAddMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] newElements = {1.0, 2.0, -3.0, 4.0, 10.0};
        int correctBuff = 10;
        int correctLength = 9;
        double correctLast = 10.0;
        series.addTemps(manyElements);
        series.addTemps(newElements);
        assertEquals(correctBuff, series.buffer);
        assertEquals(correctLength, series.length);
        assertEquals(correctLast, series.tempSeries[correctLength - 1], delta);

    }

    @Test(expected = InputMismatchException.class)
    public void testAddManyBad() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] newElements = {1.0, 2.0, -3.0, -300.0, 10.0};
        series.addTemps(manyElements);
        series.addTemps(newElements);
    }

    @Test
    public void testInitWithSeries(){
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        int correctBuff = 5;
        int correctLength = 4;
        double correctLast = 5.0;
        TemperatureSeriesAnalysis series = new TemperatureSeriesAnalysis(manyElements);
        assertEquals(correctBuff, series.buffer);
        assertEquals(correctLength, series.length);
        assertEquals(correctLast, series.tempSeries[correctLength - 1], delta);
    }



}
