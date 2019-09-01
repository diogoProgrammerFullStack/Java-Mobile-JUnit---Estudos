package br.com.conductor.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RefeicaoPage {
	
	@AndroidFindBy(xpath="(//android.view.ViewGroup[@content-desc=\"dashboard_card_meal\"])[1]/android.widget.TextView[2]")
	private MobileElement saldoCard;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BUSCAR ESTABELECIMENTOS']")
	private MobileElement buscarEstabelecimentoIntroCard;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gerenciamento do cartão']")
	private MobileElement gerenciamentoCartao;
	
	@AndroidFindBy(accessibility="hm_btn_menu")
	private MobileElement menuPrincipal;
	
	public MobileElement getMenuPrincipal() {
		return menuPrincipal;
	}

	public MobileElement getGerenciamentoCartao() {
		return gerenciamentoCartao;
	}

	public MobileElement getSaldoCard() {
		return saldoCard;
	}

	public MobileElement getBuscarEstabelecimentoIntroCard() {
		return buscarEstabelecimentoIntroCard;
	}
	
	private GerenciarCartoesSection gerenciarCartoesSections;
	private BloqueioCartaoSection bloqueioCartaoSection;
	
	//**********Constructor**********//
	
	public RefeicaoPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		this.gerenciarCartoesSections = new GerenciarCartoesSection(driver);
		this.bloqueioCartaoSection = new BloqueioCartaoSection(driver);
	}
	//*** get Sections ***//
	
	public BloqueioCartaoSection getBloqueioCartaoSection() {
		return bloqueioCartaoSection;
	}

	public GerenciarCartoesSection getGerenciarCartoesSections() {
		return gerenciarCartoesSections;
	}
}
