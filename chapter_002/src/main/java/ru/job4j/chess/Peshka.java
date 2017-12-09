package ru.job4j.chess;

public class Peshka extends Figure {

    Peshka(Cell position) {
        super(position);
    }

    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {

        if (dest.x - source.x == 1 && dest.y == source.y) {
            Cell[] way = new Cell[2];
            way[0] = new Cell(source.x, source.y);
            way[1] = new Cell(dest.x, dest.y);
            return way;
        } else {
            throw new ImposibleMoveException();
        }

    }

    Figure copy(Cell destination) {
        return new Peshka(destination);
    }
}
