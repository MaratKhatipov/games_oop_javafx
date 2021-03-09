package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!(isDiagonal(position, dest))) {
            throw new ImpossibleMoveException(
                    String.format("Не удалось переместиться по диагонали от  %s to %s",
                            position, dest)
            );
        }
        int size = Math.abs(position().getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int positionX = position.getX();
        int destX = dest.getX();
        int positionY = position.getY();
        int destY = dest.getY();
        int deltaX = positionX > destX ? -1 : 1;
        int deltaY = positionY > destY ? -1 : 1;
        for (int index = 0; index < size; index++) {
            positionX += deltaX;
            positionY += deltaY;
            steps[index] = Cell.findBy(positionX, positionY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(position().getX() - dest.getX())
                == Math.abs(position().getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
