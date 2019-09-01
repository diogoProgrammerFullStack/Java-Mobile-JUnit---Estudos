package br.com.conductor.commons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class AppiumRobot extends DriverFactory {

	public String clicar;
	
	/**
	 * Swipe vertical
	 * 
	 * @param startPercentage
	 * @param finalPercentage
	 * @param duration
	 */
	public static void swipeVertical(double startPercentage, double finalPercentage, int duration) {

		try {
			TouchAction action = new TouchAction((PerformsTouchActions) driver);
			Dimension size = driver.manage().window().getSize();
			int width = (int) (size.width / 2);
			int startPoint = (int) (size.height * startPercentage);
			int endPoint = (int) (size.getHeight() * finalPercentage);
			action.press(width, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(width, endPoint).release()
					.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Move para baixo ate o elemento aparecer
	 * 
	 * @param xpath
	 */
	public static void swipeDown(String xpath) {

		try {
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = (int) (size.width / 2);
			int startPoint = (int) (size.height - 10);
			int endPoint = (int) (10);
			while (elementExists(xpath) == false) {
				action.press(width, startPoint).waitAction(Duration.ofSeconds(4)).moveTo(width, endPoint).release()
						.perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Date Picker - Clicar por texto/data
	 * @param text
	 */
	
	public static void clicar(By by) {
		getDriver().findElement(by).click();
		
	}
	
	public static void clicarPorTexto(String text) {
		clicar(By.xpath("//*[@text='"+text+"')"));
	}

	/**
	 * Valida se o elemento existe na pagina
	 * 
	 * @param xpath
	 * @return
	 */
	private static boolean elementExists(String xpath) {
		return driver.findElements(By.xpath(xpath)).size() != 0;
	}

	/**
	 * Valida se o elemento existe na pagina - Metodo 2
	 * 
	 * @param xpath
	 * @return
	 */
	public static boolean waitElementDisappear(String xpath) {
		return driver.findElements(By.xpath(xpath)).isEmpty();
	}

	/**
	 * Espera um elemento visivel
	 * 
	 * @param webElement
	 */
	public static void waitElementToBeVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	/**
	 * Espera implicitamente um elemento ser visivel
	 * 
	 * @param timeout
	 */
	public static void implicityWait(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	/**
	 * Swipe por elemento ate elemento
	 * 
	 * @param startElement
	 * @param endElement
	 */
	public static void swipeByElements(MobileElement startElement, MobileElement endElement) {

		try {
			TouchAction actions = new TouchAction(driver);
			actions.longPress(startElement).moveTo(endElement).release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Swipe horizontal conforme posicao
	 * 
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public static void swipeHorizontal(int startX, int startY, int endX, int endY) {

		try {
			TouchAction action = new TouchAction(driver);
			action.press(startX, endY).waitAction(Duration.ofMillis(2000)).moveTo(startX, endY).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Espera elemento desaparecer da tela
	 * 
	 * @param element
	 */
	public static void waitElementDisapper(MobileElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
