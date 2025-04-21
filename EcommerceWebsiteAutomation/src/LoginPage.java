// Import necessary Selenium classes for browser automation
import org.openqa.selenium.By; // Provides methods to locate elements on a web page
import org.openqa.selenium.WebDriver; // Interface for interacting with the browser
import org.openqa.selenium.WebElement; // Represents elements on a web page
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for controlling the Chrome browser

// Define the LoginPage class to handle login-related actions
public class LoginPage {
    // Declare a ChromeDriver instance to interact with the browser
    ChromeDriver driver;

    // Define the URL of the login page
    String url = "https://www.saucedemo.com/";

    // Constructor to initialize the ChromeDriver instance
    public LoginPage(ChromeDriver driver) {
        // Assign the passed driver instance to the class-level driver variable
        this.driver = driver;
    }

    // Method to navigate to the login page
    public void navigateToLoginPage() {
        // Check if the current URL is not the login page URL
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            // Navigate to the login page URL
            this.driver.get(this.url);
        }
    }

    // Method to perform the login action
    public boolean PerformLogin(String Username, String Password) throws InterruptedException {
        // Locate the username input field by its ID and store it in a WebElement
        WebElement userName = this.driver.findElement(By.id("user-name"));
        // Enter the provided username into the username input field
        userName.sendKeys(Username);

        // Locate the password input field by its ID and store it in a WebElement
        WebElement passWord = this.driver.findElement(By.id("password"));
        // Enter the provided password into the password input field
        passWord.sendKeys(Password);

        // Locate the login button by its ID and store it in a WebElement
        WebElement loginBtn = this.driver.findElement(By.id("login-button"));
        // Click the login button to submit the login form
        loginBtn.click();

        // Return true to indicate the login action was performed
        return true;
    }
}