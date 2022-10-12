

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is where we create the inventory. Take in text files and after all the
 * orders and stuff outputs a text file.
 *
 * @author kisoo
 */
public class Inventory {
    
    private HashMap<Integer, Integer> inventory = new HashMap<>();
    
//    Default constructor
    public void Inventory() {
        this.inventory = null;
    }
    
//    Returns the class hashmap
    public HashMap<Integer, Integer> getInventory()
    {
        return this.inventory;
    }
    
//    Reads the contents of the text file, arranges it into a hashmap, then stores it into the class variable hashmap.
    public void readInventory()
    {
        BufferedReader br;
        
        try 
        {
            br = new BufferedReader(new FileReader("./dbresources/current_inv.txt"));
            String line = "";
            int fruit_id;
            int value;
            
            while ((line = br.readLine()) != null) 
            {
               String[] arr = line.split(" ");
               fruit_id = Integer.parseInt(arr[0]);
               value = Integer.parseInt(arr[1]);
            
               this.inventory.put(fruit_id, value);
            }
            
            br.close();
        } 
        catch (IOException ex) 
        {
            System.err.println("IOException Error: " + ex.getMessage());
        }
    }
    
//    Updates the inventory text file
    public void updateInventory(HashMap<Integer, Integer> hmap)
    {
        File currentFile = new File("./dbresources/current_inv.txt");
        currentFile.delete();
        
        BufferedWriter bw;
        
        try {
           bw = new BufferedWriter(new FileWriter("./dbresources/current_inv.txt"));
           
           for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
 
                bw.write(entry.getKey() + " "+ entry.getValue());
                bw.newLine();
            }
           bw.flush();
        } 
        catch (IOException ex) 
        {
            System.err.println("IOException Error: " + ex.getMessage());
        }
    }
    
//    Prints the inventory
    public void printInv()
    {
        for (Integer id: this.inventory.keySet()) 
        {
            String key = id.toString();
            String value = this.inventory.get(id).toString();
            System.out.println(key + " " + value);
        }
    }
}
