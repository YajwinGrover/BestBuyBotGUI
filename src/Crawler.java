import com.jauntium.*;
import com.jauntium.Document;
import com.jauntium.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.*;

/**
 * This is the class that crawls throught the website using the
 * jauntium and selenium libraries
 */
public class Crawler {

    public static Browser browser;
    public static WebDriverWait w;
    //Makes the system scrape and open chrome
    public static Browser set() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        browser = new Browser(new ChromeDriver());
        w = new WebDriverWait(browser.driver, 15);
        return browser;
    }
    //This scrapes the page looking for the words Item is out of stock
    //If not then we click the buy button
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
    //This takes fills in all the text fields in the checkout area
    //So that you can buy the item and it will be shipped to the address you specified
    public static Boolean checkout(String email, String phone, String cccard, String mm, String yyyy, String cvv, String fnu, String lnu, String house, String apt, String city, String state, String zip, String pwd) throws NotFound {
        browser.visit("https://www.bestbuy.com/cart");
        Document doc = browser.doc;
        ((JavascriptExecutor)browser.driver).executeScript("arguments[0].click();", browser.driver.findElement(By.className("btn-primary")));
        browser.visit("https://www.bestbuy.com/identity/signin?token=tid%3A47f5d7c2-f263-11eb-90ae-005056ae2547");
        doc = browser.doc;
        ((JavascriptExecutor)browser.driver).executeScript("arguments[0].click();", browser.driver.findElement(By.className("cia-guest-content__continue")));
        browser.visit("https://www.bestbuy.com/checkout/r/fulfillment");
        doc = browser.doc;
        doc.findFirst("<input id=\"user.emailAddress\"").setAttribute("value", email);
        doc.findFirst("<input id=\"user.phone\"").setAttribute("value", phone);
        ((JavascriptExecutor)browser.driver).executeScript("arguments[0].click();", browser.driver.findElement(By.className("btn-secondary")));
        browser.visit("https://www.bestbuy.com/checkout/r/payment");
        doc = browser.doc;
        System.out.println(browser.getLocation());
        doc.findFirst("<input id=\"optimized-cc-card-number\" type=\"tel\" maxlength=\"19\"").setAttribute("value", cccard);
        doc.findFirst("<option value=\"" + mm + "\"").setAttribute("selected", "");
        doc.findFirst("<option value=\"" + yyyy + "\"").setAttribute("selected", "");
        doc.findFirst("<input type=\"tel\" maxlength=\"3\" id=\"credit-card-cvv\"").setAttribute("value", cvv);
        doc.findFirst("<input id=\"payment.billingAddress.firstName\"").setAttribute("value", fnu);
        doc.findFirst("<input id=\"payment.billingAddress.lastName\"").setAttribute("value", lnu);
        doc.findFirst("<input id=\"payment.billingAddress.street\"").setAttribute("value", house);
        if (apt != null) {
            doc.findFirst("<button class=\"c-button c-button-link btn btn-link v-medium c-button-md address-form__showAddress2Link\" type=\"button\"").click();
            doc.findFirst("<input id=\"payment.billingAddress.street2\"").setAttribute("value", house);
        }
        doc.findFirst("<input id=\"payment.billingAddress.city\"").setAttribute("value", city);
        doc.findFirst("<option value=\"" + state + "\"").setAttribute("selected", "");
        doc.findFirst("<input id=\"payment.billingAddress.zipcode\"").setAttribute("value", zip);
        if (pwd != null) {
            doc.findFirst("<input id=\"payment.billingAddress.city\"").setAttribute("value", city);
        }
        doc.findFirst("<input id=\"create-account-password-form-show-password\" type=\"password\" name=\"password\"").setAttribute("value", pwd);
        Elements random = doc.findEach("<button class=\"item-list__action\"");
        for (Element e : random) {
            e.click();
        }
        doc.findFirst("<button class=\"btn btn-lg btn-block btn-primary\"").click();
        return true;
    }
    //Testing method
    public static void main(String[] args) {
        // Testing
        Crawler.set();
        Crawler.inStock("https://www.bestbuy.com/site/apple-macbook-pro-13-display-with-touch-bar-intel-core-i5-8gb-memory-512gb-ssd-space-gray/6287720.p?skuId=6287720");
        try {
            Crawler.checkout("brainyprobotics@gmail.com", "8009378850", "5330828572141004", "08", "2026", "536", "FNU", "GNU LNU", "4770 Krzyzewski Eee Aaa Ooo Street", "Apartment #7-5800", "Rocket Lake", "HI", "95014", "boerWar4012!$&#");
        } catch (NotFound e) {
            e.printStackTrace();
        }
    }
}
