package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BloqueioCartaoSection {
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"confirm-block-card\"]/android.view.ViewGroup")
	private MobileElement inputDataDesbloqueioAutomatico;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='MANTER LIBERADO']")
	private MobileElement buttonManterLiberado;
	
	@AndroidFindBy(accessibility="//android.widget.TextView[@text='SIM, BLOQUEAR CARTÃO']")
	private MobileElement buttonSimBloquearCartao;
	
	@AndroidFindBy(id="android:id/button1")
	private MobileElement buttonOkDate;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Tudo certo!')]")
	private MobileElement txtCartaoBloqueadoSucesso;
	
	@AndroidFindBy(accessibility="status_modal_btn_primary")
	private MobileElement buttonConcluir;
	
	public MobileElement getButtonConcluir() {
		return buttonConcluir;
	}

	public MobileElement getButtonOkDate() {
		return buttonOkDate;
	}

	public MobileElement getTxtCartaoBloqueadoSucesso() {
		return txtCartaoBloqueadoSucesso;
	}

	public MobileElement getSelectDate() {
		return buttonOkDate;
	}

	public MobileElement getInputDataDesbloqueioAutomatico() {
		return inputDataDesbloqueioAutomatico;
	}

	public MobileElement getButtonManterLiberado() {
		return buttonManterLiberado;
	}

	public MobileElement getButtonSimBloquearCartao() {
		return buttonSimBloquearCartao;
	}

	public BloqueioCartaoSection(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
}
