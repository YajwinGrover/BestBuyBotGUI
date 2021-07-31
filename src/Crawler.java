import com.jauntium.*;
import com.jauntium.Document;
import com.jauntium.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.regex.*;

public class Crawler {
    public static Browser scrape(String url) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        Browser browser = new Browser(new ChromeDriver());
        browser.visit(url);
        return browser;
    }

    public static Boolean inStock(String url) {
        Browser browser = scrape(url);
        Document doc = browser.doc;
        WebDriver driver = browser.driver;
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

    public static void main(String[] args) {
        Crawler.inStock("https://www.bestbuy.com/site/nvidia-geforce-rtx-3090-24gb-gddr6x-pci-express-4-0-graphics-card-titanium-and-black/6429434.p?skuId=6429434");
    }
}
