package ru.job4j.chess;

public class Cell {

    int x, y;

    public Cell(int x, int y)  {

        if (withinAllowedRange(x, y)) {
            this.x = x;
            this.y = y;
        }
    }

    boolean withinAllowedRange(int x, int y) {

        int[] allowedRange = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int count = 0;

        for (int i = 0; i < allowedRange.length; i++) {
            if (x == allowedRange[i + 1]) {
                count++;
            }
            if (x == allowedRange[i + 1]) {
                count++;
            }
        }

        return count == 2;
    }

    static boolean isIdentical(Cell first, Cell second) {
        return (first.x == second.x && first.y == second.y);
    }

}
