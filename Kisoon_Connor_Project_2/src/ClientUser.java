

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class ClientUser extends User{
    
    private OrderList orderList;
    
    public ClientUser()
    {
        this.orderList = new OrderList();
    }
    
    public void setOrderList(OrderList ol){
        this.orderList = ol;
    }
    
    public OrderList getOrderList(){
        return this.orderList;
    }
    
}
