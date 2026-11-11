package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {
    
    private Recipe rec;

    @BeforeEach
    void Setup() {
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
        rec = null;
    }


    @Test
    void testChocolateSetGet() {
        assertEquals(1, rec.getAmtChocolate());
        rec.setAmtChocolate(10);
        assertEquals(10, rec.getAmtChocolate());
    }
    @Test
    void setChocolateNegativeTest() {
        rec.setAmtChocolate(-5);
        assertEquals(0, rec.getAmtChocolate());
    }

    @Test
    void testCoffeeSetGet() {
        assertEquals(2, rec.getAmtCoffee());
        rec.setAmtCoffee(20);
        assertEquals(20, rec.getAmtCoffee());
    }
    @Test
    void setCoffeeNegativeTest() {
        rec.setAmtCoffee(-10);
        assertEquals(0, rec.getAmtCoffee());
    }

    @Test
    void testMilkSetGet() {
        assertEquals(3, rec.getAmtMilk());
        rec.setAmtMilk(30);
        assertEquals(30, rec.getAmtMilk());
    }
    @Test
    void setMilkNegativeTest() {
        rec.setAmtMilk(-15);
        assertEquals(0, rec.getAmtMilk());
    }

    @Test
    void testSugarSetGet() {
        assertEquals(4, rec.getAmtSugar());
        rec.setAmtSugar(40);
        assertEquals(40, rec.getAmtSugar());
    }
    @Test
    void setSugarNegativeTest() {
        rec.setAmtSugar(-20);
        assertEquals(0, rec.getAmtSugar());
    }

    @Test
    void testNameSetGet() {
        assertEquals("rec1", rec.getName());
        rec.setName("recrec");
        assertEquals("recrec", rec.getName());
    }

    @Test
    void testPriceSetGet() {
        assertEquals(10, rec.getPrice());
        rec.setPrice(42);
        assertEquals(42, rec.getPrice());
    }
    @Test
    void setPriceNegativeTest() {
        rec.setPrice(-25);
        assertEquals(0, rec.getPrice());
    }

    @Test
    void equalsTest() {
        Recipe rec2 = new Recipe();
        rec2.setName("rec1");
        assert(rec.equals(rec2));
    }
    @Test
    void notEqualsTest() {
        Recipe rec2 = new Recipe();
        rec2.setName("rec2");
        assert(!rec.equals(rec2));
    }
    @Test
    void testEqualsNulls() {
        Recipe rec2 = new Recipe();
        assert(!rec.equals(rec2));
        rec.setName(null);
        rec2.setName("rec2");
        assert(!rec.equals(rec2));
    }


}
