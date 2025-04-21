// Import necessary Java and Selenium classes for browser automation
import java.util.List; // Import List for handling collections of elements
import org.openqa.selenium.By; // Provides methods to locate elements on a web page
import org.openqa.selenium.WebElement; // Represents elements on a web page
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for controlling the Chrome browser
import org.openqa.selenium.support.ui.Select; // Provides support for handling dropdowns (not used in this code)

// Define the AddToCart class to handle add-to-cart-related actions
public class AddToCart {
    // Declare a ChromeDriver instance to interact with the browser
    ChromeDriver driver;

    // Define the URL of the inventory page
    String url = "https://www.saucedemo.com/inventory.html";

    // Constructor to initialize the ChromeDriver instance
    public AddToCart(ChromeDriver driver) {
        // Assign the passed driver instance to the class-level driver variable
        this.driver = driver;
    }

    // Method to navigate to the home page
    public void navigateToHomePage() {
        // Check if the current URL is not the inventory page URL
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            // Navigate to the inventory page URL
            this.driver.get(this.url);
        }
    }

    // Method to perform the add-to-cart functionality
    public Boolean PerformAddToCartFunctionality(String targetProductName) throws InterruptedException {
        // Locate all product name elements on the page by their XPath
        List<WebElement> productNameElements = this.driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

        // Loop through the product name elements to find the target product
        for (WebElement productNameElement : productNameElements) {
            // Get the text of the current product name element
            String productName = productNameElement.getText();

            // Check if the product name matches the target product name
            if (productName.equals(targetProductName)) {
                // Locate the "Add to cart" button corresponding to the product
                List<WebElement> addButton = productNameElement.findElements(By.xpath("./parent::a/parent::div/following-sibling::div/button"));

                // Check if the "Add to cart" button is found
                if (!addButton.isEmpty()) {
                    // Click the "Add to cart" button to add the product to the cart
                    addButton.get(0).click();

                    // Return true to indicate the product was successfully added to the cart
                    return true;
                }
            }
        }

        // Return false if the target product was not found
        return false;
    }
}