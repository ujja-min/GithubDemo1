package PageobjectModel;
	import java.time.Duration;
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	public class StandAlone 
	{
		WebElement tes;
		WebDriver driver;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		StandAlone()
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("start-maximized");
					driver=new ChromeDriver();
			// to use implictwait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		LoginlandingPage loginpage= new LoginlandingPage(driver);
		public void geturl() throws InterruptedException 
		{
			 
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
			  System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver-win64\\chromedriver.exe" );
			 
			  //Exceute with POM
			  loginpage.
			  
			  //Execute without POM
//			  driver.navigate().to("https://rahulshettyacademy.com/client");
				driver.manage().window().maximize();
				Thread.sleep(2000);		
		}
		
		public void Login()
		{
			//execute using POM as below
			LoginlandingPage loginpage= new LoginlandingPage(driver);
			loginpage.LoginPageActions("sample134@gmail.com", "Wyse#123");
			
			
//			below lines are written only for normal execution
//			driver.findElement(By.id("userEmail")).sendKeys("sample134@gmail.com");
//			driver.findElement(By.id("userPassword")).sendKeys("Wyse#123");
//			driver.findElement(By.id("login")).click();
			
			
		}
		public void SelectProduct() throws InterruptedException
		{
			String productName="ZARA COAT 3";
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			
			//to find the list of all product present on webpage with ".mb-3" classname
			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			//to select product sepecifically among list with condition and cross verify
			WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			//driver.wait(2000);
			//to verify the toast message dispalyed when product added to cart
			//WebDriverWait wait = new WebDriverWait(driver, null, null);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		}
		//@SuppressWarnings("deprecation")
		public void CartDetails() throws InterruptedException
		{
			@SuppressWarnings("unused")
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			String productName="ZARA COAT 3";
			List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
			Boolean  match =  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(match);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.findElement(By.cssSelector(".totalRow button")).click();
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Checkout']")));
//			//driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait = WebDriverWait(driver, 30);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Checkout']")).click();
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		
		}
			
		private WebDriverWait WebDriverWait(WebDriver driver2, int i) 
		{
			// TODO Auto-generated method stub
			return null;
		}

		public void CheckoutDetails() throws InterruptedException
		{
			Actions a= new Actions(driver);
			driver.wait(3000);
			a.sendKeys(driver.findElement(By.xpath("//input[@class='input txt text-validated' and @placeholder='Select Country']")),"India").build().perform();
			try {
			driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[1]/form/div/div[2]/div[2]/input")).sendKeys("123");
			}
			 catch (org.openqa.selenium.NoSuchElementException exp){
		            System.out.println("Excpetion was handled!");
		        }
		        
		        //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
			driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		//driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).clear();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String ConfirMsg = driver.findElement(By.cssSelector("hero-primary")).getText();
		Assert.assertEquals(ConfirMsg,"Thankyou for the order");
		Assert.assertTrue(ConfirMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
		driver.close();
		
		}
		public static void main(String[] args) throws Throwable
		{
			StandAlone sa =new StandAlone();
			
			sa.geturl();
			sa.Login();
			sa.SelectProduct();
			sa.CartDetails();
			sa.CheckoutDetails();
		}
		
	}
		


