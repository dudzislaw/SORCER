package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.Recipe;

/**
 * Created by ag on 26.01.16.
 */
public class CoffeeMakerConditions {

    public static Recipe getRecipe1() {
        Recipe addRecipe1 = new Recipe();
        addRecipe1.setName("Coffee");
        addRecipe1.setPrice(50);
        addRecipe1.setAmtCoffee(3);
        addRecipe1.setAmtMilk(1);
        addRecipe1.setAmtSugar(1);
        addRecipe1.setAmtChocolate(0);
        return addRecipe1;
    }

}
