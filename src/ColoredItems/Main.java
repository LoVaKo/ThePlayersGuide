package ColoredItems;

import ColoredItems.Weapons.*;

public class Main {
    public static void main(String[] args) {
        ColoredItem<Sword> blueSword = new ColoredItem<>(new Sword(), ConsoleColor.BLUE);
        ColoredItem<Axe> greenAxe = new ColoredItem<>(new Axe(), ConsoleColor.GREEN);
        ColoredItem<Bow> redBow = new ColoredItem<>(new Bow(), ConsoleColor.RED);
        blueSword.display();
        greenAxe.display();
        redBow.display();
    }
}
