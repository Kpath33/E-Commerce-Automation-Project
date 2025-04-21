import java.util.List; // Import List for handling collections of elements
import org.openqa.selenium.By; // Provides methods to locate elements on a web page
import org.openqa.selenium.WebElement; // Represents elements on a web page
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for controlling the Chrome browser
import org.openqa.selenium.support.ui.Select; // Provides support for handling dropdowns

// Define the ApplyFilter class to handle filter-related actions
public class ApplyFilter {
    // Declare a ChromeDriver instance to interact with the browser
    ChromeDriver driver;

    // Define the URL of the inventory page
    String url = "https://www.saucedemo.com/inventory.html";

    // Constructor to initialize the ChromeDriver instance
    public ApplyFilter(ChromeDriver driver) {
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

    // Method to perform the filter action
    public Boolean PerformFilterAction() throws InterruptedException {
        // Locate the dropdown element for sorting products by its XPath
        WebElement dropdownElement = this.driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        // Create a Select object to interact with the dropdown
        Select dropdown = new Select(dropdownElement);
        // Select the "Price (low to high)" option from the dropdown
        dropdown.selectByVisibleText("Price (low to high)");

        // Pause execution for 1 second to allow the page to update
        Thread.sleep(1000);

        // Locate all product price elements on the page by their XPath
        List<WebElement> productPrice = this.driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        // Loop through the product prices to verify they are sorted in ascending order
        for (int i = 1; i < productPrice.size(); i++) {
            // Get the price of the current and previous products, remove the "$" symbol, and trim whitespace
            String price1 = productPrice.get(i - 1).getText().replace("$", "").trim();
            String price2 = productPrice.get(i).getText().replace("$", "").trim();

            // Convert the prices to numeric values for comparison
            double numericPrice1 = Double.parseDouble(price1);
            double numericPrice2 = Double.parseDouble(price2);

            // Compare the prices to check if they are in ascending order
            if (numericPrice1 > numericPrice2) {
                // If the prices are not in ascending order, return false
                return false;
            }
        }
        // Return true if all prices are in ascending order
        return true;
    }
}