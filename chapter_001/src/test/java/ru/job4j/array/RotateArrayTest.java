package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        int[][] readyRotated = {{3, 1}, {4, 2}};

        int[][] sampleInitial = {{1, 2}, {3, 4}};

        RotateArray instance = new RotateArray();

        int[][] sampleRotated = instance.rotate(sampleInitial);

        Assert.assertArrayEquals(readyRotated, sampleRotated);

    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.

        int[][] readyRotated = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

        int[][] sampleInitial = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        RotateArray instance = new RotateArray();

        int[][] sampleRotated = instance.rotate(sampleInitial);

        Assert.assertArrayEquals(readyRotated, sampleRotated);

    }
}