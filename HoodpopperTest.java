//Ed McCluskey

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


/**
 *As a user, 
 *I would like to be able to tokenize code in 
 *Hoodpopper accurately 
 *and have the system recognize my commands.
 *
 */

public class HoodpopperTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the Hoodpopper page for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}

	//Given a space is entered in Hoodpopper
	//when tokenize button is pushed
	//then :on_sp should be displayed
	@Test
	public void testTokenSpace() {
		
		driver.findElement(By.id("code_code")).sendKeys(" ");
		WebElement tokenizeButton = driver.findElement(By.name("commit"));
		tokenizeButton.click();
		assertTrue(driver.getPageSource().contains(":on_sp"));
	}
	
	//Given 'puts' is entered in Hoodpopper
	//when tokenize button is pushed
	//then :on_ident should be displayed
	@Test
	public void testTokenPuts() {
		
		driver.findElement(By.id("code_code")).sendKeys("puts");
		WebElement tokenizeButton = driver.findElement(By.name("commit"));
		tokenizeButton.click();
		assertTrue(driver.getPageSource().contains(":on_ident"));
	}
	
	//Given '+' is entered in Hoodpopper
	//when tokenize button is pushed
	//then :on_op should be displayed
	@Test
	public void testTokenPlus() {
		
		driver.findElement(By.id("code_code")).sendKeys("+");
		WebElement tokenizeButton = driver.findElement(By.name("commit"));
		tokenizeButton.click();
		assertTrue(driver.getPageSource().contains(":on_op"));
	}
	
	//Given a newline is entered in Hoodpopper
	//when tokenize button is pushed
	//then on_ignored_nl should be displayed
	@Test
	public void testTokenNewline() {
		
		driver.findElement(By.id("code_code")).sendKeys("\n");
		WebElement tokenizeButton = driver.findElement(By.name("commit"));
		tokenizeButton.click();
		assertTrue(driver.getPageSource().contains("on_ignored_nl"));
	}
	
	/**
	 * As a user, 
	 * I would like to be able to parse code in Hoodpopper accurately 
	 * and have the system recognize my commands.
	 */

	//Given a space is entered in Hoodpopper
	//when parse button is pushed
	//then nothing should be displayed
	@Test
	public void testParseSpace() {
		
		driver.findElement(By.id("code_code")).sendKeys(" ");
		WebElement parseButton = driver.findElement(By.id("commit[2]"));
		parseButton.click();
		assertTrue(!driver.getPageSource().contains("puts"));
	}
	
	//Given 'puts' is entered in Hoodpopper
	//when parse button is pushed
	//then puts should be displayed
	@Test
	public void testParsePuts() {
		
		driver.findElement(By.id("code_code")).sendKeys("puts");
		WebElement parseButton = driver.findElement(By.name("commit[2]"));
		parseButton.click();
		assertTrue(driver.getPageSource().contains("puts"));
	}
	
	//Given '+' is entered in Hoodpopper
	//when parse button is pushed
	//then + should be displayed
	@Test
	public void testParsePlus() {
		
		driver.findElement(By.id("code_code")).sendKeys("+");
		WebElement parseButton = driver.findElement(By.name("commit[2]"));
		parseButton.click();
		assertTrue(driver.getPageSource().contains("+"));
	}
	/**
	 * As a user, 
	 * I would like to be able to compile code in Hoodpopper accurately 
	 * and have the system recognize my commands.
	 */

	//Given a '/' is entered in Hoodpopper
	//when compile button is pushed
	//then opt_div should be displayed
	@Test
	public void testCompileDiv() {
		
		driver.findElement(By.id("code_code")).sendKeys("/");
		WebElement compileButton = driver.findElement(By.name("commit[3]"));
		compileButton.click();
		assertTrue(driver.getPageSource().contains("opt_div"));
	}
	//Given a 'puts' is entered in Hoodpopper
	//when compile button is pushed
	//then putstring should be displayed
	@Test
	public void testCompilePuts() {
		
		driver.findElement(By.id("code_code")).sendKeys("puts");
		WebElement compileButton = driver.findElement(By.name("commit[3]"));
		compileButton.click();
		assertTrue(driver.getPageSource().contains("putstring"));
	}
}
