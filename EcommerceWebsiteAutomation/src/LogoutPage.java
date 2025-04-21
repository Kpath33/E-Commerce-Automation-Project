// Import necessary Selenium classes for browser automation
import org.openqa.selenium.By; // Provides methods to locate elements on a web page
import org.openqa.selenium.WebElement; // Interface for interacting with the browser
import org.openqa.selenium.chrome.ChromeDriver; // Represents elements on a web page

// Define the LogoutPage class to handle logout-related actions
public class LogoutPage {
    // Declare a ChromeDriver instance to interact with the browser
    ChromeDriver driver;

    // Define the URL of the inventory page (used to verify or navigate to the logout page)
    String url = "https://www.saucedemo.com/inventory.html";

    // Constructor to initialize the ChromeDriver instance
    public LogoutPage(ChromeDriver driver) {
        // Assign the passed driver instance to the class-level driver variable
        this.driver = driver;
    }

    // Method to navigate to the logout page
    public void navigateToLogoutPage() {
        // Check if the current URL is not the inventory page URL
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            // Navigate to the inventory page URL
            this.driver.get(this.url);
        }
    }

    // Method to perform the logout action
    public boolean PerformLogout() throws InterruptedException {
        // Locate the menu button by its ID and store it in a WebElement
        WebElement menu = this.driver.findElement(By.id("react-burger-menu-btn"));
        // Click the menu button to open the sidebar
        menu.click();

        // Pause execution for 1 second to allow the menu to load
        Thread.sleep(1000);

        // Locate the logout button by its ID and store it in a WebElement
        WebElement logoutBtn = this.driver.findElement(By.id("logout_sidebar_link"));
        // Click the logout button to log out of the application
        logoutBtn.click();

        // Return true to indicate the logout action was performed successfully
        return true;
    }
}