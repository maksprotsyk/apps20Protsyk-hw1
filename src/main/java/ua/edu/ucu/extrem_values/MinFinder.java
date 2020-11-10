package ua.edu.ucu.extrem_values;

// allows to find minimum of the doubles array (to the given index)
public class MinFinder extends ExtremFinder {
    public double keyFunction(double value){
        return -value;
    }
    public double findMin(double[] items, int length) throws IllegalArgumentException{
        return findExtVal(items, length);
    }
}
