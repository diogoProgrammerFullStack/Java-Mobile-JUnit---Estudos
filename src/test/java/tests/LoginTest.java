package tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.conductor.actions.LoginTestAction;
import br.com.conductor.commons.BaseTest;
import br.com.conductor.commons.DriverFactory;
import br.com.conductor.massa.MassaQAJson;

/**
 * 
 * @author diogo.oliveira
 *
 */

public class LoginTest extends BaseTest {

	private LoginTestAction loginTestAction;
	
	public LoginTest() {
		this.loginTestAction = new LoginTestAction();
	}

	@Before
	public void inicializaAppium() {

		System.out.println("Appium iniciado");
		driver = DriverFactory.getDriver();

	}

	@Test
	public void testeLoginSucesso() {

		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginValido2, massa.senha);
		String testResult = loginTestAction.testeLoginSucesso();
		assertNotNull(testResult);

	}

	@Test
	public void testeSenhaDivergente() {

		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.login, massa.senhaDivergente);
		String txtOpsModal = loginTestAction.testeSenhaDivergente();
		assertNotNull(txtOpsModal);
		
	}

	@Test
	public void testeLoginCpfInvalido() {

		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.loginInvalido, massa.senha);
		String text = loginTestAction.testeLoginCpfInvalido();
		assertNotNull(text);

	}
}
