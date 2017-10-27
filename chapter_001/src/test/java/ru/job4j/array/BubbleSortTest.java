package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.

        int[] unsortedArray = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] sortedArray = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};

        BubbleSort sample = new BubbleSort();
        int[] returnedArray = sample.sort(unsortedArray);

        Assert.assertArrayEquals(sortedArray, returnedArray);
    }


}