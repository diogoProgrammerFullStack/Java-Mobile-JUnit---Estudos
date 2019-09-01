package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlterarDadosCadastraisPage {
	
	@AndroidFindBy(accessibility="ed_txt_name")
	private MobileElement inputNome;
	
	@AndroidFindBy(accessibility="ed_txt_phone")
	private MobileElement inputCel;
	
	@AndroidFindBy(accessibility="ed_txt_email")
	private MobileElement inputEmail;
	
	@AndroidFindBy(accessibility="ed_btn_save")
	private MobileElement buttonSalvar;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Dados alterados com sucesso']")
	private MobileElement msgAlteracaoEfetuada;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Nome inválido']")
	private MobileElement txtNomeInvalido;
	
	@AndroidFindBy(accessibility="ed_txt_cpf")
	private MobileElement inputCpf;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Celular inválido')]")
	private MobileElement txtNumeroInvalido;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'E-mail inválido')]")
	private MobileElement txtEmailInvalido;
	
	//************************ getters and setters ************************//
	
	public MobileElement getTxtEmailInvalido() {
		return txtEmailInvalido;
	}

	public MobileElement getTxtNumeroInvalido() {
		return txtNumeroInvalido;
	}

	public void setTxtNumeroInvalido(MobileElement txtNumeroInvalido) {
		this.txtNumeroInvalido = txtNumeroInvalido;
	}

	public void setInputCpf(MobileElement inputCpf) {
		this.inputCpf = inputCpf;
	}

	public MobileElement getInputCpf() {
		return inputCpf;
	}

	public MobileElement getTxtNomeInvalido() {
		return txtNomeInvalido;
	}

	public MobileElement getMsgAlteracaoEfetuada() {
		return msgAlteracaoEfetuada;
	}

	public MobileElement getInputNome() {
		return inputNome;
	}

	public void setInputNome(MobileElement inputNome) {
		this.inputNome = inputNome;
	}

	public MobileElement getInputCel() {
		return inputCel;
	}

	public void setInputCel(MobileElement inputCel) {
		this.inputCel = inputCel;
	}

	public MobileElement getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(MobileElement inputEmail) {
		this.inputEmail = inputEmail;
	}

	public MobileElement getButtonSalvar() {
		return buttonSalvar;
	}

	public AlterarDadosCadastraisPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
}
