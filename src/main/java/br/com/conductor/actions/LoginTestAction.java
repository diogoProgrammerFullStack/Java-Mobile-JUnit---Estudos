package br.com.conductor.actions;

import br.com.conductor.commons.BaseTest;
import br.com.conductor.pages.HomePage;
import br.com.conductor.pages.IntroPage;
import br.com.conductor.pages.LoginPage;

public class LoginTestAction extends BaseTest{
	
	/**
	 * Metodo somente para clicar no botao "fazer login" para usar em todos os testes. (Reuso de codigo)
	 */
	
	
	public void clicarLogin() {
		
		IntroPage introPage = new IntroPage(driver);
		introPage.getButtonFazerLogin().click();
	}
	
	/**
	 * metodo de login com cpf senha
	 * @param user
	 * @param password
	 */
	
	public void logAppCpfSenha(String user, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getInputCpf().setValue(user);
		loginPage.getInputPassword().sendKeys(password);
		loginPage.getButtonContinuar().click();
		
	}
	
	/**
	 * 
	 * @return texto de cpf invalido
	 */
	
	public String testeLoginCpfInvalido() {
		
		LoginPage loginPage = new LoginPage(driver);
		String text = loginPage.getTextCpfInvalid().getText();
		return text;
	}
	
	/**
	 * 
	 * @return texto (titutlo da pagina) home apos logado
	 */

	public String testeLoginSucesso() {

		HomePage homePage = new HomePage(driver);
		String textTitleResults = homePage.getTextTitleHome().getText();
		return textTitleResults;
	}
	
	/**
	 * 
	 * @return texto modal de senha invalida
	 */

	public String testeSenhaDivergente() {
		
		LoginPage loginPage = new LoginPage(driver);
		String txtOpsModal = loginPage.getTxtOpsModal().getText();
		return txtOpsModal;
	}

}
