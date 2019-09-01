package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class IntroPage {

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Ben-vindo')]")
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@value='Ben-vindo']")
	private MobileElement bemVindoInicial;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FAZER LOGIN']")
	@iOSFindBy(id = "")
	private MobileElement buttonFazerLogin;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CADASTRAR NO BEN']")
	@iOSFindBy()
	private MobileElement buttonCadastrarBen;

	/*
	 * 
	 * Constructor
	 * 
	 */

	public IntroPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}

	// *******************************getters and
	// setters*******************************//

	public MobileElement getButtonFazerLogin() {
		return buttonFazerLogin;
	}

	public MobileElement getButtonCadastrarBen() {
		return buttonCadastrarBen;
	}

	public MobileElement getBemVindoInicial() {
		return bemVindoInicial;
	}

}
