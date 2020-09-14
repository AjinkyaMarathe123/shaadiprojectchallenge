package jsonproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTestUsingJson {
WebDriver driver;

@Before
public void setup1(){
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
}
@After
public void later1(){
	driver.close();
}

@Test
public void Login() throws InterruptedException, IOException, ParseException{
	JSONParser jsonparser=new JSONParser();
	FileReader reader=new FileReader(".\\jsonfiles\\testdata.json");
	Object obj=jsonparser.parse(reader);
	JSONObject userdetailsobj=(JSONObject)obj;
	String fname=(String) userdetailsobj.get("first_name");
	String lname=(String) userdetailsobj.get("last_name");
	String days=(String) userdetailsobj.get("Day");
	String month=(String) userdetailsobj.get("Month");
	String year=(String) userdetailsobj.get("Year");
	String religion=(String) userdetailsobj.get("Religion");
	driver.manage().window().maximize();
	driver.get("https://www.marathishaadi.com/");
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@data-testid='lets_begin']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@data-testid='email']")).sendKeys("fgfg123@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@data-testid='password1']")).sendKeys("Rain1234");
	Thread.sleep(2000);
	WebElement option=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder']"));
	option.click();
	driver.findElement(By.xpath(".//*[text()='Son']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@data-testid='next_button']")).click();
	Thread.sleep(4000);
	driver.findElement(By.name("first_name")).sendKeys(fname);
	driver.findElement(By.name("last_name")).sendKeys(lname);
	WebElement day=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder'][text()='Day']"));
	day.click();
	driver.findElement(By.xpath(".//*[text()='"+ days + "']")).click();
	WebElement Month=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder'][text()='Month']"));
	Month.click();
	driver.findElement(By.xpath(".//*[text()='"+ month +"']")).click();
	WebElement Year=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder'][text()='Year']"));
	Year.click();
	driver.findElement(By.xpath(".//*[text()='"+year+"']")).click();
	Thread.sleep(2000);
	WebElement Religion=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder'][text()='Select']"));
	Religion.click();
	driver.findElement(By.xpath(".//*[text()='"+religion+"']")).click();
	String Mothertongue="Marathi";
	String presentmothertongue=driver.findElement(By.xpath(".//*[@class='Dropdown-placeholder is-selected']")).getAttribute("value");
	if(Mothertongue.equals(presentmothertongue)){
		System.out.println("There is a match");
	}
	Thread.sleep(4000);
	driver.findElement(By.xpath(".//*[@data-testid='sign_up_button']")).click();
	Thread.sleep(4000);
}


	



}
