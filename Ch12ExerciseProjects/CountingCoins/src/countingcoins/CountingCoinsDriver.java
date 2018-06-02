/**********************************************************************
 * CountingCoinsDriver.java
 * Ben Davis
 * 
 * This driver works for the CountingCoins.java enum class
 **********************************************************************/
package countingcoins;
import java.util.Scanner;
public class CountingCoinsDriver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int number;         // user-entered number of coins
        double total = 0.0;       // running total
        System.out.println("Chapter 12 Coins by Ben Davis\n");
        
        for (CountingCoins coin : CountingCoins.values()) {
            System.out.print("How many coins are a " + coin +
                    "? ");
            number = stdIn.nextInt();
            total += coin.getTotal(coin, number);
        }
        
        System.out.printf("Total worth of those coins is $%.2f", total);
        System.out.println();
    }
}
