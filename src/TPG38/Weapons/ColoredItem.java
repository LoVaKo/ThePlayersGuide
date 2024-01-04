package TPG38.Weapons;

public class ColoredItem<T> {
    private final ConsoleColor color;
    private final T weapon;

    public ColoredItem(T weapon, ConsoleColor color) {
        this.weapon = weapon;
        this.color = color;
    }

    public void display() {
        System.out.println(ConsoleColor.getColorCode(color));
        System.out.println(weapon.toString());
    }
}
