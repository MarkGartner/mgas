package ru.job4j.array;

public class RotateArray
{
    public int[][] rotate(int[][] array)
    {

        int x = array.length;
        int[][] rotatedArray = new int[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                rotatedArray[j][x-1-i] = array[i][j];
            }
        }

        return rotatedArray;
    }

    public static void main(String[] args)
    {
        int n = 3;
        int[][] arr = new int[n][n];
        int inc=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=inc;
                inc++;
            }
        }

        RotateArray sample = new RotateArray();
        int [][] rot = sample.rotate(arr);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.println(rot[i][j]);
            }
        }

    }
}
