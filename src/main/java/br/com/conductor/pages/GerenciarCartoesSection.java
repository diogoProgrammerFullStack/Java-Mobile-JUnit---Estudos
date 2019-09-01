package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GerenciarCartoesSection {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Bloquear Cartão']")
	private MobileElement bloquearCartao;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancelar Cartão']")
	private MobileElement cancelarCartao;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Alterar Senha']")
	private MobileElement alterarSenha;
	
	public MobileElement getBloquearCartao() {
		return bloquearCartao;
	}

	public MobileElement getCancelarCartao() {
		return cancelarCartao;
	}

	public MobileElement getAlterarSenha() {
		return alterarSenha;
	}

	public GerenciarCartoesSection(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
}
