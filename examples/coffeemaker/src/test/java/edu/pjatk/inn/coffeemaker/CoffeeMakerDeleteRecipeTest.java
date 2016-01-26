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
    private Recipe addRecipe1;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();

        addRecipe1 = new Recipe();
        addRecipe1.setName("Coffee");
        addRecipe1.setAmtSugar(1);
        addRecipe1.setAmtChocolate(0);
        addRecipe1.setAmtCoffee(3);
        addRecipe1.setAmtMilk(1);
        addRecipe1.setPrice(50);

        coffeeMaker.addRecipe(addRecipe1);
    }

    @Test
    public void deleteRecipe1() {
        assertTrue(coffeeMaker.deleteRecipe(addRecipe1));
    }

    @Test
    public void deleteRecipe2() {
        assertFalse(coffeeMaker.deleteRecipe(addRecipe1));
    }

}
