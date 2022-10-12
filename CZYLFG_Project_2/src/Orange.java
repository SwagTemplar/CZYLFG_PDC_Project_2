

/**
 *
 * @author kisoo
 */
public class Orange extends Fruit {

    private final String FRUITNAME = "Orange";
    private final int FRUITID = 6;
    private int invNum;

    public Orange() {

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
