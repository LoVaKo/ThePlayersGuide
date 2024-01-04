package TPG38.Weapons;

public enum ConsoleColor {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m");

    private final String colorCode;

    ConsoleColor(String colorCode) {
        this.colorCode = colorCode;
    }

    public static String getColorCode(ConsoleColor color) {
        return color.colorCode;
    }
}
