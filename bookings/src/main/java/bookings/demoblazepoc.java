package bookings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class demoblazepoc {
    static WebDriver driver;
    static String username = "90demoapp234"; // Replace with a username generator if needed
    static String password = "90demoapp234"; // Replace with a password generator if needed

    public static void main(String[] args) {
       try {
            
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts();
            
            
            
           driver.manage().window().maximize();
            
           // ChromeOptions options = new ChromeOptions();
            //options.addArguments("start-maximized");

            // Initialize the WebDriver with ChromeOptions
           // WebDriver driver = new ChromeDriver(options);

           
            driver.get("https://www.demoblaze.com/");

            
            signup();
            login();
        } finally {
            // Close the browser
           if (driver != null) {
               driver.quit();
            }
        }}
        
    

    // Signup Function
    public static void signup() {
        try {
            
        	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(1000));
            WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='signin2']"))));
         //   WebElement signupButton = driver.findElement(By.xpath("//li[@class = 'nav-item'][7]"));
            Thread.sleep(2000);
           signupButton.click();
            Thread.sleep(2000);

            
            WebElement signupModal = driver.findElement(By.id("signInModalLabel"));
            if (signupModal.isDisplayed()) {
                System.out.println("Signup popup displayed.");
            } else {
                System.out.println("Signup popup not displayed.");
                return;
            }

      
            driver.findElement(By.id("sign-username")).clear();
            driver.findElement(By.id("sign-username")).sendKeys(username);
            driver.findElement(By.id("sign-password")).clear();
            driver.findElement(By.id("sign-password")).sendKeys(password);

            
            WebElement signupSubmit = driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Sign up']"));
            signupSubmit.click();

            
            Thread.sleep(2000); 
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            if (alertText.equals("This user already exist.")) {
                System.out.println("This user already exists. Try with a different username.");
                alert.accept();
                signup();
            } else if (alertText.equals("Sign up successful.")) {
                System.out.println("Successfully created user.");
                alert.accept();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: Element not found. " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Error: Loading took too much time! " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Login Function
    public static void login() {
        try {
            
            WebElement loginButton = driver.findElement(By.id("login2"));
            loginButton.click();
            Thread.sleep(2000);

           
            WebElement loginModal = driver.findElement(By.id("logInModalLabel"));
            if (loginModal.isDisplayed()) {
                System.out.println("Login popup displayed.");
            } else {
                System.out.println("Login popup not displayed.");
                return;
            }

            
            driver.findElement(By.id("loginusername")).clear();
            driver.findElement(By.id("loginusername")).sendKeys(username);
            driver.findElement(By.id("loginpassword")).clear();
            driver.findElement(By.id("loginpassword")).sendKeys(password);

            
            WebElement loginSubmit = driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Log in']"));
            loginSubmit.click();

            
            Thread.sleep(2000); 
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();

                if (alertText.equals("User does not exist.")) {
                    System.out.println("Invalid username and password. Try with valid credentials.");
                    alert.accept();
                    login();
                }
            } catch (Exception e) {
                System.out.println("Successfully logged in user: " + username);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: Element not found. " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Error: Loading took too much time! " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
     
    
}}

