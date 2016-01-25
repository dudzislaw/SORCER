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
    private Recipe coffee;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        coffee = new Recipe();
        coffee.setName("Coffee");
        coffee.setPrice(50);
        coffee.setAmtCoffee(3);
        coffee.setAmtMilk(1);
        coffee.setAmtSugar(1);
        coffee.setAmtChocolate(0);
        coffeeMaker.addRecipe(coffee);
    }

    @Test
    public void testEditRecipe1() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(1);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(1);
        assertTrue(coffeeMaker.editRecipe(coffee, recipe));
    }


    @Test
    public void testEditRecipe2() {
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(1);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(1);
        assertTrue(coffeeMaker.editRecipe(coffee, recipe));
    }


    @Test
    public void testEditRecipe3() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(-50);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(1);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(1);
        assertFalse(coffeeMaker.editRecipe(coffee, recipe));
    }

    @Test
    public void testEditRecipe4() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(1);
        recipe.setAmtCoffee(-3);
        recipe.setAmtMilk(1);
        assertFalse(coffeeMaker.editRecipe(coffee, recipe));
    }

    @Test
    public void testEditRecipe5() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(1);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(-2);
        assertFalse(coffeeMaker.editRecipe(coffee, recipe));
    }

    @Test
    public void testEditRecipe6() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtChocolate(0);
        recipe.setAmtSugar(-2);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        assertFalse(coffeeMaker.editRecipe(coffee, recipe));
    }

    @Test
    public void testEditRecipe7() {
        Recipe recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setAmtChocolate(-3);
        recipe.setAmtSugar(3);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setPrice(60);
        assertFalse(coffeeMaker.editRecipe(coffee, recipe));
    }
}
