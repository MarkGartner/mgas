package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest
{
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty()
    {
        Factorial factorishka = new Factorial();
        int result = factorishka.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne()
    {
        Factorial factorishka = new Factorial();
        int result = factorishka.calc(0);
        assertThat(result, is(1));
    }
}