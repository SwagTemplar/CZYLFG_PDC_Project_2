
import java.util.ArrayList;

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class Inventory {

    ArrayList<Item> itemArr;

    public Inventory() {
        itemArr = new ArrayList<>();
    }

    public void add(Item item) {
        itemArr.add(item);
    }

    public String toString() {
        String str = "";
        for (Item i : itemArr) {
            str += "Item ID: " + i.getItemID() + " Item Name: " + i.getItemName() + " In Stock: " + i.getQuantityInStock() + "\n";
        }

        return str;
    }

    public boolean stockCheck(int itemID, int quantity) {
        boolean inStock = false;

        for (Item i : itemArr) {
            if (itemID == i.getItemID()) {
                if (quantity >= 1 && i.getQuantityInStock() >= quantity) {
                    inStock = true;
                } else {
                    System.out.println("Invalid Quantity");
                }
            }
        }
        return inStock;
    }

    public void increaseInventory(int itemID, int quantity) {
        for (Item i : itemArr) {
            if (itemID == i.getItemID()) {
                if (quantity >= 1 && quantity < 99999) {
                    i.increaseStock(quantity);
                } else {
                    System.out.println("Invalid Quantity");
                }
            }
        }
    }
}
