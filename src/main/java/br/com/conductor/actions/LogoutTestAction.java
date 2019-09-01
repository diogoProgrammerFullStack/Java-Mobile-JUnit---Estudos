package br.com.conductor.actions;

import br.com.conductor.commons.BaseTest;
import br.com.conductor.pages.HomePage;
import br.com.conductor.pages.IntroPage;

public class LogoutTestAction extends BaseTest{

	public String clicarSair() {
		HomePage homePage = new HomePage(driver);
		homePage.getButtonMenu().click();
		homePage.getButtonMenuLogout().click();
		IntroPage introPage = new IntroPage(driver);
		String titleResults = introPage.getBemVindoInicial().getText();
		return titleResults;
	}
}
