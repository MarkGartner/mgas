package ru.job4j.array;

public class RotateArray {
    public int[][] rotate(int[][] array) {
        int x = array.length;
        int[][] rotatedArray = new int[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                rotatedArray[j][x - 1 - i] = array[i][j];
            }
        }
        return rotatedArray;
    }
}
