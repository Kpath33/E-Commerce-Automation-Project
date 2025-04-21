import java.util.List; // Import List for handling collections of elements
import org.openqa.selenium.By; // Provides methods to locate elements on a web page
import org.openqa.selenium.WebElement; // Represents elements on a web page
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for controlling the Chrome browser
import org.openqa.selenium.support.ui.Select; // Provides support for handling dropdowns

// Define the CheckoutPage class to handle checkout-related actions
public class CheckoutPage {
    // Declare a ChromeDriver instance to interact with the browser
    ChromeDriver driver;

    // Define the URL of the cart page
    String url = "https://www.saucedemo.com/cart.html";

    // Constructor to initialize the ChromeDriver instance
    public CheckoutPage(ChromeDriver driver) {
        // Assign the passed driver instance to the class-level driver variable
        this.driver = driver;
    }

    // Method to navigate to the cart page
    public void navigateToCartPage() {
        // Click on the shopping cart link to navigate to the cart page
        this.driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        // Check if the current URL is not the cart page URL
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            // Navigate to the cart page URL
            this.driver.get(this.url);
        }
    }

    // Method to perform the checkout functionality
    public Boolean PerformCheckoutFunctionality(String firstName, String lastName, String zipCode) throws InterruptedException {
        try {
            // Locate the checkout button by its ID and click it
            WebElement checkoutBtn = this.driver.findElement(By.id("checkout"));
            checkoutBtn.click();

            // Locate the first name input field by its ID and enter the provided first name
            WebElement firstName_TxtBox = this.driver.findElement(By.id("first-name"));
            firstName_TxtBox.sendKeys(firstName);

            // Locate the last name input field by its ID and enter the provided last name
            WebElement lastName_TxtBox = this.driver.findElement(By.id("last-name"));
            lastName_TxtBox.sendKeys(lastName);

            // Locate the zip code input field by its ID and enter the provided zip code
            WebElement zipCode_TxtBox = this.driver.findElement(By.id("postal-code"));
            zipCode_TxtBox.sendKeys(zipCode);

            // Pause execution for 1 second to allow the page to load
            Thread.sleep(1000);

            // Locate the continue button by its ID and click it
            WebElement continueBtn = this.driver.findElement(By.id("continue"));
            continueBtn.click();

            // Pause execution for 1 second to allow the page to load
            Thread.sleep(1000);

            // Locate the finish button by its ID and click it to complete the checkout
            WebElement finishBtn = this.driver.findElement(By.id("finish"));
            finishBtn.click();

            // Pause execution for 1 second to allow the page to load
            Thread.sleep(1000);

            // Locate the thank you message element by its XPath and get its text
            WebElement message = this.driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
            String textMsg = message.getText();

            // Check if the thank you message matches the expected text
            if (textMsg.equals("Thank you for your order!")) {
                return true; // Return true if the message matches
            }
            return false; // Return false if the message does not match
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        }
        return false; // Return false if an exception occurs
    }
}