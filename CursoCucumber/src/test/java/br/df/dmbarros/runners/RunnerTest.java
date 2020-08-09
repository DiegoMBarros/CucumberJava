package br.df.dmbarros.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "src/test/resources/features/inserir_conta.feature",
		features = "src/test/resources/features/",
		glue = {"br.df.dmbarros.steps", "br.df.dmbarros.config"},
		tags = "@unitários", //{"~@ignore", "not @ignore}, //{"@tipo1", "@tipo2"} => aqui ele só executará o que tiver obrigatoriamente com as duas tags.
		plugin = {"pretty", "html:\\target\\report-html", "json:\\target\\report-json"},
		monochrome = true, //true para retirar as cores
		snippets = SnippetType.CAMELCASE,
		dryRun = false //,true or false -> não realiza a execução, ajuda a identificar os passos não implementados
		//strict = false //Se "true" os passos não implementados serão tratados como erro.
		)
public class RunnerTest {
/*Para executar pela linha de comando, primeiro acessar a pasta do projeto.
 * Para executar o teste, pelo console, executar o comando 'mvn test' para rodar tudo.
 * Para executar uma feature, executar o comando 'mvn test -Dcucumber.options="src/test/resources/features/aprender_cucumber.feature"'
 */
}
