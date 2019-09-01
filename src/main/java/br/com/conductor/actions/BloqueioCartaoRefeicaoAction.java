package br.com.conductor.actions;

import br.com.conductor.commons.AppiumRobot;
import br.com.conductor.commons.BaseTest;
import br.com.conductor.pages.HomePage;
import br.com.conductor.pages.RefeicaoPage;

public class BloqueioCartaoRefeicaoAction extends BaseTest {
	
	private RefeicaoPage refeicaoPage;
	private HomePage homePage;
	
	public BloqueioCartaoRefeicaoAction() {
		this.refeicaoPage = new RefeicaoPage(driver);
		this.homePage = new HomePage(driver);
	}
	
	public void clicarCartaoRefeicao(String data) {
		this.homePage.getCardAlimentacao().click();
		this.refeicaoPage.getMenuPrincipal().click();
		this.refeicaoPage.getGerenciamentoCartao().click();
		this.refeicaoPage.getGerenciarCartoesSections().getBloquearCartao().click();
		this.refeicaoPage.getBloqueioCartaoSection().getInputDataDesbloqueioAutomatico().click();
		AppiumRobot.clicarPorTexto(data);
		this.refeicaoPage.getBloqueioCartaoSection().getSelectDate().click();
		this.refeicaoPage.getBloqueioCartaoSection().getButtonSimBloquearCartao().click();
	}
	
	/**
	 * metodo a fazer
	 * @return
	 */
	public String recuperaTxtCartaoBloqueadoSucesso() {
		
		return null;
	}
}
