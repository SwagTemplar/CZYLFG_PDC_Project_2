

/**
 *
 * @author kisoo
 */
abstract class Fruit {
    
    //abstract Methods
    abstract String getFruitName();
    abstract int getFruitID();
    abstract void setInventoryNum(int num); 
    abstract int getInventoryNum();
    abstract void decreaseStock(int num);
    abstract void increaseStock(int num);

}
