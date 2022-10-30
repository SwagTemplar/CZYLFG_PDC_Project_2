package connor_kisoon_project_2;

/**
 *
 * @author kisoo
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
