package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage {
	
	@AndroidFindBy(accessibility="lg_txt_login")
	@iOSFindBy(xpath="")
	private MobileElement inputCpf;
	
	@AndroidFindBy(accessibility="lg_txt_password")
	
	private MobileElement inputPassword;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='CONTINUAR']")
	 
	private MobileElement buttonContinuar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Ops!']")
	private MobileElement txtOpsModal;
	
	@AndroidFindBy(xpath="//android.widget.TextView[2][@text='CPF inválido']")
	private MobileElement textCpfInvalid;
	
	/*
	 * 
	 * 
	 * Constructor
	 * 
	 * 
	 */

	public LoginPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS),  this);
	}

	//*******************************getters and setters*******************************//

	public MobileElement getTextCpfInvalid() {
		return textCpfInvalid;
	}

	public MobileElement getTxtOpsModal() {
		return txtOpsModal;
	}

	public MobileElement getInputCpf() {
		return inputCpf;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}
	
	public void setInputCpf(MobileElement inputCpf) {
		this.inputCpf = inputCpf;
	}

	public void setInputPassword(MobileElement inputPassword) {
		this.inputPassword = inputPassword;
	}

	public WebElement getButtonContinuar() {
		return buttonContinuar;
	}
}
