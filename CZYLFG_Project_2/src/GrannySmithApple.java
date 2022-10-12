

/**
 *
 * @author kisoo
 */
public class GrannySmithApple extends Fruit {

    private final static String FRUITNAME = "Granny_Smith_Apple";
    private final static int FRUITID = 2;
    private int invNum;

    public GrannySmithApple() {

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
