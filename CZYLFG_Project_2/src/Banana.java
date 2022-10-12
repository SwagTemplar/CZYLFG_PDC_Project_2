

/**
 *
 * @author kisoo
 */
public class Banana extends Fruit {

    private final static String FRUITNAME = "Banana";
    private final static int FRUITID = 3;
    private int invNum;

    public Banana() {

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
