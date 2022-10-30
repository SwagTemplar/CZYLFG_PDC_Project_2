/**
 *
 * @author kisoo
 */
public class Item {
    private int itemID;
    private String itemName;
    private int quantityInStock;
    
    public Item(){
        
    }
    
    public Item(int itemID, String itemName, int quantityInStock){
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
    }
    
    public void increaseStock(int stock){
        this.quantityInStock += stock;
    }
    
    //Setters and Getters
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public void setQuantityInStock(int stock){
        this.quantityInStock = stock;
    }
    
    public int getItemID(){
        return this.itemID;
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public int getQuantityInStock(){
        return this.quantityInStock;
    }
}
