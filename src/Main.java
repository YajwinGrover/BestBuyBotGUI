import com.jauntium.NotFound;

/**
 * @author: Team Hack-o-bytes
 */
public class Main {
    /**
     *
     * @param args
     * This is the main method
     */
    public static void main(String[] args) {
        //This line creates the UI where we imput the code
        SwingMain ui = new SwingMain();
        //Crawler.set() makes it so that the browser chrome is opened and sets the browser to be scraped
        Crawler.set();
        while (!Crawler.inStock(ui.url)) { // Check if item is in checkout
            //
        }
        try {
            //We are going to input all the fields in the best buy prompt screen so that we can buy for them
            Crawler.checkout(ui.email, ui.phone, Long.toString(ui.cardNumber), Integer.toString(ui.exMonth), Integer.toString(ui.exYear), Integer.toString(ui.cvv), ui.Fname, ui.Lname, ui.address, null, ui.city, ui.state, Integer.toString(ui.zip), null);
        } catch (NotFound e) {
            System.out.println("Something went quite wrong.");
            e.printStackTrace();
        }
    }

}
