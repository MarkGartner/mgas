package ru.job4j.array;

public class Turn {
    public int[] reverse(int[] paramArray) {
        int last = paramArray.length - 1;
        int temp;

        int midpoint = paramArray.length % 2 == 1 ? paramArray.length / 2 : paramArray.length / 2 - 1;

        for (int i = 0; i < midpoint; i++) {
            temp = paramArray[i];
            paramArray[i] = paramArray[last - i];
            paramArray[last - i] = temp;
        }
        if (paramArray.length % 2 == 0) {
            temp = paramArray[midpoint];
            paramArray[midpoint] = paramArray[midpoint + 1];
            paramArray[midpoint + 1] = temp;
        }
        return paramArray;
    }
}
