package ua.edu.ucu.appliers;

// allows us to implement classes that filter
// items with filter function
public abstract class ConditionApplier {
    public abstract boolean keyFunction(double value);

    protected double[] apply(double[] items, int length) {
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (keyFunction(items[i])) {
                newLength += 1;
            }
        }
        double[] newItems = new double[newLength];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (keyFunction(items[i])) {
                newItems[count] = items[i];
                count += 1;
            }
        }
        return newItems;
    }
}

