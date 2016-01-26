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
    private Recipe addRecipe1, addRecipe2, addRecipe3, recipe;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        addRecipe3 = new Recipe();
        addRecipe3.setName("Hot Chocolate");
        addRecipe3.setAmtSugar(2);
        addRecipe3.setAmtChocolate(3);
        addRecipe3.setAmtCoffee(0);
        addRecipe3.setAmtMilk(2);
        addRecipe3.setPrice(60);
        addRecipe2 = new Recipe();
        addRecipe2.setName("Latte");
        addRecipe2.setAmtSugar(2);
        addRecipe2.setAmtChocolate(0);
        addRecipe2.setAmtCoffee(3);
        addRecipe2.setAmtMilk(3);
        addRecipe2.setPrice(60);
        addRecipe1 = new Recipe();
        addRecipe1.setName("Mocha");
        addRecipe1.setAmtSugar(2);
        addRecipe1.setAmtChocolate(3);
        addRecipe1.setAmtCoffee(3);
        addRecipe1.setAmtMilk(2);
        addRecipe1.setPrice(60);
        addRecipe1 = new Recipe();
        addRecipe1.setName("Coffee");
        addRecipe1.setAmtSugar(1);
        addRecipe1.setAmtChocolate(0);
        addRecipe1.setAmtCoffee(3);
        addRecipe1.setAmtMilk(1);
        addRecipe1.setPrice(50);
    }

    @Test
    public void addRecipe1() {
        coffeeMaker.addRecipe(addRecipe1);
        assertEquals(coffeeMaker.getRecipeForName("Coffee").getName(), "Coffee");
    }

    @Test
    public void addRecipe2() {
        coffeeMaker.addRecipe(addRecipe1);
        assertFalse(coffeeMaker.addRecipe(addRecipe1));
    }

    @Test
    public void addRecipe3() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(-50);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe4() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(-3);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe5() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(-2);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe6() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(-2);
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
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


    @Test
    public void addRecipe8() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe9() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe10() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe11() {
        recipe = new Recipe();
        recipe.setName("Mocha");
        recipe.setPrice(60);
        recipe.setAmtCoffee(3);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(Integer.getInteger("a"));
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
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
        assertTrue(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void addRecipe14() {
        assertTrue(coffeeMaker.addRecipe(recipe));
        assertTrue(coffeeMaker.addRecipe(addRecipe2));
    }

    @Test
    public void addRecipe15() {
        assertTrue(coffeeMaker.addRecipe(recipe));
        assertTrue(coffeeMaker.addRecipe(addRecipe2));
        assertFalse(coffeeMaker.addRecipe(addRecipe3));
    }

    @Test
    public void deleteRecipe1() {
        coffeeMaker.addRecipe(addRecipe1);
        assertTrue(coffeeMaker.deleteRecipe(addRecipe1));
    }

    @Test
    public void deleteRecipe2() {
        assertFalse(coffeeMaker.deleteRecipe(addRecipe1));
    }

}
