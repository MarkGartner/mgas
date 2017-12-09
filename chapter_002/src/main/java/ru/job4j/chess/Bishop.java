package ru.job4j.chess;

import static java.lang.Math.abs;

public class Bishop extends Figure {


    Bishop(Cell position) {
        super(position);
    }

    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {

        // maximum amount of steps bishop can take is 6
        Cell[] possibleWay = new Cell[6];
        int steps = 0;

        // bishop always increments both axes by the same number
        if (abs(dest.x - source.x) != abs(dest.y - source.y) || Cell.isIdentical(source, dest)) {
            throw new ImposibleMoveException();
        }

        // distance covered by move
        int distance = abs(source.x - dest.x) + 1;


        // populating array describing cells that are on the path
        for (int i = 0; i < distance; i++) {
            if (dest.x > source.x) {
                if (dest.y > source.y) {
                    possibleWay[i] = new Cell(source.x + i, source.y + i);
                } else {
                    possibleWay[i] = new Cell(source.x + i, source.y - i);
                }
            } else {
                if (dest.y > source.y) {
                    possibleWay[i] = new Cell(source.x - i, source.y + i);
                } else {
                    possibleWay[i] = new Cell(source.x - i, source.y - i);
                }
            }
            steps++;
        }

        // removing null indexes from the way array
        Cell[] way = new Cell[steps];

        for (int j = 0; j < steps; j++) {
            way[j] = possibleWay[j];
        }

        return way;
    }

    Figure copy(Cell destination) {
        return new Bishop(destination);
    }
}
