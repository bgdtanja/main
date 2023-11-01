package cubes.test;

import static org.junit.Assert.*;

import java.time.Duration;
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
import cubes.webpages.tags.TagFormPage;
import cubes.webpages.tags.TagListPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUpdateTag {

	private static ChromeDriver driver;
	private static LoginPage loginPage;
	private static TagFormPage tagFormPage;
	private static TagListPage tagListPage;
	private static String tagName;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Tanja\\Desktop\\Web Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));

		loginPage = new LoginPage(driver);
		tagFormPage = new TagFormPage(driver,driverWait);
		tagListPage = new TagListPage(driver, driverWait);
		
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tagListPage.deleteTag(tagName);
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		tagListPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc1TestUpdateEmptyTagName() {
		tagListPage.clickOnAddNewTag();
		
		tagName = tagFormPage.addNewRandomTag();
		
		tagListPage.clickOnUpdateTag(tagName);
		
		tagFormPage.inputTagString("");
		
		tagFormPage.clickSave();
		
		String error = tagFormPage.getErrorMessage();
		
		assertEquals("This field is required.", error);	
	}
	
	@Test
	public void tc2TestUpdateTagWithExistingName() {
		tagListPage.clickOnUpdateTag(tagName);
		
		tagFormPage.inputTagString("sit");
		
		tagFormPage.clickSave();
		
		String error = tagFormPage.getErrorMessage("The name has already been taken.");
		
		assertEquals("The name has already been taken.", error);
		
	}
	
	@Test
	public void tc3TestUpdateTagName() {
		tagListPage.clickOnUpdateTag(tagName);
		
		String newTagName = "New "+tagFormPage.getTagString();
		
		tagFormPage.inputTagString(newTagName);
		
		tagFormPage.clickSave();
		
		assertEquals(true, tagListPage.isTagInList(newTagName));
		
		tagName = newTagName;
	}

}
