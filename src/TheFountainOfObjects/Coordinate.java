package TheFountainOfObjects;

public class Coordinate {
    int row;
    int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "coördinates: " + row + ", " + column;
    }

    public boolean isMatchWith(Coordinate that) {
        return this.row == that.row && this.column == that.column;
    }
}
