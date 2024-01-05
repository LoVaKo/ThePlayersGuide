package CharberryTrees;

class Observia {

    public static void main(String[] args) {
        CharberryTree tree = new CharberryTree();
        Notifier notifier = new Notifier();
        Harvester harvester = new Harvester();

        while (true) {
            tree.maybeGrow();
            boolean hasRipened = notifier.handle(tree);
            if (hasRipened) harvester.harvest(tree);
        }
    }
}
