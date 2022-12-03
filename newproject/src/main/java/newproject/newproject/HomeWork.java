package newproject.newproject;
//Open the below url: http://the-internet.herokuapp.com/tinymce
//1. Write down "We are facing exam." in test box.
//2. Change Headings to Heading 1
//3. Change  Align to Right
//4. Take a picture of the sceen.
//5. Print out all the "Heading items" from "Headings" menu into Console.

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWork {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/tinymce");
		Thread.sleep(300);
		driver.switchTo().frame(0);
WebElement testbox= driver.findElement(By.xpath("(//*[@id='tinymce'])"));
testbox.clear();
testbox.sendKeys("we are facing exam");
Thread.sleep(300);
driver.switchTo().defaultContent();
WebElement p = driver.findElement(By.xpath("(//*[@focusable='false'])[7]"));
p.click();
WebElement q = driver.findElement(By.xpath("//div[text()='Headings']"));
q.click();
WebElement r = driver.findElement(By.xpath("//h1[text()='Heading 1']"));
r.click();

WebElement ar = driver.findElement(By.xpath("(//*[@focusable='false'])[12]"));
ar.click();

TakesScreenshot tc =(TakesScreenshot)driver;
File src = tc.getScreenshotAs(OutputType.FILE);
File dst = new File("data/pic.png");
FileUtils.copyFile(src, dst);
WebElement h = driver.findElement(By.xpath("//span[text()='Heading 1']"));
h.click();

List<WebElement>all = driver.findElements(By.xpath("//div[@class='tox-collection__item-label']"));
for(WebElement i :all) {
	String v =i.getText();
	System.out.println(v);
}
}
	}
