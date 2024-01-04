package TPG36;

public record Coordinate(int row, int column) {
    public static void main(String[] args) {
        Coordinate co1 = new Coordinate(4, 8);
        Coordinate co2 = new Coordinate(3, -4);
        Coordinate co3 = new Coordinate(5, 7);
        Coordinate co4 = new Coordinate(10, 2);

        System.out.println(co1.isAdjacentTo(co2));
        System.out.println(co2.isAdjacentTo(co4));
        System.out.println(co1.isAdjacentTo(co3));
    }

    public boolean isAdjacentTo(Coordinate other) {
        return Math.abs(this.row - other.row) == 1 && Math.abs(this.column - other.column) == 1;
    }
}