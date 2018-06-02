/********************************************************************
 * CheckingWithInternalIntegers.java
 * Ben Davis
 * 
 * Copy of Ch6Checking.java with updates to remove doubles.
 ********************************************************************/
package checkingwithinternalintegers;
import java.util.Scanner;
public class CheckingWithInternalIntegers {
    Scanner stdIn = new Scanner(System.in);
    private int balance;         // Balance instance variable
    private int fee;             // Fee instance variable
    
    //*******************************************************
    
    public void setBalance(double balance) {
        this.balance = (int) (balance * 100);
    }   // end setBalance
    
    //*******************************************************
    
    public void setFee(double fee) {
        this.fee = (int) (fee * 100);
    }   // end setFee
    
    public int getBalance() {
        return this.balance;
    }   // end getBalance
    
    //*******************************************************
    
    public void withdrawal(double balance, double amount) {
        amount = amount * 100;
        balance -= (int) amount + this.fee;
        this.setBalance(balance / 100);
        System.out.printf("New balance: %,.2f\n", (double) balance / 100);
    }   // end withdrawal
    
    public void deposit(double balance, double amount) {
        amount = amount * 100;
        balance += (int) amount - this.fee;
        this.setBalance(balance / 100);
        System.out.printf("New balance: %,.2f\n", (double) balance / 100);
    }   // end deposit
}
