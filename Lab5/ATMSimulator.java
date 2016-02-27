/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulator;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
   A text-based simulation of an automatic teller machine.
*/
public class ATMSimulator
{  
   public static void main(String[] args)
   {  
      ATM theATM;
      try
      {  
         Bank theBank = new Bank();
         theBank.readCustomers("customers.txt");
         theATM = new ATM(theBank);
      }
      catch(IOException e)
      {  
         System.out.println("Error opening accounts file.");
         return;
      }

      Scanner in = new Scanner(System.in);

      while (true)
      {
         int state = theATM.getState();
         if (state == ATM.START)
         {
            try {
                System.out.print("Enter customer number: ");
                int number = in.nextInt();
                theATM.setCustomerNumber(number); 
            } 
            
            catch (InputMismatchException e) {
                System.out.println("Invalid customer number!");
                return;
            }           
         }
         else if (state == ATM.PIN)
         {
             try {
                System.out.print("Enter PIN: ");
                int pin = in.nextInt();
                theATM.selectCustomer(pin); 
             }
            catch (InputMismatchException e) {
                System.out.println("Invalid PIN!");
            } 

         }
         else if (state == ATM.ACCOUNT)
         {
            System.out.print("A=Checking, B=Savings, C=Quit: ");
            String command = in.next();
            if (command.equalsIgnoreCase("A"))
               theATM.selectAccount(ATM.CHECKING);
            else if (command.equalsIgnoreCase("B"))
               theATM.selectAccount(ATM.SAVINGS);
            else if (command.equalsIgnoreCase("C"))
               theATM.reset();
            else
               System.out.println("Illegal input!");                        
         }
         else if (state == ATM.TRANSACT)
         {
            System.out.println("Balance=" + theATM.getBalance());
            System.out.print("A=Deposit, B=Withdrawal, C=Cancel: ");
            String command = in.next();
            if (command.equalsIgnoreCase("A"))
            {
                try {
                    System.out.print("Amount: ");
                    double amount = in.nextDouble();
                    theATM.deposit(amount);
                    theATM.back();
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid amount!");
                    return;
                }

            }
            else if (command.equalsIgnoreCase("B"))
            {
                try {
                    System.out.print("Amount: ");
                    double amount = in.nextDouble();
                    theATM.withdraw(amount);
                    theATM.back();
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid amount!");
                }
            }
            else if (command.equalsIgnoreCase("C"))
               theATM.back();
            else
               System.out.println("Illegal input!");                                    
         }         
      }
   }
}
