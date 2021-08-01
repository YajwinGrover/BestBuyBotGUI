import com.jauntium.NotFound;

public class Main {
    public static void main(String[] args) {
        SwingMain ui = new SwingMain();
        Crawler.set();
        while (!Crawler.inStock(ui.url)) { // Check if item is in checkout
            ;
        }
        try {
            Crawler.checkout(ui.email, ui.phone, Long.toString(ui.cardNumber), Integer.toString(ui.exMonth), Integer.toString(ui.exYear), Integer.toString(ui.cvv), ui.Fname, ui.Lname, ui.address, null, ui.city, ui.state, Integer.toString(ui.zip), null);
        } catch (NotFound e) {
            System.out.println("Something went quite wrong.");
            e.printStackTrace();
        }
    }

}
