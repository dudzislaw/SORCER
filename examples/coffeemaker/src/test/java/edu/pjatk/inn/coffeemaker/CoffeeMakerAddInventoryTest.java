package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.*;


/**
 * Created by ag on 26/01/2016
 */
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class CoffeeMakerAddInventoryTest {

    private CoffeeMaker coffeeMaker;

    private Inventory inventory;

    private int coffee, milk, sugar, chocolate;
    private int addCoffee, addMilk, addSugar, addChocolate;


    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        inventory = coffeeMaker.checkInventory();
    }

    @Test
    public void addInventory1() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = 3;
        addSugar = 7;
        addChocolate = 2;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertEquals(coffee + addCoffee, inventory.getCoffee());
        assertEquals(milk + addMilk, inventory.getMilk());
        assertEquals(sugar + addSugar, inventory.getSugar());
        assertEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    // Cannot add inventory. Units of coffee can not be negative
    @Test
    public void addInventory2() {

        coffee = inventory.getCoffee();

        addCoffee = -1;
        addMilk = 0;
        addSugar = 0;
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertNotEquals(coffee + addCoffee, inventory.getCoffee());

    }

    // Cannot add inventory. Units of milk can not be negative
    @Test
    public void addInventory3() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();

        addCoffee = 5;
        addMilk = -1;
        addSugar = 0;
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertNotEquals(coffee + addCoffee, inventory.getCoffee());
        assertNotEquals(milk + addMilk, inventory.getMilk());

    }

    // Cannot add inventory. Units of milk can not be negative
    @Test
    public void addInventory4() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = 3;
        addSugar = -1;
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertNotEquals(coffee + addCoffee, inventory.getCoffee());
        assertNotEquals(milk + addMilk, inventory.getMilk());
        assertNotEquals(sugar + addSugar, inventory.getSugar());

    }

    // Cannot add inventory. Units of chocolate can not be negative
    @Test
    public void addInventory5() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = 3;
        addSugar = 7;
        addChocolate = -1;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertNotEquals(coffee + addCoffee, inventory.getCoffee());
        assertNotEquals(milk + addMilk, inventory.getMilk());
        assertNotEquals(sugar + addSugar, inventory.getSugar());
        assertNotEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addInventory6() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = Integer.getInteger("a");
        addMilk = 0;
        addSugar = 0;
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertNotEquals(coffee + addCoffee, inventory.getCoffee());
        assertEquals(milk + addMilk, inventory.getMilk());
        assertEquals(sugar + addSugar, inventory.getSugar());
        assertEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addInventory7() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = Integer.getInteger("a");
        addSugar = 0;
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertEquals(coffee + addCoffee, inventory.getCoffee());
        assertNotEquals(milk + addMilk, inventory.getMilk());
        assertEquals(sugar + addSugar, inventory.getSugar());
        assertEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addInventory8() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = 3;
        addSugar = Integer.getInteger("a");
        addChocolate = 0;

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertEquals(coffee + addCoffee, inventory.getCoffee());
        assertEquals(milk + addMilk, inventory.getMilk());
        assertNotEquals(sugar + addSugar, inventory.getSugar());
        assertEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    // Please input an integer.
    @Test(expected = NullPointerException.class)
    public void addInventory9() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        addCoffee = 5;
        addMilk = 3;
        addSugar = 7;
        addChocolate = Integer.getInteger("a");

        coffeeMaker.addInventory(addCoffee, addMilk, addSugar, addChocolate);

        assertEquals(coffee + addCoffee, inventory.getCoffee());
        assertEquals(milk + addMilk, inventory.getMilk());
        assertEquals(sugar + addSugar, inventory.getSugar());
        assertNotEquals(chocolate + addChocolate, inventory.getChocolate());

    }

    @Test
    public void checkInventory() {

        coffee = inventory.getCoffee();
        milk = inventory.getMilk();
        sugar = inventory.getSugar();
        chocolate = inventory.getChocolate();

        assertEquals(coffee, 15);
        assertEquals(milk, 15);
        assertEquals(sugar, 15);
        assertEquals(chocolate, 15);

    }



}
