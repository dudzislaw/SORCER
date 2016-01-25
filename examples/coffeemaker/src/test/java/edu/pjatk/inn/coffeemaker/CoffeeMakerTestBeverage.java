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
public class CoffeeMakerTestBeverage {
	private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTestBeverage.class);

	private CoffeeMaker coffeeMaker;
	private Inventory inventory;
	private Recipe espresso, mocha, macchiato, americano, coffee1, coffee2;

	@Before
	public void setUp() throws ContextException {
		coffeeMaker = new CoffeeMaker();
		inventory = coffeeMaker.checkInventory();

		espresso = new Recipe();
		espresso.setName("espresso");
		espresso.setPrice(50);
		espresso.setAmtCoffee(6);
		espresso.setAmtMilk(1);
		espresso.setAmtSugar(1);
		espresso.setAmtChocolate(0);

		mocha = new Recipe();
		mocha.setName("mocha");
		mocha.setPrice(100);
		mocha.setAmtCoffee(8);
		mocha.setAmtMilk(1);
		mocha.setAmtSugar(1);
		mocha.setAmtChocolate(2);

		macchiato = new Recipe();
		macchiato.setName("macchiato");
		macchiato.setPrice(40);
		macchiato.setAmtCoffee(7);
		macchiato.setAmtMilk(1);
		macchiato.setAmtSugar(2);
		macchiato.setAmtChocolate(0);

		americano = new Recipe();
		americano.setName("americano");
		americano.setPrice(40);
		americano.setAmtCoffee(7);
		americano.setAmtMilk(1);
		americano.setAmtSugar(2);
		americano.setAmtChocolate(0);

		coffee1 = new Recipe();
		coffee1.setName("Coffee");
		coffee1.setPrice(50);
		coffee1.setAmtCoffee(3);
		coffee1.setAmtMilk(1);
		coffee1.setAmtSugar(1);
		coffee1.setAmtChocolate(0);
	}


	@Test
	public void purchaseBeverage1(){
		assertEquals(coffeeMaker.makeCoffee(coffee1, 60), 10);
	}

	@Test
	public void purchaseBeverage2(){
		assertEquals(coffeeMaker.makeCoffee(coffee1, 40), 40);
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
		Recipe[] recipes = coffeeMaker.getRecipes();
		assertEquals(coffeeMaker.makeCoffee(recipes[3], 50), 50);
	}

}

