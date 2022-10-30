

import java.util.ArrayList;

/**
 *
 * @author Kisoon Park 18008173 & Connor Stewart 17982915
 */
public class OrderList {
    
    public ArrayList<Order> orderArr;
    
    public OrderList()
    {
        this.orderArr = new ArrayList<>();
    }
    
    public void add(Order order)
    {
        this.orderArr.add(order);
    }
    
}
