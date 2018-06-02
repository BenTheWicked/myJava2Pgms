/*******************************************************************
 * DayTrader.java
 * Dean & Dean
 * 
 * This simulates stock market day trading. (pg 540)
 *******************************************************************/
package daytrader.java;

public class DayTraderJava {

    public static void main(String[] args) {
        double balance = 1000.00;   // money that's retained
        double moneyInvested;       // money that's invested
        double moneyReturned;       // money that's earned at end of day
        int day;                    // current day, ranges from 1 to 90
        
        for (day=1; day<=90 && !(balance < 1.0 || balance > 5000.0); day++) {
            /*
            This break statement is unnecessary, if we update
            the header.
            if (balance < 1.0 || balance > 5000.0) {
                break;
            }
            */
            balance = moneyInvested = balance / 2.0;
            moneyReturned = moneyInvested * (Math.random() * 2.0);
            balance += moneyReturned;
        }   // end for
        
        System.out.printf("final balance on day %d: $%4.2f\n",
                (day - 1), balance);
    }   // end main
    
}   // end DayTrader
