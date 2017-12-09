package ru.job4j.chess;

public class Board {

    Figure[][] figures;

    public Board(Figure[][] figures) {
        this.figures = figures;
    }


    boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {

        // throwing FigureNotFoundException if source cell is empty
        if (figures[source.x][source.y] == null) {
            throw new FigureNotFoundException();
        }

        Figure sourceFigure = figures[source.x][source.y];

        // method way will throw ImposibleMoveException, if source and destination cells are not correct for the figure
        Cell[] cellsOnWay = sourceFigure.way(source, dest);

        //throwing OccupiedWayException if there are any cells on the way that are occupied
        for (Cell pathCell : cellsOnWay) {
            if (figures[pathCell.x][pathCell.y] != null) {
                throw new OccupiedWayException();
            }
        }

        // if no exceptions are thrown, the figure is moved to destination cell, and source is set to null
        figures[dest.x][dest.y] = sourceFigure.copy(dest);
        figures[source.x][source.y] = null;

        return true;
    }


}
