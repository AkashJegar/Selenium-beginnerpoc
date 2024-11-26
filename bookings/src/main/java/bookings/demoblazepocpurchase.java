package bookings;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoblazepocpurchase {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/");
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(500));
		
		WebElement phonesSection = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Phones")));
        phonesSection.click();
        
        WebElement firstPhone = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hrefch")));
        firstPhone.click();
        
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
        addToCartButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Navigate to Cart
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cartLink.click();

        // Click on "Place Order" button
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
        placeOrderButton.click();

        // Fill out the form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("USA");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("card")).sendKeys("1234567812345678");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2024");

        // Click on "Purchase" button
        WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
        purchaseButton.click();

        // Print confirmation message
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert h2")));
        System.out.println("Order Confirmation: " + confirmationMessage.getText());

    } 
}
	        
	        
	     

	


