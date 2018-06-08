/*******************************************************************
 * Date.java
 * Ben Davis
 * 
 * This program takes the user input for the date and prints it in
 * alphabetic form. The Date.java class also performs validation on
 * user inputs.
 *******************************************************************/
package date;

public class Date {
    private int day, month;         // day and month
    private String error = "";      // error value
    private String[] months = {"January", "February", "March",
        "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};
    
    //***************************************************************
    
    public Date(String dateStr) {
        int index = dateStr.indexOf("/");
        if (index == -1) {
            error = "Make sure to separate dates with "
                    + "a slash (/)";
        }
        else {
            try {
                month = Integer.parseInt(dateStr.substring(0, index));
                if (month < 1 || month > 12) {
                    error = "Please enter a valid month";
                }
                else {
                    this.month = month;
                }
                day = Integer.parseInt(dateStr.substring(index + 1));
                if (day < 1) {
                    error = "Please enter a valid day";
                }
                else {
                    switch (month) {
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                            if (day > 31) {
                                error = "Invalid day " + day +
                                        " for month " + month;
                            }
                            else {
                                this.day = day;
                            }
                            break;
                        case 2:
                            if (day > 28) {
                                error = "Invalid day " + day +
                                        " for month " + month;
                            }
                            else {
                                this.day = day;
                            }
                            break;
                        case 4: case 6: case 9: case 11:
                            if (day > 30) {
                                error = "Invalid day " + day +
                                        " for month " + month;
                            }
                            else {
                                this.day = day;
                            }
                            break;
                    }
                }
            }
            catch (NumberFormatException e) {
                error = "Invalid format - " + 
                        e.getMessage();
            }
        }
        
    }
    
    //***************************************************************
    
    public void printResults() {
        System.out.printf("Date %02d/%02d is %s %d\n", this.month,
                this.day, months[(this.month - 1)], this.day);
    }
    
    //***************************************************************
    
    public String getError () {
        if (!error.isEmpty()){
            return error;
        }
        else {
            return null;
        }
    }
}
