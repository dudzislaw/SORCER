package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Andrzej Górz & Marcin Dobosz
 */
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerPurchaseBeverageTest {

	private CoffeeMaker coffeeMaker;
	private Recipe addRecipe1, coffee2;

	@Before
	public void setUp() throws ContextException {
		coffeeMaker = new CoffeeMaker();
		addRecipe1 = new Recipe();
		addRecipe1.setName("Coffee");
		addRecipe1.setPrice(50);
		addRecipe1.setAmtCoffee(3);
		addRecipe1.setAmtMilk(1);
		addRecipe1.setAmtSugar(1);
		addRecipe1.setAmtChocolate(0);
	}


	@Test
	public void purchaseBeverage1(){
		assertEquals(coffeeMaker.makeCoffee(addRecipe1, 60), 10);
	}

	@Test
	public void purchaseBeverage2(){
		assertEquals(coffeeMaker.makeCoffee(addRecipe1, 40), 40);
		assertEquals(coffeeMaker.checkInventory().getCoffee(), 15);
		assertEquals(coffeeMaker.checkInventory().getMilk(), 15);
		assertEquals(coffeeMaker.checkInventory().getChocolate(), 15);
	}

	@Test
	public void purchaseBeverage3(){
		coffee2 = new Recipe();
		coffee2.setName("Coffee");
		coffee2.setPrice(50);
		coffee2.setAmtCoffee(16);
		coffee2.setAmtMilk(2);
		coffee2.setAmtSugar(3);
		coffee2.setAmtChocolate(5);
		coffeeMaker.addRecipe(coffee2);
		assertEquals(coffeeMaker.makeCoffee(coffee2, 50), 50);
	}

}

