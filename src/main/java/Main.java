import ua.edu.ucu.tempseries.TempSummaryStatistics;
import ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        TemperatureSeriesAnalysis x = new TemperatureSeriesAnalysis(new double[]{2, 3, 4, 5});
        x.addTemps(4, 1, -1);
        System.out.println(x.tempSeries[6]);
        TempSummaryStatistics y = x.summaryStatistics();
        System.out.println(Arrays.toString(x.findTempsLessThen(7)));
    }
}
