

import java.util.ArrayList;

/**
 *
 * @author kisoo
 */
public class OrderList {
    
    private ArrayList<Order> orderArr;
    
    public OrderList()
    {
        this.orderArr = new ArrayList<>();
    }
    
    public void add(Order order)
    {
        this.orderArr.add(order);
    }
    
}
