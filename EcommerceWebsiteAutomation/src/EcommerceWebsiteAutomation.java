
// Import necessary packages for Selenium WebDriver and page object classes
import org.openqa.selenium.WebDriver; // Import Selenium WebDriver interface
import org.openqa.selenium.chrome.ChromeDriver; // Import Selenium ChromeDriver class for browser automation

public class EcommerceWebsiteAutomation { // Main class for automating e-commerce website tests

    // Method to create and return a ChromeDriver instance
    public static ChromeDriver createDriver() {
        return new ChromeDriver(); // Creates a new ChromeDriver instance
    }

    // Method to log the status of test cases
    public static void logStatus(String type, String message, String status) {
        // Logs the current timestamp, type, message, and status in a formatted string
        System.out.println(String.format("%s |  %s  |  %s | %s",
                String.valueOf(java.time.LocalDateTime.now()), type, message, status));
    }

    // Test Case 01: Verify Login functionality
    public static Boolean TestCase01(ChromeDriver driver) throws InterruptedException {
        Boolean status; // Variable to store the test case status
        logStatus("Start TestCase", "Test Case 1: Verify Login functionality", "DONE");

        LoginPage loginPage = new LoginPage(driver); // Create an instance of LoginPage
        loginPage.navigateToLoginPage(); // Navigate to the login page
        status = loginPage.PerformLogin("standard_user", "secret_sauce"); // Perform login with credentials

        if (!status) { // If login fails
            logStatus("End TestCase", "Test Case 1: Verify Login functionality : ", status ? "PASS" : "FAIL");
            return false; // Return false as the test case fails
        } else { // If login succeeds
            logStatus("TestCase 1", "Test Case Pass. Login functionality ", "PASS");
            return true; // Return true as the test case passes
        }
    }

    // Test Case 02: Verify filter functionality
    public static Boolean TestCase02(ChromeDriver driver) throws InterruptedException {
        Boolean status; // Variable to store the test case status
        logStatus("Start TestCase", "Test Case 02: Applying filter functionality", "DONE");

        ApplyFilter filter = new ApplyFilter(driver); // Create an instance of ApplyFilter
        filter.navigateToHomePage(); // Navigate to the home page
        status = filter.PerformFilterAction(); // Perform filter action

        if (!status) { // If filter action fails
            logStatus("End TestCase", "Test Case 2: Applying filter functionality : ", status ? "PASS" : "FAIL");
            return false; // Return false as the test case fails
        } else { // If filter action succeeds
            logStatus("TestCase 2", "Test Case Pass. Applying filter functionality ", "PASS");
            return true; // Return true as the test case passes
        }
    }

    // Test Case 03: Verify add-to-cart functionality
    public static Boolean TestCase03(ChromeDriver driver) throws InterruptedException {
        Boolean status; // Variable to store the test case status
        logStatus("Start TestCase", "Test Case 03: Add to cart functionality", "DONE");

        AddToCart cart = new AddToCart(driver); // Create an instance of AddToCart
        cart.navigateToHomePage(); // Navigate to the home page
        status = cart.PerformAddToCartFunctionality("Sauce Labs Onesie"); // Add first item to the cart
        status = cart.PerformAddToCartFunctionality("Sauce Labs Fleece Jacket"); // Add second item to the cart

        if (!status) { // If add-to-cart action fails
            logStatus("End TestCase", "Test Case 03: Add to cart functionality : ", status ? "PASS" : "FAIL");
            return false; // Return false as the test case fails
        } else { // If add-to-cart action succeeds
            logStatus("TestCase 3", "Test Case Pass. Add to cart functionality ", "PASS");
            return true; // Return true as the test case passes
        }
    }

    // Test Case 04: Verify checkout functionality
    public static Boolean TestCase04(ChromeDriver driver) throws InterruptedException {
        Boolean status; // Variable to store the test case status
        logStatus("Start TestCase", "Test Case 04: Checkout functionality", "DONE");

        CheckoutPage checkout = new CheckoutPage(driver); // Create an instance of CheckoutPage
        checkout.navigateToCartPage(); // Navigate to the cart page
        status = checkout.PerformCheckoutFunctionality("Chanchal", "Korsewada", "492222"); // Perform checkout with user details

        if (!status) { // If checkout action fails
            logStatus("End TestCase", "Test Case 04: CheckOut functionality : ", status ? "PASS" : "FAIL");
            return false; // Return false as the test case fails
        } else { // If checkout action succeeds
            logStatus("TestCase 3", "Test Case Pass.CheckOut functionality ", "PASS");
            return true; // Return true as the test case passes
        }
    }

    // Test Case 05: Verify logout functionality
    public static Boolean TestCase05(ChromeDriver driver) throws InterruptedException {
        Boolean status; // Variable to store the test case status
        logStatus("Start TestCase", "Test Case 05: Verify Logout functionality", "DONE");

        LogoutPage logoutPage = new LogoutPage(driver); // Create an instance of LogoutPage
        logoutPage.navigateToLogoutPage(); // Navigate to the logout page
        status = logoutPage.PerformLogout(); // Perform logout action

        if (!status) { // If logout action fails
            logStatus("End TestCase", "Test Case 5: Verify Logout functionality : ", status ? "PASS" : "FAIL");
            return false; // Return false as the test case fails
        } else { // If logout action succeeds
            logStatus("TestCase 5", "Test Case Pass. Logout functionality ", "PASS");
            return true; // Return true as the test case passes
        }
    }

    // Main method to execute all test cases
    public static void main(String[] args) throws Exception {
        Boolean status; // Variable to store the status of each test case
        ChromeDriver driver = createDriver(); // Create a ChromeDriver instance
        driver.manage().window().maximize(); // Maximize the browser window

        // Execute Test Case 01
        status = TestCase01(driver);
        System.out.println(status); // Print the status of Test Case 01

        // Execute Test Case 02
        status = TestCase02(driver);
        System.out.println(status); // Print the status of Test Case 02

        // Execute Test Case 03
        status = TestCase03(driver);
        System.out.println(status); // Print the status of Test Case 03

        // Execute Test Case 04
        status = TestCase04(driver);
        System.out.println(status); // Print the status of Test Case 04

        // Execute Test Case 05
        status = TestCase05(driver);
        System.out.println(status); // Print the status of Test Case 05

        driver.quit(); // Close the browser and end the WebDriver session
    }
}