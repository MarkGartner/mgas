package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int n = array.length;

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (array[j] == array[i]) {
                    // если нашелся дубликат использовать считалку как сигнал
                    count++;
                    if (count > 1) {
                        // меняю местами дубликат и последнее значение в массиве
                        int lastUsableIndex = n - 1;
                        String temp = array[lastUsableIndex];
                        array[lastUsableIndex] = array[i];
                        array[i] = temp;
                        // сокращаю область просмотра массива так как конец заполняемый дубликатами уже не интересен
                        n--;
                    }
                }
            }
        }

        return Arrays.copyOf(array, n);
    }

}


