

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class Order {
    //Variables
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
    // Getters
    public int getOrderID()
    {
        return this.orderID;
    }
    public int getfruitID()
    {
        return this.fruitID;
    }
    public int getOrderQuant()
    {
        return this.orderQuant;
    }
    public int getUserID()
    {
        return this.userID;
    }
}
