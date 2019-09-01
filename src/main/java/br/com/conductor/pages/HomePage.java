package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Tudo Ben, Teste :)']")
	private MobileElement textTitleHome;
	
	@AndroidFindBy(accessibility="hm_btn_menu")
	private MobileElement buttonMenu;
	
	@AndroidFindBy(accessibility="hm_btn_logout")
	private MobileElement buttonMenuLogout;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Alterar dados cadastrais']")
	private MobileElement buttonAlterarDadosCadastrais;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Buscar estabelecimentos']")
	private MobileElement buttonBuscarEc;
	
	@AndroidFindBy(accessibility="home-card-0")
	private MobileElement cardRefeicao;
	
	@AndroidFindBy(accessibility="home-card-1")
	private MobileElement cardAlimentacao;
	
	@AndroidFindBy(accessibility="hm_btn_add_card")
	private MobileElement funcaoAtivarNovoCartao;
	
	
	
	/*
	 * 
	 * Constructor
	 * 
	 */

	public HomePage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	
	//*******************************getters and setters*******************************//
	
	public MobileElement getTextTitleHome() {
		return textTitleHome;
	}

	public MobileElement getButtonMenu() {
		return buttonMenu;
	}

	public MobileElement getButtonMenuLogout() {
		return buttonMenuLogout;
	}
	
	public MobileElement getButtonAlterarDadosCadastrais() {
		return buttonAlterarDadosCadastrais;
	}

	public MobileElement getButtonBuscarEc() {
		return buttonBuscarEc;
	}

	public MobileElement getCardRefeicao() {
		return cardRefeicao;
	}

	public MobileElement getCardAlimentacao() {
		return cardAlimentacao;
	}

	public MobileElement getFuncaoAtivarNovoCartao() {
		return funcaoAtivarNovoCartao;
	}

}
