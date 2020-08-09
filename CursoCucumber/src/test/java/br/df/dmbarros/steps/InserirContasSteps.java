package br.df.dmbarros.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void que_estou_acessando_a_aplicacao() throws Throwable {
	    driver = new ChromeDriver();
	    driver.get("https://srbarriga.herokuapp.com");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informo_o_usuario(String arg1) throws Throwable {
	   driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void a_senha(String arg1) throws Throwable {
		driver.findElement(By.name("senha")).sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void seleciono_entrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Entao("^visualizo a página inicial$")
	public void visualizo_a_pagina_inicial() throws Throwable {
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, wagner!", texto);
	}

	@Quando("^seleciono Contas$")
	public void seleciono_Contas() throws Throwable {
	    driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void seleciono_Adicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informo_a_conta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void seleciono_Salvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Entao("^a conta é inserida com sucesso$")
	public void a_conta_e_inserida_com_sucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Conta adicionada com sucesso!", texto);
	}

	@Entao("^sou notificado que o nome da conta é obrigatório$")
	public void sou_notificar_que_o_nome_da_conta_e_obrigatorio() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Informe o nome da conta", texto);
	}

	@Entao("^sou notificado que já existe uma conta com esse nome$")
	public void sou_notificado_que_ja_existe_uma_conta_com_esse_nome() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Já existe uma conta com esse nome!", texto);
	}
	
	@Entao("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	    Assert.assertEquals(arg1, texto);
	}
	
	//acima estão os cenários imperativos, granularizados. Abaixo os cenários declarativos, negocial.
	@Dado("^que desejo adicionar uma conta$")
	public void queDesejoAdicionarUmaConta() throws Throwable {
		driver = new ChromeDriver();
	    driver.get("https://srbarriga.herokuapp.com");
	    driver.findElement(By.id("email")).sendKeys("a@a");
	    driver.findElement(By.name("senha")).sendKeys("a");
	    driver.findElement(By.tagName("button")).click();
	    String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Bem vindo, wagner!", texto);
	    driver.findElement(By.linkText("Contas")).click();
	    driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^adiciono a conta \"([^\"]*)\"$")
	public void adicionoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
		driver.findElement(By.tagName("button")).click();
	}
	
	//Ordem de execução 'order'. Nos Before ele começa no 0 e termina nos maiores. Nos Afters a ordem é oposta, ele inicia nos numeros mais autos e termina na order 0
	@Before(order=10)
	public void inicio() {
		System.out.println("Começando aqui");
	}
	
	@Before(order=0)
	public void inicio2() {
		System.out.println("Começando aqui, parte 2");
	}
	
//	@After(order=1, value = {"~@unitários"})
	@After(order=1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		java.io.File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	@After(order=0, value = {"~@unitários"})
	@After(order=0, value = "@funcionais")
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminando");
	}

}
