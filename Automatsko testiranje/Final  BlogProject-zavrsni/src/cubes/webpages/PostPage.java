package cubes.webpages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPage {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";

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

	@FindBy(xpath = "//input[@name='title']")
	private WebElement weTitle;

	@FindBy(css = "[title='--Choose Author --']")
	private WebElement weChooseAuthor;

	@FindBy(css = "[title='--Choose Category --']")
	private WebElement weChooseCategory;

	@FindBy(name = "important")
	private WebElement weImportant;

	@FindBy(name = "status")
	private WebElement weStatus;

	@FindBy(xpath = "//ul[@class='select2-selection__rendered']")
	private WebElement weTag;

	@FindBy(xpath = "//th[.='#']")
	private WebElement weSortNumber;

	@FindBy(xpath = "//th[.='Title']")
	private WebElement weSortTitle;

	@FindBy(xpath = "//th[.='Category']")
	private WebElement weSortCategory;

	@FindBy(xpath = "//th[@aria-label='Created At: activate to sort column ascending']")
	private WebElement weSortCreatedAt;

	@FindBy(xpath="//a[@href='https://testblog.kurs-qa.cubes.edu.rs/posts/single-post/5137/postpostpostpostpostpostpostpostpostpost1']")
	private WebElement weEye;

	@FindBy(xpath = "//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/posts/edit/5137']")
	private WebElement weEdit;

	@FindBy(css = "[data-id='5155']")
	private WebElement weDelete;

	@FindBy(xpath = "//tbody[1]/tr[1]//div[2]/button[1]")
	private WebElement weDisable;

	@FindBy(xpath = "//tbody[1]//i[@class='fas fa-check']")
	private WebElement weEnable;

	@FindBy(xpath = "//tbody[1]/tr[1]//button[2]")
	private WebElement weSetUnimportant;

	@FindBy(xpath = "//tbody[1]/tr[1]//i[@class='fas fa-bookmark']")
	private WebElement weSetImportant;

	@FindBy(xpath = "//i[@class='far fa-user']")
	private WebElement weUser;

	@FindBy(xpath = "//a[contains(.,'Your Profile')]")
	private WebElement weYourProfile;

	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement weLogout;

	public PostPage(WebDriver driver, WebDriverWait driverWait) {
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

	public void inputCorrectTitle(String name) {

		weTitle.clear();
		weTitle.sendKeys(name);

	}

	public void inputIncorrectTitle() {
		weTitle.clear();
		weTitle.sendKeys();

	}

	public void inputExistingAuthorName() throws InterruptedException {
		weChooseAuthor.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']"))
				.sendKeys("Polaznik Kursa");

	}

	public void inputNonExsistentAuthorName() {
		weChooseAuthor.click();
		driver.findElement(By.xpath(
				"//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']"))
				.sendKeys("Tanja");

	}

	public void inputExisistingCategoryName() {
		weChooseCategory.click();
		driver.findElement(By.xpath(
				"//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']"))
				.sendKeys("Default Post Category NE BRISATI");

	}

	public void inputNonExsistentCategoryName() {
		weChooseCategory.click();
		driver.findElement(By.xpath(
				"//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']"))
				.sendKeys("kategorija");
	}

	public void searchByImportance() {
		weImportant.click();

	}

	public void searchByStatus() {
		weStatus.click();
	}

	public void searchByTag() {
		weTag.click();

	}

	public void sortByNumber() {
		weSortNumber.click();
	}
    public void sortByTitle() {
    	weSortTitle.click();
    	
    }
    public void sortByCategory() {
    	weSortCategory.click();;
    }
    public void sortByCreatedAt() {
    	weSortCreatedAt.click();
    }
    public void openPost() throws InterruptedException {
    	Thread.sleep(2000);
    	weEye.click();
    }
    public void editPost() throws InterruptedException {
    	Thread.sleep(2000);
    	weEdit.click();
    }
   public void deletePost() throws InterruptedException  {
	   Thread.sleep(2000);
	   weDelete.click();
   }
   public void disablePost() throws InterruptedException {
	   Thread.sleep(2000);
	   weDisable.click();
   }
   public void enablePost()throws InterruptedException {
	   Thread.sleep(2000);
	   weEnable.click();
   }
   public void setAsUnimportant()throws InterruptedException {
	   Thread.sleep(2000);
	   weSetUnimportant.click();
   }
   public void setAsImportant() throws InterruptedException {
	   Thread.sleep(2000);
	   weSetImportant.click();  
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
