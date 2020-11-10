package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public double avgTemp;
    public double devTemp;
    public double minTemp;
    public double maxTemp;
    public TempSummaryStatistics(TemperatureSeriesAnalysis series) throws IllegalArgumentException{
        avgTemp = series.average();
        devTemp = series.deviation();
        minTemp = series.min();
        maxTemp = series.max();
    }


}
