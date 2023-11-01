package cubes.webpages.tags;


import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagFormPage {
	
	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add";
	//WebElements
	@FindBy(name="name")
	private WebElement weTagName;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement weButtonSave;
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement weButtonCancel;
	@FindBy(xpath = "//i[@class='far fa-user']")
	private WebElement weButtonProfile;

	
	
	public TagFormPage(WebDriver driver,WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void addNewTag(String tagName) {
		weTagName.sendKeys(tagName);
		weButtonSave.click();
	}
	
	public String addNewRandomTag() {
		Random random = new Random();
		String tagName = "Tag "+random.nextInt(1000);
		weTagName.sendKeys(tagName);
		weButtonSave.click();
		return tagName;
	}
	
	public void checkMenuLink(String title,String url) {
		WebElement weMenu = driver.findElement(By.xpath("//p[text()='"+title+"']//ancestor::li[2]"));
		
		if(!weMenu.getAttribute("class").toString().equalsIgnoreCase("nav-item has-treeview menu-open")) {
			weMenu.click();
		}
		
		WebElement weLink = driver.findElement(By.xpath("//p[text()='"+title+"']"));
		driverWait.until(ExpectedConditions.visibilityOf(weLink));
		weLink.click();
		
		assertEquals(driver.getCurrentUrl(), url,"Bad url for "+title);
		
		driver.get(PAGE_URL);
	}
	
	public void checkNavigationLink(String title, String url) {
		WebElement weLink = driver.findElement(By.xpath("//a[text()='"+title+"']"));
		weLink.click();
		
		assertEquals(driver.getCurrentUrl(), url,"Bad url for "+title);

		driver.get(PAGE_URL);
	}
	
	public void inputTagString(String tagName) {
		weTagName.clear();
		weTagName.sendKeys(tagName);
	}
	
	public String getTagString() {
		return weTagName.getAttribute("value");
	}
	
	public void clickSave() {
		weButtonSave.click();
	}
	
	public void clickCancel() {
		weButtonCancel.click();
	}
	
	public void clickProfile() {
		weButtonProfile.click();
	}
	
	public void clickLogout() {
		driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt']"))));
		driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt']")).click();
	}

	public String getErrorMessage() {
		WebElement we = driver.findElement(By.id("name-error"));
		return we.getText();
	}
	
	public String getErrorMessage(String error) {
		WebElement we = driver.findElement(By.xpath("//div[text()='"+error+"']"));
		return we.getText();
	}
	
	public void openPage() {
		driver.get(PAGE_URL);
	}
	
}
