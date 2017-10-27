package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] paramArray) {
        int n = paramArray.length;

        for (int i = 0; i < n; i++) {
            for (int counter = 0; counter < n - 1; counter++) {
                if (paramArray[counter] > paramArray[counter + 1]) {
                    int temp = paramArray[counter];
                    paramArray[counter] = paramArray[counter + 1];
                    paramArray[counter + 1] = temp;
                }
            }
        }
        return paramArray;
    }
}
