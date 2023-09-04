package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserEmbargoGeneralPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserEmbargoGeneralPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserArtikelstammAddOrEditPage uaaep;
	UserEmbargoGeneralPage uegp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(priority = 2)
	public void checkWeatherCanAddEmbargoCountry_TC56116i()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uegp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		int allLanderTableSize = uegp.getTableSizeOfLanderubersicht();
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.waitForEmbargoNotificationMessage();
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Embargo erfolgreich aktualisiert",
				":: Country added message not as expected");
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		Assert.assertEquals(uegp.getTableSizeOfLanderListeLanderTable(), allLanderTableSize,
				":: Selected country number Not As Expected");
	}
	
	@Test(priority = 1)
	public void verifyToDeleteSelectedEmbargoCountry_TC56117()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uegp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		uegp.clickOnSelectAllSelectedCountryRadioButton();
		uegp.clcickOnSelectedCountryLoschenButton();
		gu.alertAccept(driver);
		uegp.waitForEmbargoNotificationMessage();		
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Gelöscht",
				":: Country added message not as expected");

	}

	@Test(priority = 2)
	public void checkWeatherCanAddEmbargoCountry_TC56116()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		uegp = new UserEmbargoGeneralPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uegp.clickOnEmbargoButton();
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(1);
		int allLanderTableSize = uegp.getTableSizeOfLanderubersicht();
		for (int i = 0; i < uegp.getTableSizeOfLanderubersicht(); i++) {
			uegp.selectLanderubersichtTableRows(i);
		}
		uegp.clickOnHinzufugenButton();
		uegp.waitForEmbargoNotificationMessage();
		Assert.assertEquals(uegp.readEmbargoNotificationMessage(), "Embargo erfolgreich aktualisiert",
				":: Country added message not as expected");
		uegp.clickOnLanderubersicht();
		uegp.clickOnDropDownOfLanderListe(2);
		Assert.assertEquals(uegp.getTableSizeOfLanderListeLanderTable(), allLanderTableSize,
				":: Selected country number Not As Expected");
	}
}
