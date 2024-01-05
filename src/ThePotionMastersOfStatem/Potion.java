package ThePotionMastersOfStatem;

public class Potion {
    PotionType type;

    // Constructor, Getter and Setter
    public Potion() {
        this.type = PotionType.WATER;
    }

    public PotionType getType() {
        return type;
    }

    public void setType(PotionType type) {
        this.type = type;
    }


    public void add(Ingredient ingredient, PotionType potionType) {
        if (potionType == PotionType.WATER) {
            if (ingredient == Ingredient.STARDUST) {
                setType(PotionType.ELIXIR);
                System.out.println("Poof! Your potion turned into an Elixir.");
            } else {
                setType(PotionType.RUINED_POTION);
            }

        } else if (potionType == PotionType.ELIXIR) {
            if (ingredient == Ingredient.SNAKE_VENOM) {
                setType(PotionType.POISON_POTION);
                System.out.println("Poof! Your potion turned into a Poison Potion.");
            } else if (ingredient == Ingredient.DRAGON_BREATH) {
                setType(PotionType.FLYING_POTION);
                System.out.println("Poof! Your potion turned into a Flying Potion.");
            } else if (ingredient == Ingredient.SHADOW_GLASS) {
                setType(PotionType.INVISIBILITY_POTION);
                System.out.println("Poof! Your potion turned into an Invisibility Potion.");
            } else if (ingredient == Ingredient.EYESHINE_GEM) {
                setType(PotionType.NIGHT_SIGHT_POTION);
                System.out.println("Poof! Your potion turned into a Night Sight Potion");
            } else {
                setType(PotionType.RUINED_POTION);
            }

        } else if (potionType == PotionType.INVISIBILITY_POTION) {
            if (ingredient == Ingredient.EYESHINE_GEM) {
                setType(PotionType.CLOUDY_BREW);
                System.out.println("Poof! Your potion turned into a Cloudy Brew.");
            } else {
                setType(PotionType.RUINED_POTION);
            }

        } else if (potionType == PotionType.NIGHT_SIGHT_POTION) {
            if (ingredient == Ingredient.SHADOW_GLASS) {
                setType(PotionType.CLOUDY_BREW);
                System.out.println("Poof! Your potion turned into a Cloudy Brew.");
            } else {
                setType(PotionType.RUINED_POTION);
            }
        } else if (potionType == PotionType.CLOUDY_BREW) {
            if (ingredient == Ingredient.STARDUST) {
                setType(PotionType.WRAITH_POTION);
                System.out.println("Poof! Your potion turned into a Wraith Potion.");
            } else {
                setType(PotionType.RUINED_POTION);
            }

        } else {
            setType(PotionType.RUINED_POTION);
        }
        if (getType() == PotionType.RUINED_POTION) {
            System.out.println("Oh no! You've ruined your potion...");
        }
    }
}
