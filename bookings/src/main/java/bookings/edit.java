package bookings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class edit {

	public static void main(String[] args) {
		
WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://chorusqa.cogninelabs.com/");
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("i0116"))).sendKeys("akash.jegar@cognine.com");
		
		//driver.findElement(By.id("i0116")).sendKeys("akash.jegar@cognine.com");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idSIButton9"))).click();
		//driver.findElement(By.id("idSIButton9")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("passwd"))).sendKeys("Ak@asH^9148");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
		//driver.findElement(By.id("idSIButton9")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"4\"]"))).click();

		
		
		/*if(driver.getTitle().contains("Current Learnings")) {
			System.out.println("present"); 
		}else {
			System.out.println("not present");
		}
		*/
		
		WebElement IFrame = driver.findElement(By.xpath("//*[@id=\"undefined\"]"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFrame));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div/div/div/ul/li[1]/a"))).click();
		
        
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice"))).click();

	}

}
