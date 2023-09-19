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
public class TestDeleteTag {
	
	private static ChromeDriver driver;
	private static WebDriverWait driverWait;
	private static LoginPage loginPage;
	private static TagFormPage tagFormPage;
	private static TagListPage tagListPage;
	
	private static String tagName;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Tanja\\Desktop\\Web Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));

		loginPage = new LoginPage(driver);
		tagFormPage = new TagFormPage(driver,driverWait);
		tagListPage = new TagListPage(driver, driverWait);
		
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
	public void tc1TestCancelOnDelete() {
		tagListPage.clickOnAddNewTag();
		
		tagName = tagFormPage.addNewRandomTag();
		
		tagListPage.clickOnDeleteTag(tagName);
		
		tagListPage.clickOnDialogCancel();
		
		String expectedTagName = tagListPage.checkTag(tagName);
		
		assertEquals(tagName, expectedTagName);
	}
	
//	@Test
//	public void tc2TestDeleteTag() {
//		tagListPage.clickOnAddNewTag();
//		
//		String tagName = tagFormPage.addNewRandomTag();
//		
//		tagListPage.clickOnDeleteTag(tagName);
//		
//		tagListPage.clickOnDialogDelete();
//		
//		assertEquals(false, tagListPage.isTagInList(tagName));
//	}

	
	@Test
	public void tc2TestDeleteTag() {
		
		tagListPage.clickOnDeleteTag(tagName);
		
		tagListPage.clickOnDialogDelete();
		
		assertEquals(false, tagListPage.isTagInList(tagName));
	}
}
