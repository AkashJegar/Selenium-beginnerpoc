package bookings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practicemanagement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://chorusqa.cogninelabs.com/");
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(500));
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
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div/div/div/ul/li[1]/a"))).click();
		
        
        //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice"))).click();
        
        Actions actions = new Actions(driver);
        
        System.out.println("Switched to iframe. Now locating 'Configuration' element...");
        
        

        
        WebElement configurationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@title='Configuration']")));
        System.out.println("Configuration element located. Performing actions...");

        
        actions.moveToElement(configurationElement).perform();

       

        
        WebElement Practicemenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice")));
        
        Practicemenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addOrUpdatePractice\"]"))).click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PracticeName\"]"))).sendKeys("demo78");
       

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PracticeHeadsDropDown_chosen\"]/ul/li/input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PracticeHeadsDropDown_chosen\"]/div/ul/li[3]"))).click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.name("PracticeManagementEmail"))).sendKeys("aakash.jegar@cognine.com");
        //driver.findElement(By.name("PracticeManagementEmail")).sendKeys("akash.jegar@cognine.com");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("PracticeGroupEmail"))).sendKeys("akash.jegar@cognine.com");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"EditModal\"]/div/div/div[4]/div[1]/label"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SaveData\"]"))).click();
        
        
        try{
        	
        	WebElement Toaster =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [ contains(text() , 'Practice added successfully')]")));
        	
        	System.out.println("Toaster message: " + Toaster.getText());       
        	} catch (WebDriverException e) 
        
        {           
        		
        		System.out.println("Toaster message not found or could not be retrieved.");
        		
        		e.printStackTrace(); 
        		
        } 
        		 
        

        Thread.sleep(1000);
		
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class = 'bi bi-pencil-fill'])[1]"))).click();
        Thread.sleep(3000);
		
        try {
        WebElement editpractice =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='PracticeManagementEmail']")));
		editpractice.clear();
		editpractice.sendKeys("akash@cognine.com");
        } catch (Exception e) {
            System.out.println("Unable to interact with PracticeManagementEmail field.");
            e.printStackTrace();
        }
		
		
		driver.findElement(By.xpath("//*[@id=\"EditModal\"]/div/div/div[4]/div[1]/label")).click();
		
		 WebElement Practicesave = driver.findElement(By.xpath("//button[@id='SaveData']"));
		 Practicesave.click();
		 Thread.sleep(3000);
		 try{
	        	
	        	WebElement Toaster =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [ contains(text() , 'Practice modified successfully')]")));
	        	
	        	System.out.println("Toaster message: " + Toaster.getText());       
	        	} catch (WebDriverException e) 
	        
	        {           
	        		
	        		System.out.println("Toaster message not found or could not be retrieved.");
	        		
	        		e.printStackTrace(); 
	        		
	        } 
		
	 
			

	

		 Thread.sleep(3000);
	
	driver.findElement(By.xpath("//i[@class=\"bi bi-trash-fill\"]")).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i [@class=\"bi bi-check2\"]"))).click();
	Thread.sleep(3000);
	 try{
     	
     	WebElement Toaster =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [ contains(text() , 'Practice deleted successfully')]")));
     	
     	System.out.println("Toaster message: " + Toaster.getText());       
     	} catch (WebDriverException e) 
     
     {           
     		
     		System.out.println("Toaster message not found or could not be retrieved.");
     		
     		e.printStackTrace(); 
     		
     } 
	
	
}

}

	


