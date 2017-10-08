package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.

        String[] myArray = {"red", "blue", "blue", "green", "red", "red", "purple", "orange", "yellow", "red"};
        ArrayDuplicate sample = new ArrayDuplicate();
        String [] resultArray = sample.remove(myArray);

        String[] expectArray = {"red", "blue", "orange", "green", "purple", "yellow"};

        assertThat(resultArray, is(expectArray));
    }
}