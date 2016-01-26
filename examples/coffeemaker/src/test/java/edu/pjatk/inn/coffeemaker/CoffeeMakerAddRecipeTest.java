package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.*;

/**
 * Created by Marcin on 26/01/2016
 */
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerAddRecipeTest {

    private CoffeeMaker coffeeMaker;
    private Recipe addRecipe1, recipe13, recipe14, recipe15, recipe;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();

        addRecipe1 = CoffeeMakerConditions.getRecipe1();

        recipe13 = new Recipe();
        recipe13.setName("Mocha");
        recipe13.setPrice(60);
        recipe13.setAmtCoffee(3);
        recipe13.setAmtMilk(2);
        recipe13.setAmtSugar(2);
        recipe13.setAmtChocolate(3);

        recipe14 = new Recipe();
        recipe14.setName("Latte");
        recipe14.setPrice(60);
        recipe14.setAmtCoffee(3);
        recipe14.setAmtMilk(3);
        recipe14.setAmtSugar(2);
        recipe14.setAmtChocolate(0);

        recipe15 = new Recipe();
        recipe15.setName("Hot Chocolate");
        recipe15.setPrice(60);
        recipe15.setAmtCoffee(0);
        recipe15.setAmtMilk(2);
        recipe15.setAmtSugar(2);
        recipe15.setAmtChocolate(3);

    }

    @Test
    public void addRecipe1() {
        coffeeMaker.addRecipe(addRecipe1);
        assertEquals(coffeeMaker.getRecipeForName("Coffee"), addRecipe1);
    }

    @Test
    public void addRecipe2() {
        coffeeMaker.addRecipe(addRecipe1);
        assertFalse(coffeeMaker.addRecipe(addRecipe1));
    }

    // Mocha could not be added. Price can not be negative.
    @Test(expected = AssertionError.class)
    public void addRecipe3() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(-50);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Mocha could not be added. Units of coffee can not be negative.
    @Test(expected = AssertionError.class)
    public void addRecipe4() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(-3);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Mocha could not be added. Units of milk can not be negative.
    @Test(expected = AssertionError.class)
    public void addRecipe5() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(-2);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Mocha could not be added. Units of sugar can not be negative.
    @Test(expected = AssertionError.class)
    public void addRecipe6() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(-2);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Mocha could not be added. Units of chocolate can not be negative.
    @Test(expected = AssertionError.class)
    public void addRecipe7() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(2);
        recipe.setAmtChocolate(-3);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addRecipe8() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addRecipe9() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addRecipe10() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addRecipe11() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addRecipe12() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(2);
        recipe.setAmtChocolate(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe13() {
        assertTrue(coffeeMaker.addRecipe(recipe13));
    }

    @Test
    public void addRecipe14() {
        assertTrue(coffeeMaker.addRecipe(recipe14));
    }

    @Test
    public void addRecipe15() {
        assertTrue(coffeeMaker.addRecipe(recipe15));
    }

}
