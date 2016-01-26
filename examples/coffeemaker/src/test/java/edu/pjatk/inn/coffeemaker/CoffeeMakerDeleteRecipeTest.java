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
public class CoffeeMakerDeleteRecipeTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe1;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        recipe1 = CoffeeMakerConditions.getRecipe1();
        coffeeMaker.addRecipe(recipe1);
    }

    @Test
    public void deleteRecipe1() {
        assertTrue(coffeeMaker.deleteRecipe(recipe1));
    }

    // There are no recipes to delete
    @Test(expected = AssertionError.class)
    public void deleteRecipe2() {
        assertFalse(coffeeMaker.deleteRecipe(recipe1));
    }

}
