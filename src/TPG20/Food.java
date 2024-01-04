package TPG20;

import java.util.EnumSet;

public class Food {
    FoodType foodType;
    MainIngredient mainIngredient;
    Seasoning seasoning;

    public Food(FoodType foodType, MainIngredient mainIngredient, Seasoning seasoning) {
        this.foodType = foodType;
        this.mainIngredient = mainIngredient;
        this.seasoning = seasoning;
    }

    public static Food makeFood(String foodType, String mainIngredient, String seasoning) {
        FoodType convertedType = findEnum(foodType, FoodType.class);
        MainIngredient convertedMain = findEnum(mainIngredient, MainIngredient.class);
        Seasoning convertedSeasoning = findEnum(seasoning, Seasoning.class);

        return new Food(convertedType, convertedMain, convertedSeasoning);
    }

    private static <T extends Enum<T>> T findEnum(String value, Class<T> enumClass) {
        for (T constant : EnumSet.allOf(enumClass)) {
            if (value.equalsIgnoreCase(constant.toString())) {
                return constant;
            }
        }
        return null;
    }

}
