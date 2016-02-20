import java.util.Scanner;


/**
 *  This program runs a simple test
 *  of the CellPhone class.
 */

public class CellPhoneTest
{
   public static void main(String[] args)
   {
      String device;    // To hold a device
      String testMan;   // To hold a manufacturer
      String testMod;   // To hold a model number
      double testPrice; // To hold a price
      
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the device
      System.out.print("Enter the device (cellphone or tablet): ");
      device = keyboard.nextLine();
      
      // Get the manufacturer name.
      System.out.print("Enter the manufacturer: ");
      testMan = keyboard.nextLine();
      
      // Get the model number.
      System.out.print("Enter the model number: ");
      testMod = keyboard.nextLine();
      
      // Get the retail price.
      System.out.print("Enter the retail price: ");
      testPrice = keyboard.nextDouble();
      
      // Get the data from the device and display it.
      System.out.println();
      System.out.println("Here is the data that you provided:");
      System.out.println("Device: " + device);
      
      if(device == "cellphone")
      {
        // Create an instance of the CellPhone class,
        // passing the data that was entered as arguments
        // to the constructor.
        CellPhone phone = new CellPhone(testMan, testMod, testPrice); 
        System.out.println("Manufacturer: " + phone.getManufact());
        System.out.println("Model number: " + phone.getModel());
        System.out.println("Retail price: " + phone.getRetailPrice());
      }
      
      else
      {
        // Create an instance of the Tablet class,
        // passing the data that was entered as arguments
        // to the constructor.
        Tablet tab = new Tablet(testMan, testMod, testPrice);
        System.out.println("Manufacturer: " + tab.getManufact());
        System.out.println("Model number: " + tab.getModel());
        System.out.println("Retail price: " + tab.getRetailPrice());
      }  
   }
}