package ru.job4j.loop;

public class Counter {

    public int add(int start, int finish)
    {
        int sum = 0;
        // вывод проверки на четность только единожды
        if (start % 2 == 0)
        {
            for (int i = start; i <= finish; i = i + 2)
            {
                sum += i;
            }
        }
        else
        {
            for (int i = start + 1; i <= finish; i = i + 2)
            {
                sum += i;
            }
        }
        return sum;
    }
}
