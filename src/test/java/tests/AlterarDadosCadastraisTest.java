package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.conductor.actions.AlterarDadosCadastraisAction;
import br.com.conductor.actions.LoginTestAction;
import br.com.conductor.commons.AppiumRobot;
import br.com.conductor.commons.BaseTest;
import br.com.conductor.commons.DriverFactory;
import br.com.conductor.massa.MassaQAJson;

public class AlterarDadosCadastraisTest extends BaseTest {

	private LoginTestAction loginTestAction;
	
	public AlterarDadosCadastraisTest() {
		this.loginTestAction = new LoginTestAction();
	}
	
	@Before
	public void inicializaAppium() {

		System.out.println("Appium iniciado");
		driver = DriverFactory.getDriver();

	}

	@Test
	public void testeAlterarDadosCadastraisComSucesso() {
		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginValido2, massa.senha);
		String testResult = loginTestAction.testeLoginSucesso();
		assertNotNull(testResult);
		AlterarDadosCadastraisAction alterarDadosCadastraisAction = new AlterarDadosCadastraisAction();
		alterarDadosCadastraisAction.clicarAlterarDadosCadastrais();
		String txtResults = alterarDadosCadastraisAction.alteracaoDadosCadastrais("Diogo Teste", "11958930290", "diogo.oliveira@conductor.com.br");
		assertEquals("Dados alterados com sucesso".toLowerCase(), txtResults.toLowerCase());
	}

	@Test
	public void testeAlterarDadosCadastraisNomeInvalido() {
		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginValido2, massa.senha);
		AlterarDadosCadastraisAction alterarDadosCadastraisAction = new AlterarDadosCadastraisAction();
		alterarDadosCadastraisAction.clicarAlterarDadosCadastrais();
		alterarDadosCadastraisAction.alterarDadosCadastraisNomeInvalido("teste123");
		AppiumRobot.implicityWait(3000);
		String txtNomeInvalidoResults = alterarDadosCadastraisAction.recuperarValorNomeInvalidoDadosCadastrais();
		assertNotNull(txtNomeInvalidoResults);
	}
	
	@Test
	public void testeAlterarDadosCadastraisNumeroInvalido() {
		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginValido2, massa.senha);
		AlterarDadosCadastraisAction alterarDadosCadastraisAction = new AlterarDadosCadastraisAction();
		alterarDadosCadastraisAction.clicarAlterarDadosCadastrais();
		alterarDadosCadastraisAction.alterarDadosCadastraisNumeroInvalido();
		AppiumRobot.implicityWait(3000);
		String txtNumeroInvalidoResults = alterarDadosCadastraisAction.recuperarValorNumeroInvalidoDadosCadastrais();
		assertNotNull(txtNumeroInvalidoResults);
	}
	
	@Test
	public void testeAlterarDadosCadastraisEmailInvalido() {
		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginValido2, massa.senha);
		AlterarDadosCadastraisAction alterarDadosCadastraisAction = new AlterarDadosCadastraisAction();
		alterarDadosCadastraisAction.clicarAlterarDadosCadastrais();
		alterarDadosCadastraisAction.alterarDadosCadastraisEmailInvalido("abcde");
		AppiumRobot.implicityWait(3000);
		String txtNumeroInvalidoResults = alterarDadosCadastraisAction.recuperaValorEmailInvalidoDadosCadastrais();
		assertNotNull(txtNumeroInvalidoResults);
	}
	
}
