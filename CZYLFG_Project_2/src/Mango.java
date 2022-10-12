

/**
 *
 * @author kisoo
 */
public class Mango extends Fruit {

    private final static String FRUITNAME = "Mango";
    private final static int FRUITID = 5;
    private int invNum;

    public Mango() {

    }

    @Override
    String getFruitName() {
        return this.FRUITNAME;
    }

    @Override
    int getFruitID() {
        return this.FRUITID;
    }

    @Override
    void setInventoryNum(int num) {
        this.invNum = num;
    }

    @Override
    int getInventoryNum() {
        return this.invNum;
    }

    @Override
    void decreaseStock(int num) {
        this.invNum -= num;
    }

    @Override
    void increaseStock(int num) {
        this.invNum += num;
    }

}
