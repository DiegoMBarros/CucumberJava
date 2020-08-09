package br.df.dmbarros.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {
//	@Given("^que eu criei o arquivo corretamente$")
//	public void que_eu_criei_o_arquivo_corretamente() throws Throwable {
//		System.out.println("passou aqui!");
//	}
//
//	@When("^executá-lo$")
//	public void executá_lo() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
//
//	@Then("^a especificação deve finalizar com sucesso$")
//	public void a_especificação_deve_finalizar_com_sucesso() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
//	}
	
//	@Dado("^que eu criei o arquivo corretamente$")
//	public void que_eu_criei_o_arquivo_corretamente() throws Throwable {
//	   
//	}
//
//	@Quando("^executá-lo$")
//	public void executá_lo() throws Throwable {
//	    
//	}
//
//	@Então("^a especificação deve finalizar com sucesso$")
//	public void a_especificação_deve_finalizar_com_sucesso() throws Throwable {
//	    
//	}
	@Dado("^que eu criei o arquivo corretamente$")
	public void queEuCrieiOArquivoCorretamente() throws Throwable {
	    System.out.println("passei aqui");
	}

	@Quando("^executá-lo$")
	public void executaLo() throws Throwable {
	    
	}

	@Entao("^a especificação deve finalizar com sucesso$")
	public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {
	    
	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorE(int arg1) throws Throwable {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Entao("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSera(int arg1) throws Throwable {
//	    System.out.println(arg1);
//	    System.out.println(contador);
//	    System.out.println(arg1 == contador);
//	    Assert.assertTrue(arg1 == contador);
	    Assert.assertEquals(arg1, contador);
//	    throw new RuntimeException();
	}
	
	Date entrega = new Date();
//	@Dado("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
//	@Dado("^que a entrega é dia (.*)$")
	@Dado("que a entrega é dia {data}")
//	public void queAEntregaÉDia(int dia, int mes, int ano) throws Throwable {
//	public void queAEntregaEDia(@Transform(DateConverter.class) Date data) throws Throwable {
	public void queAEntregaEDia(Date data) throws Throwable {
//	    Calendar cal = Calendar.getInstance();
//	    cal.set(Calendar.DAY_OF_MONTH, dia);
//	    cal.set(Calendar.MONTH, mes - 1);
//	    cal.set(Calendar.YEAR, ano);
//	    entrega = cal.getTime();
		entrega = data;
		System.out.println(entrega);
	}

//	@Quando("^a entrega atrasar (\\d+) dias$")
//	@Quando("^a entrega atrasar (\\d+) (.+)$")
	@Quando("^a entrega atrasar (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarDias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    entrega = cal.getTime();
	}

	@Entao("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeraEfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    Assert.assertEquals(data, dataFormatada);
	}
	
//	@Dado("^que o ticket é AF(\\d+)$")
//	@Dado("^que o ticket é A.(\\d+)$")
//	@Dado("^que o ticket( especial)? é A.(\\d+)$")
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
//	public void queOTicketÉAF(int arg1) throws Throwable {
	public void queOTicketEAF(String tipo, String arg1) throws Throwable {
	    
	}
	
	@Dado("^que o ticket é CD(\\d+)$")
	public void queOTicketECD(String arg1) throws Throwable {
	    
	}
	
	@Dado("^que o ticket é AG(\\d{4})$")
	public void queOTicketEAG(String arg1) throws Throwable {
	    
	}

//	@Dado("^que o valor da passagem é R\\$ (\\d+),(\\d+)$")
	@Dado("^que o valor da passagem é R\\$ (.*)$")
//	public void queOValorDaPassagemÉR$(int arg1, int arg2) throws Throwable {
	public void queOValorDaPassagemER$(Double numero) throws Throwable {
	    System.out.println(numero);
	}

//	@Dado("^que o nome do passageiro é \"([^\"]*)\"$")
//	@Dado("^que o nome do passageiro é \"(.*)\"$") // o '.*' é para aceitar qualquer caractere
//	@Dado("^que o nome do passageiro é \"(.{5,20})\"$") //Limita o tamanho de 5 a 20 caracteres
	@Dado("^que o nome do passageiro é \"(.{5,41})\"$") //Limita o tamanho de 5 a 20 caracteres
	public void queONomeDoPassageiroE(String arg1) throws Throwable {
	   
	}

//	@Dado("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$") //d{3} informa que aceitara 3 int
	public void queOTelefoneDoPassageiroE(String telefone) throws Throwable {
	   
	}
	
	@Dado("^que o telefone do passageiro é (1\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroE1(String telefone) throws Throwable {
	   
	}
	
	@Dado("^que o telefone do passageiro é (9\\d{2}-\\d{4})$")
	public void queOTelefoneDoPassageiroE9(String telefone) throws Throwable {
	   
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	    
	}

	@Entao("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	   
	}

}
