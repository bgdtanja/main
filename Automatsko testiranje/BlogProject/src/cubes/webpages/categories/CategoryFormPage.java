package cubes.webpages.categories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryFormPage {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
	@FindBy(name = "name")
	private WebElement weInputName;
	@FindBy(name = "description")
	private WebElement weInputDescription;
	@FindBy(xpath = "//*[text()='Save']")
	private WebElement weButtonSave;
	@FindBy(xpath = "//*[text()='Cancel']")
	private WebElement weButtonCancel;
	@FindBy(id = "name-error")
	private WebElement weErrorName;
	@FindBy(id = "description-error")
	private WebElement weErrorDescription;
	@FindBy(xpath = "//*[@name='name']/following-sibling::div/child::div")
	private WebElement weDivErrorName;
	@FindBy(xpath = "//*[@name='description']/following-sibling::div/child::div")
	private WebElement weDivErrorDescription;

	
	public CategoryFormPage(WebDriver driver, WebDriverWait driverWait) {
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
	
	public void clickOnSave() {
		weButtonSave.click();
	}
	
	public void clickOnCancel() {
		weButtonCancel.click();
	}
	
	public void inputStrigInName(String name) {
		weInputName.clear();
		weInputName.sendKeys(name);
	}
	
	public void inputStrigInDescription(String descritpion) {
		weInputDescription.clear();
		weInputDescription.sendKeys(descritpion);
	}
	
	public String getNameInputError() {
		return weErrorName.getText();
	}
	
	public String getDescriptionInputError() {
		return weErrorDescription.getText();
	}
	
	public String getDescriptionInputErrorFromDiv() {
		return weDivErrorDescription.getText();
	}
	
	public String getNameInputErrorFromDiv() {
		return weDivErrorName.getText();
	}
	
	public String getStringFromNameInput() {
		return weInputName.getAttribute("value");
	}
	
	public String getStringFromDescritpionInput() {
		return weInputDescription.getAttribute("value");
	}
	
}
