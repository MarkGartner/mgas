package ru.job4j.max;

public class Max {


    public int max(int first, int second)
    {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third)
    {
        int temp = max(first, second);
        return max(third, temp);
    }
}
