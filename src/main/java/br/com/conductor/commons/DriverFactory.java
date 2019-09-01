package br.com.conductor.commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverFactory extends BaseTest {

	/**
	 * Metodo que constroi driver Android ou iOS
	 * @return driver
	 */
	
	public static AppiumDriver<WebElement> getDriver() {
		if (driver == null) {
			creatDriverAndroid();
//			creatDriverIOS();
		}

		return driver;
	}

	private static void creatDriverAndroid() {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");	
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		capability.setCapability(MobileCapabilityType.APP,
				"/Users/diogo.oliveira/eclipse-workspace/br.com.portador/src/main/resources/app-release-qa.apk");

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
//	private static void creatDriverIOS() {
//
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setCapability(MobileCapabilityType.UDID, "CA75A496-A776-4A94-9862-D3ADAF20997B");
//		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
//		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");	
//		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
//		capability.setCapability(MobileCapabilityType.APP,
//				"/Users/diogo.oliveira/eclipse-workspace/br.com.portador/src/main/resources/app-release-qa (5).apk");
//
//		try {
//			driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Metodo mata o driver e retorna valor null nele
	 */

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	/**
	 * Start Server Appium automatico (Configurar caminho do appium e node.js que esta instalado na maquina)
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
	 * Stop Server Appium
	 */
	
	/*
	 * public void stopServer() { String[] command = { "/usr/bin/killall", "-KILL",
	 * "node" }; try { Runtime.getRuntime().exec(command);
	 * System.out.println("Appium server stopped"); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
