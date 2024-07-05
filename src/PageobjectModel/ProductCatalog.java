package PageobjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents
{
	WebDriver driver;
	
	////creating live driver from Standalone.java program code and below cod eis executed first always
	public ProductCatalog(WebDriver driver)
	{
		//initialising the driver to locate elements
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//// code executed alwarys first end
	
	////page factory start to locate elements wthout any actions
	
	@FindBy(css =".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMesg = By.cssSelector("#toast-container");
			
	public List<WebElement> getProductList()
	{ 
		waitForElementToAppear(productsBy);
		return products;
		
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
		
	public void addProductToCart(String productname)
	{
		WebElement prod= getProductByName(productname);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMesg);
		waitForElementToDisappear(spinner);
	}
	
	
	//// page factory start to locate elements wthout any actionsend
	
	////actions on elements are done by passing value from the testcase or StandAlone code.POM will nnt use hardcoded data
	////POM just tarnverse the data provided in test script without keeping data
	
}

	
	
	
	

