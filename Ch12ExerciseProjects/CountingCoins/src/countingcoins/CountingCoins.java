/********************************************************************
 * CountingCoins.java
 * Ben Davis
 * 
 * Customers pay in coins, so this program will find the total
 * number of each coin type and then add them all together. It has to
 * use an enum named Coin.
 ********************************************************************/
package countingcoins;

public enum CountingCoins {
    QUARTER (0.25),
    DIME (0.1),
    NICKEL (0.05),
    PENNY (0.01);
    
    // instance variables that store coin values.
    public final double value;
    
    private CountingCoins(double value) {
        this.value = value;
    }
    
    //***************************************************************
    
    public double getTotal(CountingCoins coin, int number){
        double total = this.value * number;
        return total;
    }
}
