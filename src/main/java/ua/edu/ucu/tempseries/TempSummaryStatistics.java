package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;
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
