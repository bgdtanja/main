package cubes.test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cubes.webpages.AddPage;
import cubes.webpages.LoginPage;
import cubes.webpages.PostPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAddPage {

	private static ChromeDriver driver;
	private static WebDriverWait driverWait;
	private static LoginPage loginPage;
	private static AddPage postPage;
	private static AddPage addPage;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Tanja\\Desktop\\Web Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));

		loginPage = new LoginPage(driver);
		 addPage  = new AddPage(driver, driverWait);
		
		loginPage.loginSuccess();
	}

	
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			driver.quit();
		}
		@Before
		public void setUp() throws Exception {
			addPage.openPage();
		}

		@After
		public void tearDown() throws Exception {
		}
      @Test
		public void test01tc5totc15testLinkFromMenu() {
			addPage.checkMenuLink("Sliders list", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders");	
			addPage.checkMenuLink("Add Slider", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders/add");
			addPage.checkMenuLink("Post Categories list", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
			addPage.checkMenuLink("Add Post Category", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add");
			addPage.checkMenuLink("Tags list", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags");
			addPage.checkMenuLink("Add Tag", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add");
			addPage.checkMenuLink("Posts list", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
			addPage.checkMenuLink("Add Post", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
			addPage.checkMenuLink("Comments List", "https://testblog.kurs-qa.cubes.edu.rs/admin/comments");
			addPage.checkMenuLink("Users List", "https://testblog.kurs-qa.cubes.edu.rs/admin/users");
			addPage.checkMenuLink("Add User", "https://testblog.kurs-qa.cubes.edu.rs/admin/users/add");
				
	}
		@Test
		public void test02Tc02TestBlogHomePage() {
			addPage.clickOnBlog();
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/");
		
		}
		@Test
		public void test03Tc03TestHomePage() {
			addPage.clickOnHome();
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin");
		}
		
	    @Test
	    public void test04Tc04TestPostPage() {
	    	addPage.clickOnPost();
	    }
	   
	    @Test
	    public void test05Tc17TestAllEmptyFields() throws InterruptedException {
	    	addPage.allEmptyFields();
	    	 WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
	         WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
	         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
	         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
	    	 }
	    
	    @Test
	    public void test06Tc18TestOnlyTitleLessThan20() throws InterruptedException {
	    	addPage.onlyTitleLessThan20();
	    	WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
	    	 String expectedMessage = "Please enter at least 20 characters.";
	         String actualMessage = weErrorTitle.getText();
	         Assert.assertEquals(expectedMessage, actualMessage);
	         WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
	         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
	         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
 } 
		@Test
	    public void test07Tc19TestOnlyTitleOver20() throws InterruptedException {
	    	 addPage.onlyTitleOver20();
	         WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
	         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
	         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
 }
		 @Test
		    public void test08Tc20TestOnlyDescriptionLessThan50() throws InterruptedException {
		    	addPage.onlyDescriptionLessThan50();
		    	WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
                WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
                String expectedMessage = "Please enter at least 50 characters.";
		        String actualMessage = weErrorDescription.getText();
		         Assert.assertEquals(expectedMessage, actualMessage);
		         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
		         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		    	 }
		 
		 @Test
		    public void test09Tc21TestOnlyDescriptionOver50() throws InterruptedException {
		    	addPage.onlyDescriptionOver50();
		    	WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
                WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
		         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		    	 }  
		
		 @Test
		    public void test10Tc22TestOnlyDescriptionOver500() throws InterruptedException {
		    	addPage.onlyDescriptionOver500();
		    	WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
                WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
                String expectedMessage = "Please enter no more than 500 characters.";
		        String actualMessage = weErrorDescription.getText();
		         Assert.assertEquals(expectedMessage, actualMessage);
		         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
		         assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		    	 } 
		 @Test
		    public void test011Tc23TestOnlyTag() throws InterruptedException {
		    	addPage.onlyTag();
		    	 WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
		         WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
                 assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		    	 } 
                 @Test
               public void test012Tc24TestOnlyPhoto() throws InterruptedException {
	        addPage.onlyPhoto();
	       
	        WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
            WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
            WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
            assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
	 } 
		 @Test
		    public void test012Tc25TestOnlyContent() throws InterruptedException {
		    	addPage.onlyContent();
		    	 WebElement weErrorTitle = driver.findElement(By.xpath("//span[@id='title-error']"));
		         WebElement weErrorDescription = driver.findElement(By.xpath("//span[@id='description-error']"));
		         WebElement weErrorTags = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
                 assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		    	 } 
		@Test
	    public void test013Tc26TestCancel() throws InterruptedException {
	    	addPage.cancel();
	    	
          assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
	    	 } 
		@Test
	    public void test014Tc27TestSave() throws InterruptedException {
	    	addPage.Save();
	    	Thread.sleep(3000);
            assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
            WebElement check = driver.findElement(By.cssSelector("tr:nth-of-type(9) > td:nth-of-type(5)"));
			assertTrue(check.isEnabled());
	    	String expectedMessage = "Bio jednom jedan lav";
	         String actualMessage = check.getText();
	         Assert.assertEquals(expectedMessage, actualMessage);
	    	 } 
		@Test
		public void test15Tc28TestEditUserProfile() throws InterruptedException {
			addPage.editUserProfile();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/yourprofile");
		} 
		
		@Test
		public void test16Tc29TestLogout() throws InterruptedException {
			addPage.logout();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/login");
		}
}