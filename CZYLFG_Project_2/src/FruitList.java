

import java.util.HashMap;

/**
 *
 * @author kisoo
 */
public class FruitList {
//    Create fruit objects. Used to populate the fruit array.

    Fruit galaApple = new GalaApple();
    Fruit grannyApple = new GrannySmithApple();
    Fruit mango = new Mango();
    Fruit orange = new Orange();
    Fruit banana = new Banana();
    Fruit watermelon = new Watermelon();

//    Fruit array
    Fruit[] fruitArr = {galaApple, grannyApple, banana, watermelon, mango, orange};

//    Gets the Fruit ID according to the inputted index.
    public int getIDAtIndex(int index) {
        return this.fruitArr[index].getFruitID();
    }

//    Gets the Fruit inventory stock number according to the inputted index.
    public int getInvNumAtIndex(int index) {
        return this.fruitArr[index].getInventoryNum();
    }
    
//    Gets Fruit inventory stock number according to the inputted id.
    public int getInvNumAtID(int id) {
        return this.fruitArr[id].getInventoryNum();
    }

//    Gets the Fruit name according to the inputted index.
    public String getNameAtIndex(int index) {
        return this.fruitArr[index].getFruitName();
    }

//    Prints the fruit array and the contents
    public void printList() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Name: " + fruitArr[i].getFruitName() + "\n"
                    + "Fruit ID: " + fruitArr[i].getFruitID() + "\n"
                    + "Quantity: " + fruitArr[i].getInventoryNum() + "\n");
        }
    }

//    Takes in a hashmap to populate the fruit ID and number of stock
    public void populateFruitList(HashMap<Integer, Integer> hmap) {
        for (int i = 0; i < 6; i++) {
            for (Integer key : hmap.keySet()) {
                if (key.equals(fruitArr[i].getFruitID())) {
                    fruitArr[i].setInventoryNum(hmap.get(key));
                }
            }
        }
    }

//    Reduces the stock by quan given the fruit id
    public void decreaseFruitNum(int id, int quan) {
        for (int i = 0; i < 6; i++) {
            if (i + 1 == id) {
                fruitArr[i].decreaseStock(quan);
            }
        }
    }

//    Checks if there is stock available to make a order
    public boolean checkAvailability(int id, int quan) {
        return this.fruitArr[id - 1].getInventoryNum() >= quan;
    }
}
