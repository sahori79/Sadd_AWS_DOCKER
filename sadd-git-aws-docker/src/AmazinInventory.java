/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Saddam-Hossain
 */
public class AmazinInventory {

    static Item[] itemArray;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        takeItemInfo();
        takeAction();
    }

    private static void takeAction() {
        int selection=Integer.valueOf(takeActioninfo());
         switch(selection){
         case(1):printReport();
         case(2):changeItem();
         case(3):exit();
         }          
    }

    private static void takeItemInfo() {
        int numberOfItems=Integer.valueOf(JOptionPane.showInputDialog("How many items ? "));
        System.out.println("How many Items? "+numberOfItems);
        itemArray= new Item[numberOfItems];
        for(int i=0; i<itemArray.length;i++){
            System.out.println("Item "+i+"'s Values...");
            showDialog();
            String name=JOptionPane.showInputDialog("What is Item "+i+"'s Name?");
            System.out.println("Name: "+name);
            String catagory=JOptionPane.showInputDialog("What is Item "+i+"'s Catagory?");
            System.out.println("Catagory: "+catagory);
            Double price=Double.valueOf(JOptionPane.showInputDialog("What is Item "+i+"'s Price?"));
            System.out.println("Price: "+price);
            int quantity=Integer.valueOf(JOptionPane.showInputDialog("What is Item "+i+"'s Quantity?"));
            System.out.println("Quantity: "+quantity);
            Item item=new Item(name, catagory, price,price,true, quantity);
            itemArray[i]=item;
        }
        System.out.println("--------------------------------------");
    }

    private static String takeActioninfo() {
        String msg1="What would you like to do?"+"\n";
        String msg2="1. Print report"+"\n";
        String msg3="2. Change item"+"\n";
        String msg4="3. Exit"+"\n";
        String selection=JOptionPane.showInputDialog(msg1+msg2+msg3+msg4);
        System.out.println(msg1+msg2+msg3+msg4+"Enter Selection: "+selection);
        return selection;
    }

    private static void printReport() {
        System.out.println("Current inventory is as follows:");
        for(int i=0;i<itemArray.length;i++){
            String itemInfo="Item ID: "+itemArray[i].getName()+", Name: "+itemArray[i].getName()+", Category: "+itemArray[i].getCategory()+", Price: "+itemArray[i].getPrice()+", Quantity: "+itemArray[i].getQuantity();
            System.out.println(itemInfo);
        }
        takeAction();
    }

    private static void changeItem() {
        int i=Integer.valueOf(JOptionPane.showInputDialog("Which item to Modify? "))-1;
        System.out.println("Which item ID to Modify? "+i);
        String itemInfo="Item ID: "+i+", Name: "+itemArray[i].getName()+", Category: "+itemArray[i].getCategory()+", Price: "+itemArray[i].getPrice()+", Quantity: "+itemArray[i].getQuantity();
        System.out.println("Item to modify is "+itemInfo);
        String msg="Which attribute to Modify (1. name 2. catagory 3. price 4. quantity) ?";
        int n=Integer.valueOf(JOptionPane.showInputDialog(msg));
        System.out.println(msg+ " "+n);
        
        String msg1="What is the new value? ";
        if(n==1){ 
            String v2=JOptionPane.showInputDialog(msg1);
            System.out.println(msg1+ " "+v2);
            itemArray[i].setName(v2);
        }
        if(n==2){ 
            String v2=JOptionPane.showInputDialog(msg1);
            System.out.println(msg1+ " "+v2);
            itemArray[i].setCategory(v2);
        }
        if(n==3){
            Double v2=Double.valueOf(JOptionPane.showInputDialog(msg1));
            itemArray[i].setPrice(v2);
            System.out.println(msg1+ " "+v2);
        }
        if(n==4){ 
            Integer v2=Integer.valueOf(JOptionPane.showInputDialog(msg1));
            itemArray[i].setQuantity(v2);
        }  
        String newitemInfo="Item ID: "+itemArray[i].getName()+", Name: "+itemArray[i].getName()+", Category: "+itemArray[i].getCategory()+", Price: "+itemArray[i].getPrice()+", Quantity: "+itemArray[i].getQuantity();
        System.out.println("The new values are "+newitemInfo);    
        
        takeAction();
    }

    private static void exit() {
        System.out.println("Closing the Application");
        System.exit(0);
    }

    private static void showDialog() {
        JFrame j=new JFrame();
          j.setAlwaysOnTop(true);
    }
    
}
