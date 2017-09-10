package ru.job4j.loop;

import java.awt.*;

public class Paint
{

    public String pyramid(int height)
    {
        int maxWidth = (height - 1) * 2 + 1;

        String slineN = System.getProperty("line.separator");
        char cLineN = slineN.charAt(0);

        StringBuilder myPyramid = new StringBuilder();

        for (int i = 0; i < height; i++)
        {
            int peaks = i * 2 + 1;
            int spaces = (maxWidth - peaks) / 2;

            for (int c = 0; c < spaces; c++)
            {
                myPyramid.append(' ');
            }
            for (int j = 0; j < peaks; j++)
            {
                myPyramid.append('^');
            }
            for (int c = 0; c < spaces; c++)
            {
                myPyramid.append(' ');
            }
            if (i != height - 1)
                myPyramid.append(cLineN);
        }
        return myPyramid.toString();
    }

}
