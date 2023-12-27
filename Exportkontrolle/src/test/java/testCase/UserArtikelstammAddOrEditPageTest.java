package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.UserArtikelstammAddOrEditPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;

public class UserArtikelstammAddOrEditPageTest extends BaseClass {
	LoginPage lp;
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	UserArtikelstammPage uasp;
	UserArtikelstammAddOrEditPage uaaep;

	@Test(groups="run")
	public void checkAlNumTriftNitchZuAusfuhrlistenGenehmigungTabColourTC53212Part1()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 5) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 5);
			}
		}
		uaaep.clickOnSpeichernButton();
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link green";
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
	}

	@Test//(enabled = false)
	public void checkAlNumTriftZuAusfuhrlistenGenehmigungTabColourTC53212Part2()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link red";
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
	}

	@Test//(enabled = false)
	public void checkAlNumTriftZuAusfuhrlistenGenehmigungTabColourTC53212Part3()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnGenehmigungTab();
		uaaep.SendUnterlagenCodierungValue();
		uaaep.clickOnSpeichernButton();
		String expectedAusfuhrlisten = "ausfuhrlisten breadcrumb-tab-link green";
		String actualAusfuhrlisten = uaaep.getAusfuhrlistenTabColour();
		Assert.assertEquals(actualAusfuhrlisten, expectedAusfuhrlisten,
				":: Ausfuhrlisten Tab colour while on trift nitch zu not as expected");
		String actualGenehmigungTabColour = uaaep.getGenehmigungTabColour();
		String expectedGenehmigungTabColour = "genehmigung breadcrumb-tab-link green";
		Assert.assertEquals(actualGenehmigungTabColour, expectedGenehmigungTabColour,
				":: Genehmigung Tab colour while on trift nitch zu not as expected");
	}

	@Test//(enabled = false)
	public void TC54998Part1_CheckAlNumTriftZuAtlasCoseStart3OrX_TC55804()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		Boolean status = false;
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAtlasUnterlagen();
		uaaep.clickOnAtlasVorgeschlagenTab();
		for (int i = 0; i < uaaep.getVorgeschlagenTableSize(); i++) {
			String atlasCode = uaaep.getVorgeschlagenTableElementText((i + 1), 2);
			if (atlasCode.length() > 0) {
				char firstChar = atlasCode.charAt(0);
				if (firstChar == '3' || firstChar == 'X') {
					status = true;
				} else {
					status = false;
				}
			}
			Assert.assertEquals(status, true, ":: Atlas code on trift zu not as expected");
		}
	}

	@Test//(groups = "Low", enabled = false)
	public void TC54998Part2CheckAlNumTriftNichtZuAtlasCoseStartY__TC55805()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		Boolean status = false;
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 5) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 5);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAtlasUnterlagen();
		uaaep.clickOnAtlasVorgeschlagenTab();
		for (int i = 0; i < uaaep.getVorgeschlagenTableSize(); i++) {
			String atlasCode = uaaep.getVorgeschlagenTableElementText((i + 1), 2);
			if (atlasCode.length() > 0) {
				char firstChar = atlasCode.charAt(0);
				if (firstChar == 'Y') {
					status = true;
				} else {
					status = false;
				}
			}
			Assert.assertEquals(status, true, ":: Atlas code on trift zu not as expected");
		}
	}

	@Test//(groups = "Low", enabled = false)
	public void TC54998Part4CheckNoAtlasCoseThenTabGreen__TC55876()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link green";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: There is No Atlas code then Atlas unterlagen tab colour not as expected");
	}

	@Test//(groups = "Low", enabled = false)
	public void TC54998Part4CheckAlNumTriftZuAtlasCoseIsRed__TC55877()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link red";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}

	@Test//(groups = "Low", enabled = false)
	public void TC54998Part5CheckAlNumTriftNichtZuAtlasCoseIsOrange__TC55878()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 5) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 5);
			}
		}
		uaaep.clickOnSpeichernButton();
		String actualAtlasUnterlagenTabColour = uaaep.getAtlasUnterlagenTabColour();
		String expectedAtlasUnterlagenTabColour = "atlas-unterlagen breadcrumb-tab-link yellow";
		Assert.assertEquals(actualAtlasUnterlagenTabColour, expectedAtlasUnterlagenTabColour,
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}

	@Test//(groups = "Low")
	public void TC54998Part6CheckAlNumNothingCheckedAtlasCoseIsGrey__TC55879()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uaaep = new UserArtikelstammAddOrEditPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(1000);
		uasp.waitUntilNewArtikelHinzufugenButtonClickable();
		uasp.clickOnNewArtikelHinzufugenButton();
		uasp.sendArtikelNummerOnTextField();
		uasp.sendWarennummerOnTextField("38260090");
		uasp.sendArtikelBezeichnungOnTextField();
		uasp.clickOnAddArtikelButton();
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link grey",
				":: Atlas unterlagen tab colour when trift zu not as expected");
		uaaep.clickOnAusfuhrlistenTab();
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 5) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 5);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 5) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 5);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link grey",
				":: Atlas unterlagen tab colour when trift zu not as expected");
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		uaaep.clickOnAusfuhrlistenTab();
		Thread.sleep(1000);
		for (int i = 0; i < uaaep.getAlNummerTableSize(); i++) {
			if (uaaep.checkAlNumberIsTriftZuTriftNitchZuCheckedOrNot((i + 1), 4) == false) {
				uaaep.clickOnAlNumberTriftZuTriftNitchZuCheckBox((i + 1), 4);
			}
		}
		uaaep.clickOnSpeichernButton();
		Assert.assertEquals(uaaep.getAtlasUnterlagenTabColour(), "atlas-unterlagen breadcrumb-tab-link grey",
				":: Atlas unterlagen tab colour when trift zu not as expected");
	}
}
