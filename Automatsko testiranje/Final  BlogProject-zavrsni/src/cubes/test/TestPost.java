package cubes.test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cubes.webpages.LoginPage;
import cubes.webpages.PostPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
		
public class TestPost {
	
	
	private static ChromeDriver driver;
	private static WebDriverWait driverWait;
	private static LoginPage loginPage;
	private static PostPage postPage;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Tanja\\Desktop\\Web Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driverWait = new WebDriverWait(driver, Duration.ofMillis(10000));

		loginPage = new LoginPage(driver);
		postPage = new PostPage(driver, driverWait);
		
		loginPage.loginSuccess();
	}

	
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			driver.quit();
		}
		@Before
		public void setUp() throws Exception {
			postPage.openPage();
		}

		@After
		public void tearDown() throws Exception {
		}
       @Test
		public void test01tc3totc13testLinkFromMenu() {
			postPage.checkMenuLink("Sliders list", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders");	
			postPage.checkMenuLink("Add Slider", "https://testblog.kurs-qa.cubes.edu.rs/admin/sliders/add");
		    postPage.checkMenuLink("Post Categories list", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
			postPage.checkMenuLink("Add Post Category", "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add");
			postPage.checkMenuLink("Tags list", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags");
			postPage.checkMenuLink("Add Tag", "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add");
			postPage.checkMenuLink("Posts list", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
			postPage.checkMenuLink("Add Post", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
			postPage.checkMenuLink("Comments List", "https://testblog.kurs-qa.cubes.edu.rs/admin/comments");
			postPage.checkMenuLink("Users List", "https://testblog.kurs-qa.cubes.edu.rs/admin/users");
			postPage.checkMenuLink("Add User", "https://testblog.kurs-qa.cubes.edu.rs/admin/users/add");
				
	}
		@Test
		public void test02Tc02TestBlogHomePage() {
	    postPage.clickOnBlog();
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/");
		
		}
		@Test
		public void test03Tc14TestHomePage() {
	    postPage.clickOnHome();
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin");
		}
		
     
		@Test
		public void test04tc15TestCorrectTitle() throws InterruptedException {
	    String name="Što je danas lep i sunčan dan";
		postPage.inputCorrectTitle(name);
	    Thread.sleep(2000);
	    WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
		 assertTrue(filteredElement.isEnabled());
			
}
		@Test
		public void test05tc16TestIncorrectTitle() throws InterruptedException {
        postPage.inputCorrectTitle("1111111111");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isEnabled();
} 
		
		@Test
		public void test06tc17TestExistingAuthorName() throws InterruptedException {
        postPage.inputExistingAuthorName();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody[1]/tr[1]/td[.='Polaznik Kursa']")).isEnabled();
} 

		@Test
		public void test07tc18TestInputNonExsistentAuthorName() throws InterruptedException {
        postPage.inputNonExsistentAuthorName();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__message']")).isEnabled();
	
}	
		
		@Test
		public void test08tc19TestExistingCategoryName() throws InterruptedException {
        postPage.inputExisistingCategoryName();
        Thread.sleep(2000);
       driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
       Thread.sleep(4000);
        WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
	    assertTrue(filteredElement.isEnabled());
}	
		
		@Test
		public void test09tc20TesNontExististentCategoryName() throws InterruptedException {
        postPage.inputNonExsistentCategoryName();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__message']")).isEnabled();
        
        
}	
		@Test
		public void test10tc21TestSearchByImportanceYes() throws InterruptedException {
			postPage.searchByImportance();
			Thread.sleep(2000);
	        Select important=new Select(driver.findElement(By.name("important")));
           important.selectByValue("1");
           Thread.sleep(2000);
		    WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
		    assertTrue(filteredElement.isEnabled());
		        
		}  

		@Test
		public void test11tc22TestSearchByImportanceNo() throws InterruptedException {
			postPage.searchByImportance();
			Thread.sleep(2000);
	        Select important=new Select(driver.findElement(By.name("important")));
           important.selectByValue("0");
           Thread.sleep(2000);
		    WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
		    assertTrue(filteredElement.isEnabled());
		        
		}  

		@Test
		public void test12tc23TestSearchByStatusEnabled() throws InterruptedException {
			postPage.searchByStatus();
			Thread.sleep(2000);
	        Select status=new Select(driver.findElement(By.name("status")));
           status.selectByValue("1");
           Thread.sleep(2000);
		    
		}  
		@Test
		public void test13tc24TestSearchByStatusDisabled() throws InterruptedException {
			postPage.searchByStatus();
			Thread.sleep(2000);
	        Select status=new Select(driver.findElement(By.name("status")));
           status.selectByValue("0");
           Thread.sleep(2000);
		    WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
		    assertTrue(filteredElement.isEnabled());
		        
		}  
		
		@Test
		public void test14tc25TestSearchByExistingTag() throws InterruptedException {
        postPage.searchByTag();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Default TAG2 NE BRISATI");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement filteredElement = driver.findElement(By.xpath("//div[@class='dataTables_info'][contains(text(),'filtered')]"));
	    assertTrue(filteredElement.isEnabled());
	
		} 
		@Test
		public void test15tc26TestSearchByNonExistententTag() throws InterruptedException {
        postPage.searchByTag();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Tanja");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement filteredElement = driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__message']"));
	    assertTrue(filteredElement.isEnabled());
	
		} 
		
		@Test
		public void test16tc27tc28TestSelectSortingByNumber() throws InterruptedException {
			postPage.sortByNumber();
			 Thread.sleep(2000);
		        WebElement sortingNumberDesc = driver.findElement(By.xpath("//th[@class='sorting_desc']"));
			    assertTrue(sortingNumberDesc.isEnabled());
			
			    postPage.sortByNumber();
				 Thread.sleep(2000);
			        WebElement sortingNumberAsc = driver.findElement(By.xpath("//th[@class='sorting_asc']"));
				    assertTrue(sortingNumberAsc.isEnabled()); 
		} 
		
		@Test
		public void test17tc29tc30TestSelectSortingByTitle() throws InterruptedException {
			postPage.sortByTitle();
			 Thread.sleep(2000);
			 WebElement sortingTitleAsc = driver.findElement(By.xpath("//th[@class='sorting_asc']"));
			    assertTrue(sortingTitleAsc.isEnabled()); 
			    
            postPage.sortByTitle();
				 Thread.sleep(2000);
				 WebElement sortingTitleDesc = driver.findElement(By.xpath("//th[@class='sorting_desc']"));
				    assertTrue(sortingTitleDesc.isEnabled());
		} 
		@Test
		public void test18tc33tc34TestSelectSortingByCategory() throws InterruptedException {
			postPage.sortByCategory();
			 Thread.sleep(2000);
			 WebElement sortingCategoryAsc = driver.findElement(By.xpath("//th[@class='text-center sorting_asc']"));
			    assertTrue(sortingCategoryAsc.isEnabled()); 
			    
            postPage.sortByCategory();
				 Thread.sleep(2000);
				 WebElement sortingCategoryDesc = driver.findElement(By.xpath("//th[@class='text-center sorting_desc']"));
				    assertTrue(sortingCategoryDesc.isEnabled());
		} 
		
	/*	@Test
		public void test19tc35tc36TestSelectSortingByCreatedAt() throws InterruptedException {
			postPage.sortByCreatedAt();
			 Thread.sleep(2000);
			 WebElement sortingCreatedAtAsc = driver.findElement(By.xpath("//th[@class='text-center sorting_asc']"));
			    assertTrue(sortingCreatedAtAsc.isEnabled()); 
			    
            postPage.sortByCreatedAt();
				 Thread.sleep(2000);
				 WebElement sortingCreatedAtDesc = driver.findElement(By.xpath("//th[@class='text-center sorting_desc']"));
				    assertTrue(sortingCreatedAtDesc.isEnabled());
		}
		*/
		@Test
		public void test20Tc37TestOpenPost() throws InterruptedException {
	    postPage.openPost();
        String currentTab = driver.getWindowHandle();
	   Thread.sleep(3000);;
	    driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
         Set<String> allTabs = driver.getWindowHandles();
	    allTabs.remove(currentTab);
	    String newTab = allTabs.iterator().next();
	    driver.switchTo().window(newTab);
	     assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/posts/single-post/5137/postpostpostpostpostpostpostpostpostpost1");
		
		}  
		@Test
		public void test21Tc38TestEditPost() throws InterruptedException {
	    postPage.editPost();
	    assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/edit/5137");
} 
		
	/*	@Test
		public void test22Tc39TestDeletePost() throws InterruptedException {
			Thread.sleep(2000);
			WebElement scroll=driver.findElement(By.xpath("//td[@class='sorting_1'][text()='5155']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
			Thread.sleep(2000);
			postPage.deletePost();
			 Thread.sleep(2000); 
			WebElement delete = driver.findElement(By.xpath("//button[.='Delete']"));
			 delete.click();
			Thread.sleep(2000); 
} 
		*/

		@Test
		public void test23Tc40TestDisablePost() throws InterruptedException {
			Thread.sleep(2000);
            postPage.disablePost();
			Thread.sleep(2000);
			WebElement disable=driver.findElement(By.xpath("//button[contains(.,'Disable')]"));
			disable.click();
			Thread.sleep(3000);
			 WebElement enable = driver.findElement(By.xpath("//tbody[1]//i[@class='fas fa-check']"));
			 assertTrue(enable.isEnabled());
	} 
		@Test
		public void test24Tc41TestEnablePost() throws InterruptedException {
			Thread.sleep(3000);
			WebElement scroll=driver.findElement(By.xpath("//td[.='5137']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
            postPage.enablePost();
			Thread.sleep(3000);
			WebElement enable=driver.findElement(By.xpath("//form[@id='enable-modal']//i[@class='fas fa-check']"));
			enable.click();
			Thread.sleep(3000);
			 WebElement disable = driver.findElement(By.xpath("//tbody[1]/tr[1]//div[2]/button[1]"));
			 assertTrue(disable.isEnabled());
	}
		@Test
		public void test25Tc42TestSetAsUnimportantPost() throws InterruptedException {
			Thread.sleep(3000);
			WebElement scroll=driver.findElement(By.xpath("//td[.='5137']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
            postPage.setAsUnimportant();
			Thread.sleep(3000);
			WebElement enable=driver.findElement(By.xpath("//button[contains(.,'Set as Unimportant')]"));
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(enable));
			enable.click();
			Thread.sleep(3000);
			 WebElement important = driver.findElement(By.xpath("//tbody[1]/tr[1]//i[@class='fas fa-bookmark']"));
			 assertTrue(important.isEnabled());
	}
		@Test
		public void test26Tc43TestSetAsImportantPost() throws InterruptedException {
			Thread.sleep(3000);
			WebElement scroll=driver.findElement(By.xpath("//td[.='5137']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
            postPage.setAsImportant();
			Thread.sleep(3000);
			WebElement enable=driver.findElement(By.xpath("//button[contains(.,'Set as Important')]"));
			enable.click();
			Thread.sleep(3000);
			 WebElement important = driver.findElement(By.xpath("//tbody[1]/tr[1]//i[@class='fas fa-times']"));
			 assertTrue(important.isEnabled());
	}  
		@Test
		public void test27Tc44TestEditUserProfile() throws InterruptedException {
			postPage.editUserProfile();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/yourprofile");
		} 
		
		@Test
		public void test28Tc45TestLogout() throws InterruptedException {
			postPage.logout();
			Thread.sleep(2000);
			assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/login");
		} 
		
}	

	

