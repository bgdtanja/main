package cubes.test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.webpages.LoginPage;
import cubes.webpages.categories.CategoryFormPage;
import cubes.webpages.categories.CategoryListPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCategories {

	private static ChromeDriver driver;
	private static LoginPage loginPage;
	private static CategoryFormPage categoryFormPage;
	private static CategoryListPage categoryListPage;
	
	private static String categoryName;
	private static String categoryDescription;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Tanja\\Desktop\\Web Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));
		
		loginPage = new LoginPage(driver);
		categoryListPage = new CategoryListPage(driver, driverWait);
		categoryFormPage = new CategoryFormPage(driver, driverWait);
		
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		categoryListPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc01TestMenuLinks() {
		checkMenuLink("Sliders list", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders");
		checkMenuLink("Add Slider", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders/add");
		checkMenuLink("Post Categories list", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
		checkMenuLink("Add Post Category", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add");
		checkMenuLink("Tags list", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags");
		checkMenuLink("Add Tag", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add");
		checkMenuLink("Posts list", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
		checkMenuLink("Add Post", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		checkMenuLink("Comments List", "https://testblog.kurs-qa.cubes.edu.rs/admin/comments");
		checkMenuLink("Users List", "https://testblog.kurs-qa.cubes.edu.rs/admin/users");
		checkMenuLink("Add User", "https://testblog.kurs-qa.cubes.edu.rs/admin/users/add");
	}
	
	@Test
	public void tc02TestNavigationLink() {
		checkNavigationLink("Home", "https://testblog.kurs-qa.cubes.edu.rs/admin");
	}
	
	@Test
	public void tc03TestAddCategoryEmptyNameEmtyDescription() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInName("");
		
		categoryFormPage.inputStrigInDescription("");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getNameInputError(), "This field is required.","Bad error string on Name input");
		
		assertEquals(categoryFormPage.getDescriptionInputError(), "This field is required.","Bad error string on Description input");
	}
	
	@Test
	public void tc04TestAddCategoryEmtyDescription() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInName("Category Test");
		
		categoryFormPage.inputStrigInDescription("");
		
		categoryFormPage.clickOnSave();
				
		assertEquals(categoryFormPage.getDescriptionInputError(), "This field is required.","Bad error string on Description input");
	}
	

	@Test
	public void tc05TestAddCategoryEmtyName() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInDescription(" Description test Description test Description test Description test");
		
		categoryFormPage.inputStrigInName("");
		
		categoryFormPage.clickOnSave();
				
		assertEquals(categoryFormPage.getNameInputError(), "This field is required.","Bad error string on Name input");
	}
	
	@Test
	public void tc06TestAddCategoryShortDescription() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInName("Name Test");
		
		categoryFormPage.inputStrigInDescription("Description test");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getDescriptionInputErrorFromDiv(), "The description must be at least 50 characters.");
	}
	
	@Test
	public void tc07TestAddCategoryExistingNameShortDescription() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInName("East Evafurt");
		
		categoryFormPage.inputStrigInDescription("Description test");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getNameInputErrorFromDiv(), "The name has already been taken.","Bad error for Name input");
		
		assertEquals(categoryFormPage.getDescriptionInputErrorFromDiv(), "The description must be at least 50 characters.","Bad error for Decription input");
	}
	
	@Test
	public void tc08TestAddCategory() {
		
		categoryListPage.clickOnAddNewCategory();
		
		categoryFormPage.inputStrigInName("Name Test");
		
		categoryFormPage.inputStrigInDescription(" Description test Description test Description test Description test");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryListPage.isCategoryInList("Name Test"), true);
	}
	
	@Test
	public void tc09TestDeleteCategory() {
				
		categoryListPage.clickOnDeleteCategory("Name Test");
		
		categoryListPage.clickOnDialogDelete();
		
		assertEquals(categoryListPage.isCategoryInList("Name Test"), false);
		
	}
	
	@Test
	public void tc10TestUpdateNameCategory() {
				
		categoryListPage.clickOnAddNewCategory();
		
		Random random = new Random();
		
		categoryName = "Name "+random.nextInt(1000);
		categoryDescription = "Descritption Descritption Descritption Descritption"+random.nextInt(1000);
		
		categoryFormPage.inputStrigInName(categoryName);
		categoryFormPage.inputStrigInDescription(categoryDescription);
		
		categoryFormPage.clickOnSave();
		
		categoryListPage.clickOnUpdateCategory(categoryName);
		
		categoryFormPage.inputStrigInName("Name Test");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryListPage.isCategoryInList("Name Test"), true);
		
	}
	
	@Test
	public void tc11TestUpdateDescriptionCategory() {
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		categoryFormPage.inputStrigInDescription("Description Description Description Description Test");
		
		categoryFormPage.clickOnSave();
		
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		assertEquals(categoryFormPage.getStringFromDescritpionInput(), "Description Description Description Description Test");
	}
	
	@Test
	public void tc12TestUpdateEmptyNameCategory() {
		
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		categoryFormPage.inputStrigInName("");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getNameInputError(), "This field is required.");	
	}
	
	@Test
	public void tc13TestUpdateEmptyDescriptionCategory() {
		
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		categoryFormPage.inputStrigInDescription("");
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getDescriptionInputError(), "This field is required.");	
	}
	
	@Test
	public void tc14TestUpdateEmptyNameAndDescriptionCategory() {
		
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		categoryFormPage.inputStrigInName("");

		categoryFormPage.inputStrigInDescription("");		
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryFormPage.getNameInputError(), "This field is required.");	
		
		assertEquals(categoryFormPage.getDescriptionInputError(), "This field is required.");	
	}
	
	@Test
	public void tc15TestUpdateCategory() {
		categoryListPage.clickOnUpdateCategory("Name Test");
		
		Random random = new Random();
		
		categoryName = "Name "+random.nextInt(1000);
		categoryDescription = "Descritption Descritption Descritption Descritption"+random.nextInt(1000);
		
		categoryFormPage.inputStrigInName(categoryName);
		categoryFormPage.inputStrigInDescription(categoryDescription);
		
		categoryFormPage.clickOnSave();
		
		assertEquals(categoryListPage.isCategoryInList(categoryName), true);
		
		categoryListPage.clickOnDeleteCategory(categoryName);
		
		categoryListPage.clickOnDialogDelete();
	}

	public void checkMenuLink(String title,String url) {
		
		categoryListPage.openLinkParentInMenu(title);
		
		categoryListPage.clickOnLinkInMenu(title);
		
		assertEquals(driver.getCurrentUrl(), url,"Bad url for "+title);
		
		categoryListPage.openPage();
	}
	
	public void checkNavigationLink(String title, String url) {
		
		categoryListPage.clickOnNavigationLink(title);
		
		assertEquals(driver.getCurrentUrl(), url,"Bad url for "+title);

		categoryListPage.openPage();
	}
}
