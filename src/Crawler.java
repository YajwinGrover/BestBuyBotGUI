import com.jauntium.*;
import com.jauntium.Document;
import com.jauntium.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.regex.*;

public class Crawler {
    public static Browser browser;

    public static Browser set() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        browser = new Browser(new ChromeDriver());
        return browser;
    }

    public static Boolean inStock(String url) {
        browser.visit(url);
        Document doc = browser.doc;
        String button = "<button class=\"btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button\" type=\"button\"";
        try {
            doc.findFirst(button).click();
            System.out.println("Added to Cart");
            return true;
        } catch (NotFound e) {
            System.out.println("Item is out of stock.");
            return false;
        }
    }

    public static Boolean checkout(String email, String phone) throws NotFound {
        browser.visit("https://www.bestbuy.com/cart");
        Document doc = browser.doc;
        doc.findFirst("<button class=\"btn btn-lg btn-block btn-primary\" type=\"button\"").click();
        doc = browser.doc;
        System.out.println(doc.innerHTML());
        doc.findFirst("<button class=\"btn btn-secondary btn-lg cia-guest-content__continue guest\"").click();
        return true;
    }

    public static void main(String[] args) {
        Crawler.set();
        Crawler.inStock("https://www.bestbuy.com/site/apple-macbook-pro-13-display-with-touch-bar-intel-core-i5-8gb-memory-512gb-ssd-space-gray/6287720.p?skuId=6287720");
        try {
            Crawler.checkout("null", "null");
        } catch (NotFound e) {
            e.printStackTrace();
        }
    }
}
