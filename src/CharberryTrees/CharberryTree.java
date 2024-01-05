package CharberryTrees;

import java.util.Random;

class CharberryTree {
    private final Random random = new Random();
    private boolean ripe = false;

    public boolean getRipe() {
        return this.ripe;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }

    public void maybeGrow() {

        // Only a tiny chance of ripening each time, but we try a lot!
        if (random.nextDouble() < 0.00000001 && !ripe)
            ripe = true;
    }
}
