package bookings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class skillsetpage {

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
		
		WebElement IFrame = driver.findElement(By.xpath("//*[@id=\"undefined\"]"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFrame));
        
        Actions actions = new Actions(driver);
        
        System.out.println("Switched to iframe. Now locating 'Configuration' element...");
        
        

        
        WebElement configurationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@title='Configuration']")));
        System.out.println("Configuration element located. Performing actions...");

        
        actions.moveToElement(configurationElement).perform();

       

        
        WebElement Practicemenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Skillset")));
        
        Practicemenu.click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("updateOrUpdateSkillset"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("skillDialog-skillname"))).sendKeys("demo1");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SkillsetTypeDropdown_chosen\"]/a/span"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SkillsetTypeDropdown_chosen\"]/div/ul/li[2]"))).click();
    	
 
    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("skillsetDescription"))).sendKeys("Example 1");


    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("SaveData"))).click();
		

    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-text-box"))).sendKeys("demo1");
	}

}
