

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kisoo
 */
public class CZYLFG_Project {
    
    public static void main(String[] args) {
        System.out.println("Welcome to the CZYLFG inventory management system!\n");

//        Initialize the hashmap and array objects
        FruitList fruitList = new FruitList();
        Inventory fruitInv = new Inventory();
        OrderList orderList = new OrderList();

//        Initialize the scanner
        Scanner scan = new Scanner(System.in);

        boolean loop = true;
        while (loop) {

//            read in the inventory from the text file
            fruitInv.readInventory();

//            Get the inventory hashmap
            HashMap<Integer, Integer> inv = fruitInv.getInventory();

//            populate the fruitlist inventory level according to the inventory hashmap
            fruitList.populateFruitList(inv);

            System.out.println("What do you want to do?\n");
            System.out.println("A: Check our inventory levels!");
            System.out.println("B: Pending Orders");
            System.out.println("C: Create Order");
            System.out.println("D: Exit");

            Character menuInput = scan.next().charAt(0);

            switch (Character.toLowerCase(menuInput)) {
                case 'a':
//                    Print out the remainging inventory 
                    fruitList.printList();
                    break;

                case 'b':
//                    Read order to update the hashmap
                    orderList.readOrder();
//                    before printing the said hashmap
                    orderList.printOrders();
                    break;

                case 'c':
//                    Read order to update the orderID;
                    orderList.readOrder();

                    System.out.println("Fruit IDs:");
                    System.out.println("1: Gala Apple");
                    System.out.println("2: Granny Smith Apple");
                    System.out.println("3: Banana");
                    System.out.println("4: Watermelon");
                    System.out.println("5: Mango");
                    System.out.println("6: Orange");

//                    Initialize order variables
                    int id;
                    int quan;

                    System.out.println("Enter the fruit ID you want to order");
                    
//                    Handle non number inputs
                    try {
                        id = scan.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Entered value is not a number");
//                        Clear scanner for next input
                        scan.next();
                        continue;
                    }

//                    If the input is out of bounds
                    while (id > 6 || id < 1) {
                        System.out.println("Invalid Input. Please try again.");
                        id = scan.nextInt();
                    }

                    System.out.println("Enter the quantity you want to order");
                    quan = scan.nextInt();

//                    Handle stock availability
                    if (fruitList.checkAvailability(id, quan) == false) {
                        System.out.println("Not Enough Stock Available\n");
                    } else {

                        fruitList.decreaseFruitNum(id, quan);
                        inv.replace(id, fruitList.getInvNumAtID(id));
                        fruitInv.updateInventory(inv);
                        orderList.writeOrder(id, quan);
                    }

                    break;

                case 'd':
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }
        scan.close();

    }
}
