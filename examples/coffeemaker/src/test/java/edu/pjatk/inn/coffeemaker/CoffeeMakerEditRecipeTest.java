package edu.pjatk.inn.coffeemaker;

/**
 * @author Andrzej Górz & Marcin Dobosz
 */

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerEditRecipeTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe1, recipe;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        recipe1 = CoffeeMakerConditions.getRecipe1();
        coffeeMaker.addRecipe(recipe1);
    }

    @Test
    public void editRecipe1() {
        assertTrue(coffeeMaker.editRecipe(recipe1, recipe1));
    }


    @Test
    public void editRecipe2() {
        assertTrue(coffeeMaker.editRecipe(recipe1, recipe1));
    }


    // Mocha could not be added. Price can not be negative.
    @Test(expected = NullPointerException.class)
    public void editRecipe3() {
        recipe.setName("Mocha");
        recipe.setPrice(-50);
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Mocha could not be added. Price can not be negative.
    @Test(expected = NullPointerException.class)
    public void editRecipe4() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(-3);
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Mocha could not be added. Units of milk can not be negative.
    @Test(expected = NullPointerException.class)
    public void editRecipe5() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(-2);
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Mocha could not be added. Units of sugar can not be negative.
    @Test(expected = NullPointerException.class)
    public void editRecipe6() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(-2);
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Mocha could not be added. Units of chocolate can not be negative.
    @Test(expected = NullPointerException.class)
    public void editRecipe7() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(2);
        recipe.setAmtChocolate(-3);
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }


    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void editRecipe8() {
        recipe.setName("Mocha");
        recipe.setAmtChocolate(Integer.getInteger("a"));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void editRecipe9() {
        recipe.setName("Mocha");
        recipe.setAmtCoffee(Integer.getInteger("a"));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void editRecipe10() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtMilk(Integer.getInteger("a"));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void editRecipe11() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(Integer.getInteger("a"));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void editRecipe12() {
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(2);
        recipe.setAmtChocolate(Integer.getInteger("a"));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe));
    }

}
