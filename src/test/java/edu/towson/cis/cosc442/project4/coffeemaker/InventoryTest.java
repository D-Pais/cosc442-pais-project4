package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    
    private Inventory inv;
    private Recipe rec;

    @BeforeEach
    void Setup() {
        inv = new Inventory();
        rec = new Recipe();
        rec.setName("rec1");
        rec.setPrice(10);
        rec.setAmtChocolate(1);
        rec.setAmtCoffee(2);
        rec.setAmtMilk(3);
        rec.setAmtSugar(4);
    }
    @AfterEach
    void tearDown() {
        inv = null;
        rec = null;
    }


    @Test
    void testCoffeeSetGet() {
        inv.setCoffee(20);
        assertEquals(20, inv.getCoffee());
        inv.setCoffee(1);
        assertEquals(1, inv.getCoffee());
        inv.setCoffee(0);
        assertEquals(0, inv.getCoffee());
    }
    @Test
    void setCoffeeNegativeTest() {
        inv.setCoffee(-1);
        assertEquals(0, inv.getCoffee());
        inv.setCoffee(-5);
        assertEquals(0, inv.getCoffee());
    }

    @Test
    void testMilkSetGet() {
        inv.setMilk(25);
        assertEquals(25, inv.getMilk());
        inv.setMilk(1);
        assertEquals(1, inv.getMilk());
        inv.setMilk(0);
        assertEquals(0, inv.getMilk());
    }
    @Test
    void setMilkNegativeTest() {
        inv.setMilk(-1);
        assertEquals(0, inv.getMilk());
        inv.setMilk(-10);
        assertEquals(0, inv.getMilk());
    }

    @Test
    void testSugarSetGet() {
        inv.setSugar(30);
        assertEquals(30, inv.getSugar());
        inv.setSugar(1);
        assertEquals(1, inv.getSugar());
        inv.setSugar(0);
        assertEquals(0, inv.getSugar());
    }
    @Test
    void setSugarNegativeTest() {
        inv.setSugar(-1);
        assertEquals(0, inv.getSugar());
        inv.setSugar(-15);
        assertEquals(0, inv.getSugar());
    }

    @Test
    void testChocolateSetGet() {
        inv.setChocolate(35);
        assertEquals(35, inv.getChocolate());
        inv.setChocolate(1);
        assertEquals(1, inv.getChocolate());
        inv.setChocolate(0);
        assertEquals(0, inv.getChocolate());
    }
    @Test
    void setChocolateNegativeTest() {
        inv.setChocolate(-1);
        assertEquals(0, inv.getChocolate());
        inv.setChocolate(-20);
        assertEquals(0, inv.getChocolate());
    }

    @Test
    void enoughIngredientsTest() {
        assert(inv.enoughIngredients(rec));
        rec.setAmtChocolate(15);
        rec.setAmtCoffee(15);
        rec.setAmtMilk(15);
        rec.setAmtSugar(15);
        //assert(inv.enoughIngredients(rec));
    }
    @Test
    void testNotEnoughIngredients() {
        inv.setChocolate(0);
        assert(!inv.enoughIngredients(rec));
        // inv.setChocolate(15);
        inv.setCoffee(1);
        assert(!inv.enoughIngredients(rec));
        // inv.setCoffee(15);
        inv.setMilk(2);
        assert(!inv.enoughIngredients(rec));
        // inv.setMilk(15);
        inv.setSugar(3);
        assert(!inv.enoughIngredients(rec));
        // inv.setChocolate(1);
        // inv.setCoffee(2);
        // inv.setMilk(3);
        // inv.setSugar(4);
        //assert(inv.enoughIngredients(rec));
    }

    @Test
    void toStringTest() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, inv.toString());
    }
    
}
