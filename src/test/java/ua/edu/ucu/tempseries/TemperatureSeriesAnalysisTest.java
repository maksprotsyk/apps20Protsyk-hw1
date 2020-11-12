package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis series;
    private static final double DELTA = 0.00001;

    @Before
    public void createEmpty(){
        series = new TemperatureSeriesAnalysis();
    }

    @Test
    public void testAverageOne() {
        double[] oneElement = {100.0};
        double correct = 100.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.average(), DELTA);
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
        assertEquals(correct, series.average(), DELTA);
    }

    @Test
    public void testDeviationOne() {
        double[] oneElement = {3.0};
        double correct = 0.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.deviation(), DELTA);
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
        assertEquals(correct, series.deviation(), DELTA);
    }

    @Test
    public void testMinOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.min(), DELTA);
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
        assertEquals(correct, series.min(), DELTA);
    }

    @Test
    public void testMaxOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.max(), DELTA);
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
        assertEquals(correct, series.max(), DELTA);
    }

    @Test
    public void testClosestToZeroOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.findTempClosestToZero(), DELTA);
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
        assertEquals(correct, series.findTempClosestToZero(), DELTA);
    }

    @Test
    public void testClosestToValueOne() {
        double[] oneElement = {3.0};
        double correct = 3.0;
        series.addTemps(oneElement);
        assertEquals(correct, series.findTempClosestToValue(6.0), DELTA);
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
        assertEquals(correct, series.findTempClosestToValue(4.0), DELTA);
    }

    @Test
    public void testFindLessOne() {
        double[] oneElement = {3.0};
        double[] correct = {3.0};
        series.addTemps(oneElement);
        assertArrayEquals(correct, series.findTempsLessThen(4.0), DELTA);
    }


    @Test
    public void testFindLessEmpty() {
        double[] correct = {};
        assertArrayEquals(correct, series.findTempsLessThen(4.0), DELTA);
    }

    @Test
    public void testFindLessMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] correct = {-2.0, -3.0};
        series.addTemps(manyElements);
        assertArrayEquals(correct, series.findTempsLessThen(4.0), DELTA);
    }

    @Test
    public void testFindGreaterOne() {
        double[] oneElement = {3.0};
        double[] correct = {};
        series.addTemps(oneElement);
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), DELTA);
    }

    @Test
    public void testFindGreaterEmpty() {
        double[] correct = {};
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), DELTA);
    }

    @Test
    public void testFindGreaterMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] correct = {7.0, 5.0};
        series.addTemps(manyElements);
        assertArrayEquals(correct, series.findTempsGreaterThen(4.0), DELTA);
    }

    @Test
    public void testStatisticsOne() {
        double[] oneElement = {3.0};
        series.addTemps(oneElement);
        TempSummaryStatistics result = series.summaryStatistics();
        assertEquals(oneElement[0], result.getAvg(), DELTA);
        assertEquals(0.0, result.getDev(), DELTA);
        assertEquals(oneElement[0], result.getMin(), DELTA);
        assertEquals(oneElement[0], result.getMax(), DELTA);
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
        assertEquals(1.75, result.getAvg(), DELTA);
        assertEquals(18.6875, result.getDev(), DELTA);
        assertEquals(-3.0, result.getMin(), DELTA);
        assertEquals(7.0, result.getMax(), DELTA);
    }

    @Test
    public void testAddMany() {
        double[] manyElements = {-2.0, -3.0, 7.0, 5.0};
        double[] newElements = {1.0, 2.0, -3.0, 4.0, 16.0};
        series.addTemps(manyElements);
        series.addTemps(newElements);
        assertEquals(9, series.getLength());
        assertEquals(3.0, series.average(), DELTA);

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
        TemperatureSeriesAnalysis series = new TemperatureSeriesAnalysis(manyElements);
        assertEquals(4, series.getLength());
        assertEquals(1.75, series.average(), DELTA);
    }
}
