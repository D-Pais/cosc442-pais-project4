package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {
    
    private CoffeeMaker cm;
    private Recipe rec;
    private Recipe rec2;
    private Recipe rec3;
    private Recipe rec4;
    private Recipe rec5;
    private Recipe nullrec;
    private Inventory inv;
    private Inventory emptInv;

    @BeforeEach 
    void Setup() {
        cm = new CoffeeMaker();
        Inventory spud = cm.checkInventory();
        rec = new Recipe();
        rec.setName("rec1");
        rec.setPrice(10);
        rec.setAmtChocolate(1);
        rec.setAmtCoffee(2);
        rec.setAmtMilk(3);
        rec.setAmtSugar(4);
        rec2 = new Recipe();
        rec2.setName("rec2");
        rec2.setPrice(13);
        rec2.setAmtChocolate(11);
        rec2.setAmtCoffee(7);
        rec2.setAmtMilk(5);
        rec2.setAmtSugar(3);
        rec3 = new Recipe();
        rec3.setName("rec3");
        rec3.setPrice(15);
        rec3.setAmtChocolate(12);
        rec3.setAmtCoffee(8);
        rec3.setAmtMilk(6);
        rec3.setAmtSugar(4);
        rec4 = new Recipe();
        rec4.setName("rec4");
        rec4.setPrice(17);
        rec4.setAmtChocolate(13);
        rec4.setAmtCoffee(9);
        rec4.setAmtMilk(7);
        rec4.setAmtSugar(5);
        rec5 = new Recipe();
        rec5.setName("rec5");
        rec5.setPrice(19);
        rec5.setAmtChocolate(14);
        rec5.setAmtCoffee(10);
        rec5.setAmtMilk(8);
        rec5.setAmtSugar(6);
        nullrec = new Recipe();
    }
    @AfterEach
    void Teardown() {
        cm = null;
        rec = null;
        rec2 = null;
        rec3 = null;
        rec4 = null;
        rec5 = null;
        nullrec = null;
        inv = null;
    }


    @Test 
    void addRecipeTest() {
        assert(cm.addRecipe(rec));
        assert(cm.addRecipe(rec2));
    }
    @Test
    void addTooManyRecipeTest() {
        assert(cm.addRecipe(rec));
        assert(cm.addRecipe(rec2));
        assert(cm.addRecipe(rec3));
        assert(cm.addRecipe(rec4));
        assert(!cm.addRecipe(rec5));
    }
    @Test
    void addNullRecipeTest() {
        assertThrows(NullPointerException.class, () -> { assert(cm.addRecipe(null)); });
        assertThrows(NullPointerException.class, () -> { assert(cm.addRecipe(null)); });
    }
    @Test
    void addExistingRecipeTest() {
        assert(cm.addRecipe(rec));
        assert(!cm.addRecipe(rec));
    }

    @Test
    void deleteRecipeTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        cm.addRecipe(rec3);
        cm.addRecipe(rec4);
        assert(cm.deleteRecipe(rec));
        assert(cm.deleteRecipe(rec2));
        assert(cm.deleteRecipe(rec3));
        assert(cm.deleteRecipe(rec4));
    }
    @Test
    void deleteEmptyRecipeTest() {
        assert(!cm.deleteRecipe(rec));
        assert(!cm.deleteRecipe(rec));
    }
    @Test
    void deleteNullRecipeTest() {
        assert(!cm.deleteRecipe(null));
        assert(!cm.deleteRecipe(null));
    }

    @Test
    void editRecipe() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        cm.addRecipe(rec3);
        cm.addRecipe(rec4);
        Recipe recDupe = new Recipe();
        recDupe.setName("rec1");
        recDupe.setPrice(10);
        recDupe.setAmtChocolate(1);
        recDupe.setAmtCoffee(2);
        recDupe.setAmtMilk(3);
        recDupe.setAmtSugar(4);
        assert(cm.editRecipe(rec, recDupe));
    }
    @Test
    void editRecipeEmptyMachine() {
        assert(!cm.editRecipe(rec, rec));
    }

    @Test
    void addInventoryTest() {
        assert(cm.addInventory(0, 5, 10, 20));
        assert(cm.addInventory(5, 10, 20, 0));
        assert(cm.addInventory(10, 20, 0, 5));
        assert(cm.addInventory(20, 0, 5, 10));
    }
    @Test
    void addInventoryNegativesTest() {
        assert(!cm.addInventory(-1, 0, 0, 0));
        assert(!cm.addInventory(0, -1, 0, 0));
        assert(!cm.addInventory(0, 0, -1, 0));
        assert(!cm.addInventory(0, 0, 0, -1));
    }

    @Test
    void checkInventoryTest() {
        cm.addInventory(5, 10, 15, 20);
        Inventory tempInv = cm.checkInventory();
        assert(tempInv.getChocolate() == 35);
        assert(tempInv.getCoffee() == 20);
        assert(tempInv.getMilk() == 25);
        assert(tempInv.getSugar() == 30);
    }

    @Test
    void makeCoffeeTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        assertEquals(0, cm.makeCoffee(rec, 10), 0.001);
        assertEquals(0, cm.makeCoffee(rec2, 13), 0.001);
    }
    @Test
    void makeCoffeePoorTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        assertEquals(0, cm.makeCoffee(rec, 0), 0.001);
        assertEquals(5, cm.makeCoffee(rec, 5), 0.001);
        assertEquals(7, cm.makeCoffee(rec2, 7), 0.001);
        assertEquals(10, cm.makeCoffee(rec2, 10), 0.001);
    }
    @Test
    void makeCoffeeRichTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        cm.addInventory(20, 20, 20, 20);
        assertEquals(10, cm.makeCoffee(rec, 20), 0.001);
        assertEquals(7, cm.makeCoffee(rec, 17), 0.001);
        assertEquals(17, cm.makeCoffee(rec2, 30), 0.001);
        assertEquals(8, cm.makeCoffee(rec2, 21), 0.001);
    }
    @Test
    void makeCoffeeNotEnoughInventoryTest() {
        cm.addRecipe(rec2);
        cm.makeCoffee(rec2, 20);
        assertEquals(20, cm.makeCoffee(rec2, 20), 0.001);
    }

    @Test
    void getRecipeTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        cm.addRecipe(rec3);
        cm.addRecipe(rec4);
        Recipe[] recipes = cm.getRecipes();
        assertEquals(rec, recipes[3]);
        assertEquals(rec2, recipes[2]);
        assertEquals(rec3, recipes[1]);
        assertEquals(rec4, recipes[0]);
    }

    @Test
    void getRecipeForNameTest() {
        cm.addRecipe(rec);
        cm.addRecipe(rec2);
        cm.addRecipe(rec3);
        cm.addRecipe(rec4);
        assertEquals(rec, cm.getRecipeForName("rec1"));
        assertEquals(rec2, cm.getRecipeForName("rec2"));
        assertEquals(rec3, cm.getRecipeForName("rec3"));
        assertEquals(rec4, cm.getRecipeForName("rec4"));
    }
    @Test
    void getRecipeNotFoundTest() {
        Recipe noRec = cm.getRecipeForName("rec");
        assertNull(noRec.getName());
        assertEquals(0, noRec.getPrice());
        assertEquals(0, noRec.getAmtChocolate());
        assertEquals(0, noRec.getAmtCoffee());
        assertEquals(0, noRec.getAmtMilk());
        assertEquals(0, noRec.getAmtSugar());
    }

}
