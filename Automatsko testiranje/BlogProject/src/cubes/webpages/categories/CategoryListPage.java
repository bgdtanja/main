package cubes.webpages.categories;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryListPage {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement weAddnewCategory;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement weDialogDelete;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement weDialogCancel;
	
	public CategoryListPage(WebDriver driver, WebDriverWait driverWait) {
		super();
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver,this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}
	
	public void openLinkParentInMenu(String title) {
		WebElement weMenu = driver.findElement(By.xpath("//p[text()='"+title+"']//ancestor::li[2]"));
		
		if(!weMenu.getAttribute("class").toString().equalsIgnoreCase("nav-item has-treeview menu-open")) {
			weMenu.click();
		}
	}
	
	public void clickOnLinkInMenu(String title) {
		WebElement weLink = driver.findElement(By.xpath("//p[text()='"+title+"']"));
		driverWait.until(ExpectedConditions.visibilityOf(weLink));
		weLink.click();
	}
	
	public void clickOnNavigationLink(String title) {
		WebElement weLink = driver.findElement(By.xpath("//a[text()='"+title+"']"));
		weLink.click();
	}
	
	public void clickOnAddNewCategory() {
		weAddnewCategory.click();
	}

	public boolean isCategoryInList(String name) {

		ArrayList<WebElement> weCategories = (ArrayList<WebElement>) driver.findElements(By.xpath("//strong[text()='"+name+"']"));
		
		return !weCategories.isEmpty();
	}
	
	public void clickOnDeleteCategory(String name) {
		WebElement weDeleteButton  = driver.findElement(By.xpath("//strong[text()='"+name+"']//ancestor::tr//td[6]//button"));
		weDeleteButton.click();		
	}
	
	public void clickOnUpdateCategory(String name) {
		WebElement weUpdateButton  = driver.findElement(By.xpath("//strong[text()='"+name+"']//ancestor::tr//td[6]//a[2]"));
		weUpdateButton.click();		
	}

	public void clickOnDialogCancel() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogCancel));
		weDialogCancel.click();
	}
	
	public void clickOnDialogDelete() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogDelete));
		weDialogDelete.click();
	}
	
	
}
