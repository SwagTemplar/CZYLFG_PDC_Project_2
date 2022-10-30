import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kisoo
 */
public class InventoryTest {
    
    public InventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockCheck method of class Inventory when there is a valid quantity.
     */
    @Test
    public void testStockCheckValidQuantity() {
        System.out.println("Test valid quantity");
        int itemID = 3;
        int quantity = 300;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        boolean expResult = true;
        boolean result = instance.stockCheck(itemID, quantity);
        assertEquals(expResult, result);
    }

    /**
     * Test of stockCheck method of class Inventory when there is a invalid positive quantity.
     */
    @Test
    public void testStockCheckInvalidPositiveQuantitiy() {
        System.out.println("Test invalid positive quantity");
        int itemID = 3;
        int quantity = 1500;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        boolean expResult = false;
        boolean result = instance.stockCheck(itemID, quantity);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of stockCheck method of class Inventory when there is a invalid negative quantity.
     */
    @Test
    public void testStockCheckInvalidNegativeQuantitiy() {
        System.out.println("Test invalid negative quantity");
        int itemID = 3;
        int quantity = -100;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        boolean expResult = false;
        boolean result = instance.stockCheck(itemID, quantity);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of stockCheck method of class Inventory when there is zero quantity.
     */
    @Test
    public void testStockCheckZero() {
        System.out.println("Test zero quantity");
        int itemID = 3;
        int quantity = 0;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        boolean expResult = false;
        boolean result = instance.stockCheck(itemID, quantity);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of stockCheck method of class Inventory when there is one quantity.
     */
    @Test
    public void testStockCheckOne() {
        System.out.println("Test one quantity");
        int itemID = 3;
        int quantity = 1;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        boolean expResult = true;
        boolean result = instance.stockCheck(itemID, quantity);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of increaseInventory method of class Inventory when there is a invalid negative value.
     */
    @Test
    public void increaseInventoryNegativeValue() {
        System.out.println("Test increase inventory negative value");
        int itemID = 3;
        int quantity = 1;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        instance.increaseInventory(itemID, quantity);
        int expResult = 1001;
        assertEquals(expResult, instance.itemArr.get(0).getQuantityInStock());
    }
    
    /**
     * Test of increaseInventory method of class Inventory when there is a invalid large value.
     */
    @Test
    public void increaseInventoryLargeValue() {
        System.out.println("Test increase inventory large value");
        int itemID = 3;
        int quantity = 100000;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        instance.increaseInventory(itemID, quantity);
        if(instance.itemArr.get(0).getQuantityInStock() > 99999) {
            fail();
        }
    }
    
    
    /**
     * Test of increaseInventory method of class Inventory when there is a zero value.
     */
    @Test
    public void increaseInventoryZeroValue() {
        System.out.println("Test increase inventory by zero");
        int itemID = 3;
        int quantity = 0;
        Item item = new Item(3, "Banana", 1000);
        Inventory instance = new Inventory();
        instance.add(item);
        instance.increaseInventory(itemID, quantity);
        if(instance.itemArr.get(0).getQuantityInStock() != 1000) {
            fail();
        }
    }
}
