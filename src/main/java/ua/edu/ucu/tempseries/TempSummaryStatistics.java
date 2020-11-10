package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    final private double avgTemp;
    final private double devTemp;
    final private double minTemp;
    final private double maxTemp;
    public TempSummaryStatistics(TemperatureSeriesAnalysis series) throws IllegalArgumentException{
        avgTemp = series.average();
        devTemp = series.deviation();
        minTemp = series.min();
        maxTemp = series.max();
    }

    public double getAvg(){
        return avgTemp;
    }

    public double getDev(){
        return devTemp;
    }

    public double getMin(){
        return minTemp;
    }

    public double getMax(){
        return maxTemp;
    }



}
