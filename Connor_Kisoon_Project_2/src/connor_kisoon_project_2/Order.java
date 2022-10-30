package connor_kisoon_project_2;

/**
 *
 * @author kisoo
 */
public class Order {
    private int orderID;
    private int fruitID;
    private int orderQuant;
    private int userID;
    
    public Order(int orderID, int fruitID, int orderQuant, int userID){
        this.orderID = orderID;
        this.fruitID = fruitID;
        this.orderQuant = orderQuant;
        this.userID = userID;
    }
    
    public int getOrderID()
    {
        return this.orderID;
    }
    public int getfruitID()
    {
        return this.fruitID;
    }
    public int getorderQuant()
    {
        return this.orderQuant;
    }
    public int getuserID()
    {
        return this.userID;
    }
}
