package br.com.conductor.commons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public abstract class BaseTest {
	
	public static AppiumDriver<WebElement> driver;
	public static WebDriverWait wait;
	
	/**
	 * Rule para consumir nome do metodo teste para inserir em nome da evidencia
	 */
	
	@Rule
	public TestName testName = new TestName();
	
	/**
	 * Metodo que gera screenshot a partir do nome do metodo @Test
	 */
	
	public void geraScreenShot() {
		File img = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(img, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * reseta app sem terminar instancia do appium, apenas reiniciando app e executando novo teste
	 */
	
	@After
	public void tearDown() {		
		System.out.println("Gerando evidencia");
		geraScreenShot();
		System.out.println("Resetando app para execucao do proximo teste");
		DriverFactory.getDriver().resetApp();
	}
	
	/**
	 * Apos execucao de todas as classes de teste, finaliza instancia do driver appium
	 */
	@AfterClass
	public static void finalizaDriver() {
		System.out.println("Finalizando");
		DriverFactory.killDriver();
	}

	/**
	 * Start Server Appium automatico
	 */

	/*
	 * public void startServer() { CommandLine command = new
	 * CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
	 * command.addArgument(
	 * "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js",
	 * false); command.addArgument("--address", false);
	 * command.addArgument("127.0.0.1"); command.addArgument("--port", false);
	 * command.addArgument("4723"); command.addArgument("--full-reset", false);
	 * command.addArgument("wd"); command.addArgument("hub");
	 * DefaultExecuteResultHandler resultaHandler = new
	 * DefaultExecuteResultHandler(); DefaultExecutor executor = new
	 * DefaultExecutor(); executor.setExitValue(1); try { executor.execute(command,
	 * resultaHandler); Thread.sleep(5000);
	 * System.out.println("Appium server started"); } catch (IOException e) {
	 * e.printStackTrace(); } catch (InterruptedException e) { e.printStackTrace();
	 * } }
	 */

	/**
	 * Stop Server Appium automatico
	 */
	
	/*
	 * public void stopServer() { String[] command = { "/usr/bin/killall", "-KILL",
	 * "node" }; try { Runtime.getRuntime().exec(command);
	 * System.out.println("Appium server stopped"); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
