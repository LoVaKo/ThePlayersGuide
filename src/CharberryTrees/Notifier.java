package CharberryTrees;

public class Notifier {
    public boolean handle(CharberryTree tree) {
        if (tree.getRipe()) {
            System.out.println("A charberry fruit has ripened!");
            return true;
        } else {
            return false;
        }
    }
}
