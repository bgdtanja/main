package cubes.webpages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPage {
	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add";
	

	@FindBy(css = ".brand-text")
	private WebElement weBlog;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//a[@href='#']/p[contains(.,'Sliders')]")
	private WebElement weSlider;

	@FindBy(xpath = "//p[.='Sliders list']")
	private WebElement weSlidersList;

	@FindBy(xpath = "//p[.='Add Slider']")
	private WebElement weAddSlider;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[@class='nav-item has-treeview']/a[contains(.,'Post Categories')]")
	private WebElement wePostCategories;

	@FindBy(xpath = "//a[contains(.,'Post Categories list')]")
	private WebElement wePostCategoriesList;

	@FindBy(xpath = "//p[.='Add Post Category']")
	private WebElement weAddPostCategory;

	@FindBy(xpath = "//li[3]/a[contains(.,'Tags')]")
	private WebElement weTags;

	@FindBy(xpath = "//a[contains(.,'Tags list')]")
	private WebElement weTagList;

	@FindBy(xpath = "//p[.='Add Tag']")
	private WebElement weAddTag;

	@FindBy(xpath = "//li[4]/a[contains(.,'Posts')]")
	private WebElement wePosts;

	@FindBy(xpath = "//a[contains(.,'Posts list')]")
	private WebElement wePostList;

	@FindBy(xpath = "//li[4]//a[contains(.,'Add Post')]")
	private WebElement weAddPost;

	@FindBy(xpath = "//li[5]/a[contains(.,'Comments')]")
	private WebElement weComments;

	@FindBy(xpath = "//p[.='Comments List']")
	private WebElement weCommentsList;

	@FindBy(xpath = "//li[@class='nav-item has-treeview']/a[@href='#']/p[contains(.,'Users')]")
	private WebElement weUsers;

	@FindBy(xpath = "//p[.='Users List']")
	private WebElement weUsersList;

	@FindBy(xpath = "//p[.='Add User']")
	private WebElement weAddUser;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement weHome;
	
	@FindBy(xpath="//a[.='Post']")
	private WebElement wePost;
	
	@FindBy(xpath="//select[@name='post_category_id']")
	private WebElement weChooseCategory1;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement weTitle1;
	
	@FindBy(xpath="//textarea[@name='description']")
    private WebElement weDescription1;
	
	@FindBy(xpath="//label[.='No']")
    private WebElement weImportantNo;
	
	@FindBy(xpath="//label[.='Yes']")
   private WebElement weImportantYes;
	
	@FindBy(xpath="//input[@value='5483']")
    private WebElement weTags1;
	
	@FindBy(xpath="//input[@type='file' and contains(@class, 'form-control')]")
	private WebElement weChoosePhoto1;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement weContent1;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement weSave1;
	
	@FindBy(xpath="//a[.='Cancel']")
	private WebElement weCancel1;
	
	@FindBy(xpath = "//i[@class='far fa-user']")
	private WebElement weUser;

	@FindBy(xpath = "//a[contains(.,'Your Profile')]")
	private WebElement weYourProfile;

	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement weLogout;
	
	@FindBy (xpath="//span[@id='title-error']")
	private static WebElement weErrorTitle;
	
	@FindBy (xpath="//span[@id='description-error']")
	private static WebElement weErrorDescription;
	
	@FindBy (xpath="//span[@id='tag_id[]-error']")
	private static WebElement weTagError;
	
	@FindBy (xpath="//div[@class='invalid-feedback']")
	private WebElement weContentError;

	public AddPage(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}

	public void clickOnBlog() {
		weBlog.click();
	}
	public void checkMenuLink(String title, String url) {
		WebElement weMenu = driver.findElement(By.xpath("//p[text()='" + title + "']//ancestor::li[2]"));

		if (!weMenu.getAttribute("class").toString().equalsIgnoreCase("nav-item has-treeview menu-open")) {
			weMenu.click();
		}

		WebElement weLink = driver.findElement(By.xpath("//p[text()='" + title + "']"));
		driverWait.until(ExpectedConditions.visibilityOf(weLink));
		weLink.click();

		assertEquals(driver.getCurrentUrl(), url, "Bad url for " + title);

		driver.get(PAGE_URL);
	}

	public void clickOnHome() {
		weHome.click();
	}
	public void clickOnPost() {
		wePost.click();
	}

	public void chooseCategory1() throws InterruptedException {
		weChooseCategory1.click();
		WebElement select=driver.findElement(By.xpath("//option[contains(.,'Default Post Category NE BRISATI')]"));
    	select.click();
    	Thread.sleep(2000);
    	weSave1.click();
    	
	}
	public void allEmptyFields() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}

	
	public void onlyTitleLessThan20() {

		weTitle1.sendKeys("Tanja");
		weDescription1.sendKeys("");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyTitleOver20() {

		weTitle1.sendKeys("Život je ono što prođe dok mi radimo nešto drugo");
		weDescription1.sendKeys("");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyDescriptionLessThan50() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("Što je danas lep i sunčan dan");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyDescriptionOver50() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("Here I go out to sea again The sunshine fills my hair and dreams hang in the air Gulls in the sky and in my blue eyes You know it feels unfair There's magic everywhere Look at me standing Here on my own again Up straight in the sunshine No need to run and hide It's a wonderful, wonderful life No need to laugh or cry It's a wonderful, wonderful life");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyDescriptionOver500() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam.");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyTag() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("");
		weTags1.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyPhoto() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("");
        weChoosePhoto1.sendKeys("C:\\Users\\Tanja\\Desktop\\dayne-topkin-y5_mFlLMwJk-unsplash.jpg");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void onlyContent() {

		weTitle1.sendKeys("");
		weDescription1.sendKeys("");
		WebElement iframeElement = driver.findElement(By.className("cke_wysiwyg_frame"));
        driver.switchTo().frame(iframeElement);
        WebElement contentField = driver.findElement(By.tagName("body"));
		contentField.sendKeys("Selenium iframe");
		driver.switchTo().defaultContent();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", weSave1);
	}
	public void cancel() {

		weTitle1.sendKeys("Što je danas lep i sunčan dan");
		weDescription1.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		weTags1.click();
		WebElement iframeElement = driver.findElement(By.className("cke_wysiwyg_frame"));
        driver.switchTo().frame(iframeElement);
        WebElement contentField = driver.findElement(By.tagName("body"));
		contentField.sendKeys("Selenium");
		driver.switchTo().defaultContent();
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", weCancel1);
	}
	public void Save() {

		weTitle1.sendKeys("Bio jednom jedan lav");
		weDescription1.sendKeys("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget,");
		weTags1.click();
		WebElement iframeElement = driver.findElement(By.className("cke_wysiwyg_frame"));
        driver.switchTo().frame(iframeElement);
        WebElement contentField = driver.findElement(By.tagName("body"));
		contentField.sendKeys("Selenium");
		driver.switchTo().defaultContent();
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", weSave1);
	}
	  public void editUserProfile() throws InterruptedException {
		   weUser.click();
		   Thread.sleep(2000);
		   weYourProfile.click();
		   
	   }
	   public void logout()throws InterruptedException {
		   weUser.click();
		   Thread.sleep(2000);
		   weLogout.click();
		   
	   }
}   
