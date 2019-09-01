package tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.conductor.actions.LoginTestAction;
import br.com.conductor.actions.LogoutTestAction;
import br.com.conductor.commons.BaseTest;
import br.com.conductor.commons.DriverFactory;
import br.com.conductor.massa.MassaQAJson;

public class LogoutTest extends BaseTest{
	
	private LoginTestAction loginTestAction;
	private LogoutTestAction logoutTestAction;
	
	public LogoutTest() {
		this.loginTestAction = new LoginTestAction();
		this.logoutTestAction = new LogoutTestAction();
	}
	
	@Before
	public void inicializaAppium() {

		System.out.println("Appium iniciado");
		driver = DriverFactory.getDriver();

	}
	
	@Test
	public void testLogout() {

		loginTestAction.clicarLogin();
		MassaQAJson massa = new MassaQAJson();
		loginTestAction.logAppCpfSenha(massa.login, massa.senha);
		String textTitleResults = logoutTestAction.clicarSair();
		assertNotNull(textTitleResults);	
		
	}
}
