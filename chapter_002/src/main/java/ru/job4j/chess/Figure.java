package ru.job4j.chess;

public abstract class Figure {

    final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    abstract Figure copy(Cell destination);
}
