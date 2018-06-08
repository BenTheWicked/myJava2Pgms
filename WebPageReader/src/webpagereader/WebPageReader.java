/********************************************************************
 * WebPageReader.java
 * Dean & Dean
 * 
 * This reads a web page. (pg. 716)
 ********************************************************************/
package webpagereader;
import java.util.Scanner;
import java.net.*;                  // URL, URLConnection
import java.io.InputStream;
public class WebPageReader {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Scanner webIn;
        URL url;
        URLConnection connection;
        InputStream inStream;       // stream of bytes
        int i = 0, maxI;            // line number and max line number
        
        try {
            System.out.print("Enter a full URL address: ");
            url = new URL(stdIn.nextLine());
            connection = url.openConnection();
            inStream = connection.getInputStream();
            webIn = new Scanner(inStream);
            System.out.print("Enter number of lines: ");
            maxI = stdIn.nextInt();
            while (i < maxI && webIn.hasNext()) {
                System.out.println(webIn.nextLine());
                i++;
            }
        }   // end try
        catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }   // end main
    
}   // end WebPageReader
