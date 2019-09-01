package br.com.conductor.actions;

import br.com.conductor.commons.BaseTest;
import br.com.conductor.pages.AlterarDadosCadastraisPage;
import br.com.conductor.pages.HomePage;

public class AlterarDadosCadastraisAction extends BaseTest {
	
	private HomePage homePage;
	
	public AlterarDadosCadastraisAction() {
		this.homePage = new HomePage(driver);
	}
	/**
	 * Metodo click em alterar dados cadastrais no menu
	 */
	public void clicarAlterarDadosCadastrais() {
		homePage.getButtonMenu().click();
		homePage.getButtonAlterarDadosCadastrais().click();		
	}
	
	/**
	 * Metodo parametrizavel altera dados cadastrais 
	 * @param nome
	 * @param celular
	 * @param email
	 * @return
	 */
	public String alteracaoDadosCadastrais(String nome, String celular, String email) {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		alterarDadosCadastraisPage.getInputNome().clear();
		alterarDadosCadastraisPage.getInputNome().sendKeys(nome);
		alterarDadosCadastraisPage.getInputCel().clear();
		alterarDadosCadastraisPage.getInputCel().sendKeys(celular);
		alterarDadosCadastraisPage.getInputEmail().clear();
		alterarDadosCadastraisPage.getInputEmail().sendKeys(email);
		alterarDadosCadastraisPage.getButtonSalvar().click();
		String txtResults = alterarDadosCadastraisPage.getMsgAlteracaoEfetuada().getText();
		return txtResults;
		
	}
	
	/**
	 * Metodo altera dados cadastrais com nome invalido
	 * @param nome
	 */
	
	public void alterarDadosCadastraisNomeInvalido(String nome) {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		alterarDadosCadastraisPage.getInputNome().clear();
		alterarDadosCadastraisPage.getInputNome().sendKeys(nome);
		alterarDadosCadastraisPage.getButtonSalvar().click();
	}
	
	/**
	 * Metodo altera dados cadastrais com numero invalido
	 */
	
	public void alterarDadosCadastraisNumeroInvalido() {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		alterarDadosCadastraisPage.getInputCel().clear();
		alterarDadosCadastraisPage.getButtonSalvar().click();
	}
	
	/**
	 * Metodo altera dados cadastrais com e-mail invalido
	 * @param email
	 */
	
	public void alterarDadosCadastraisEmailInvalido(String email) {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		alterarDadosCadastraisPage.getInputEmail().clear();
		alterarDadosCadastraisPage.getInputEmail().sendKeys(email);
		alterarDadosCadastraisPage.getButtonSalvar().click();
	}
	
	/**
	 * Metodo de alteracao dados cadastrais sem prosseguir - apenas preenchimento dos campos
	 * @param nome
	 * @param celular
	 * @param email
	 */
	
	public void alteracaoDadosCadastraisSemProssseguir(String nome, String celular, String email) {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		alterarDadosCadastraisPage.getInputNome().clear();
		alterarDadosCadastraisPage.getInputNome().sendKeys(nome);
		alterarDadosCadastraisPage.getInputCel().clear();
		alterarDadosCadastraisPage.getInputCel().sendKeys(celular);
		alterarDadosCadastraisPage.getInputEmail().clear();
		alterarDadosCadastraisPage.getInputEmail().sendKeys(email);
	}
	
	/**
	 * 
	 * @return texto exibido quando nome invalido
	 */
	
	public String recuperarValorNomeInvalidoDadosCadastrais() {
		
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		return alterarDadosCadastraisPage.getTxtNomeInvalido().getText();
		
	}
	
	/**
	 * 
	 * @return texto exibido quando numero invalido
	 */
	
	public String recuperarValorNumeroInvalidoDadosCadastrais() {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		return alterarDadosCadastraisPage.getTxtNumeroInvalido().getText();
	}
	
	/**
	 * 
	 * @return texto exibido quando email invalido
	 */
	
	public String recuperaValorEmailInvalidoDadosCadastrais() {
		AlterarDadosCadastraisPage alterarDadosCadastraisPage = new AlterarDadosCadastraisPage(driver);
		return alterarDadosCadastraisPage.getTxtEmailInvalido().getText();
	}

}
