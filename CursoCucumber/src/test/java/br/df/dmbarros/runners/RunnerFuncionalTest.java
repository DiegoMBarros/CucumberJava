package br.df.dmbarros.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"br.df.dmbarros.steps", "br.df.dmbarros.config"},
		tags = "@funcionais",
		plugin = {"pretty", "html:\\target\\report-html", "json:\\target\\report-json"},
		monochrome =false, //true não deixa colorido na execução pelo prompt de comando
		snippets = SnippetType.CAMELCASE,
		dryRun = false//,
//		strict = false
		)
public class RunnerFuncionalTest {

	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
	    driver.get("https://srbarriga.herokuapp.com");
	    driver.findElement(By.id("email")).sendKeys("a@a");
	    driver.findElement(By.name("senha")).sendKeys("a");
	    driver.findElement(By.tagName("button")).click();
	    driver.findElement(By.linkText("reset")).click();
	    driver.quit();
	}
}
