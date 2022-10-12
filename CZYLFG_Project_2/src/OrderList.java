

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kisoo
 */
public class OrderList {

    private HashMap<Integer, int[]> readOrderList = new HashMap<>();
    private int orderID;

//    Outputs order data into a text file
    public void writeOrder(int id, int quan) {

        try {
            PrintStream printOut = new PrintStream(new FileOutputStream("./dbresources/current_orders.txt", true), true);
            String s = this.orderID + " " + String.valueOf(id) + " " + String.valueOf(quan);
            printOut.println(s);
            printOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    Takes the text file, reads it, populates a hashmap then returns said hashmap. It also sets the orderID depending on the size of the hashmap
    public void readOrder() {

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader("./dbresources/current_orders.txt"));
            String line;
            int thisOrdersID;
            int newArr[];

            while ((line = br.readLine()) != null) {
                newArr = new int[2];
                String[] arr = line.split(" ");
                thisOrdersID = Integer.parseInt(arr[0]);
                newArr[0] = Integer.parseInt(arr[1]);
                newArr[1] = Integer.parseInt(arr[2]);

                readOrderList.put(thisOrdersID, newArr);
            }

            br.close();
        } catch (IOException ex) {
            System.err.println("IOException Error: " + ex.getMessage());
        }

        orderID = readOrderList.size();
    }

//    Method to print orders within the hashmap
    public void printOrders() {
        for (Integer key : this.readOrderList.keySet()) {
            int[] value = this.readOrderList.get(key);
            System.out.println("Order ID: " + key + "\n"
                    + "Fruit ID: " + value[0] + "\n"
                    + "Number of Fruit Ordered: " + value[1] + "\n");
        }
    }
}
