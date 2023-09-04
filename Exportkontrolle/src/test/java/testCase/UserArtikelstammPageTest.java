package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.UserArtikelstammPage;
import elementRepository.LoginPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserArtikelstammPageTest extends BaseClass {
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	LoginPage lp;
	UserArtikelstammPage uasp;
	SoftAssert softAssert;
	GeneralUtilities gu = new GeneralUtilities();

	@Test//(enabled = false)
	public void verifyToPossibleCreateNewArtikel_TC54307ii()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		Thread.sleep(3000);
		for (int i = 0; i < 2; i++) {
			Thread.sleep(1000);
			uasp.waitUntilNewArtikelHinzufugenButtonClickable();
			uasp.clickOnNewArtikelHinzufugenButton();
			uasp.sendArtikelNummerOnTextField();
			uasp.sendWarennummerOnTextField();
			uasp.sendArtikelBezeichnungOnTextField();
			uasp.clickOnAddArtikelButton();
			uasp.waitForZuruckButtonClick();
			uasp.clickOnZuruckButton();
			String actual = uasp.getArtikelnummerCorrespondingNumber();
			String expected = uasp.getAtikelNummerForExpectedString();
			Assert.assertEquals(actual, expected, ":: Artikel name not as expected");
		}
	}

	@Test//(groups= "Run")
	public void verifyTheNumberOfArtikelSameAsInWarenstamPage_TC54307ii() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		for (int i = 0; i < uwp.getWarenstammTableSize() / 5; i++) {
			if (uwp.getCountOfNumberOfArtikelInWarenstamm(i + 1) == "0") {
				String actual = uasp.getkeineDatenVorhandenText();
				uwp.clickWarrenstammIdByPassingValue(i);
				String expected = "Keine Daten vorhanden";
				uasp.clickOnZuruckButtonInArtikelstamm();
				softAssert.assertEquals(actual, expected, ":: no Artikel text not as expected");
			} else {
				String countFromWarenstamPage = uwp.getCountOfNumberOfArtikelInWarenstamm(i);
				uwp.clickWarrenstammIdByPassingValue(i);
				int countFromArtikelstamPage = uasp.getCountOfArtikelFromArtikelstamPage();
				String stringCountFromArtikelstamPage = Integer.toString(countFromArtikelstamPage);
				uasp.clickOnZuruckButtonInArtikelstamm();
				softAssert.assertEquals(stringCountFromArtikelstamPage, countFromWarenstamPage,
						":: Count of Artikels are not as expected");
			}
		}
	}

	@Test//(enabled = false)
	public void verifyTheHeadingOfWarenstammWarengruppeInArtikelstammPage_TC54423()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		String expected = "Warengruppe: " + uwp.getTextWarenstammTableElement(1, 1) + " // Warenstammname: "
				+ uwp.getTextWarenstammTableElement(1, 2);
		uwp.clickWarrenstammIdByPassingValue(1);
		uasp.waitForHeadingOfWarenstammWarengruppe();
		Thread.sleep(500);
		String actual = uasp.readHeadingOfWarenstammWarengruppe();
		Assert.assertEquals(actual, expected, "::Heading not as expected" + expected);
	}

	@Test
	public void verifyTheDeleteButtonFunWhileCancelAlertMessage_TC54489() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		for (int i = 0; i < uwp.getWarenstammTableSize(); i++) {
			int countOfArtikel = Integer.parseInt(uwp.getCountOfNumberOfArtikelInWarenstamm(i));
			if (countOfArtikel > 0) {
				uwp.clickWarrenstammIdByPassingValue(i);
				int row = gu.randon(uasp.getArtikelstammtableSizw()), column = gu.randon(9);
				uasp.clickAnyWhereInArtikelstammTable(row, column);
				String expected = "Artikelnummer : " + uasp.getArtikelstammTableElementText(row, 1) + " Warennummer : "
						+ uasp.getArtikelstammTableElementText(row, 2);
				uasp.clickOnDeleteButton();
				gu.alertDismiss(driver);
				String actual = "Artikelnummer : " + uasp.getArtikelstammTableElementText(row, 1) + " Warennummer : "
						+ uasp.getArtikelstammTableElementText(row, 2);
				System.out.println(expected);System.out.println(actual);
				Assert.assertEquals(actual, expected, "::Artikelstamm Loschen Alert dismiss not as expected");
				break;
			}
		}
	}

	@Test
	public void verifyTheDeleteButtonFunWhileAcceptAlertMessage_TC54489() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		for (int i = 0; i < uwp.getWarenstammTableSize(); i++) {
			int countOfArtikel = Integer.parseInt(uwp.getCountOfNumberOfArtikelInWarenstamm(i));
			if (countOfArtikel > 0) {
				uwp.clickWarrenstammIdByPassingValue(i);
				int row = gu.randon(uasp.getArtikelstammtableSizw()), column = gu.randon(9);
				uasp.clickAnyWhereInArtikelstammTable(row, column);
				String selectedArtikel = uasp.getArtikelstammTableElementText(row, 1);
				uasp.clickOnDeleteButton();
				gu.alertAccept(driver);
				uasp.waitForLoschenNotificationBarText();
				String actualNotificationMessage = "Artikelstamm - " + uasp.readArtikelDeletePopup();
				String expectedNotificationMessage = "Artikelstamm - Gelöscht";
				System.out.println(actualNotificationMessage);
				Assert.assertEquals(actualNotificationMessage, expectedNotificationMessage,
						"::Artikelstamm Notification Bar Message not as expected");
				uasp.clickOnNotificationBarCloseButton();
				uwp.sendValueTosearchTextField(selectedArtikel);
				uwp.clickOnSearchIcon();
				String expected = "Keine Daten vorhanden";
				uasp.waitForNoDataAvailableText();				
				String actual = uasp.readNoDataAvailableText();
				System.out.println(actual);
				Assert.assertEquals(actual, expected, "::Warenstamm deletion not as expected");
				break;
			}
		}
	}

	@Test//(enabled = false)
	public void verifyTheMandatoryFieldWhileCreateArtikel_TC54615() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		uwp.clickWarrenstammId();
		uasp.clickOnNewArtikelHinzufugenButton();
		String actualArtikelnummerFieldBeforeSave = uasp.getAttributeValueOfArtikelnummerField();
		String actualWarennummerFieldBeforeSave = uasp.getAttributeValueOfWarennummerField();
		String actualArtikelBezeichnungFieldBeforeSave = uasp.getAttributeValueOfArtikelBezeichnungField();
		String expectedArtikelnummerFieldBeforeSave = "form-control";
		String expectedWarennummerFieldBeforeSave = "form-control ui-autocomplete-input";
		String expectedArtikelBezeichnungFieldBeforeSave = "form-control col-12";
		Assert.assertEquals(actualArtikelnummerFieldBeforeSave, expectedArtikelnummerFieldBeforeSave,
				"::Artikelnummer Field class attribute Value BeforeSave is not as expected");
		Assert.assertEquals(actualWarennummerFieldBeforeSave, expectedWarennummerFieldBeforeSave,
				"::Warennummer Field class attribute Value BeforeSave is not as expected");
		Assert.assertEquals(actualArtikelBezeichnungFieldBeforeSave, expectedArtikelBezeichnungFieldBeforeSave,
				"::Warennummer Field class attribute Value BeforeSave is not as expected");
		uasp.clickOnAddArtikelButton();
		String actualArtikelnummerFieldAfterSave = uasp.getAttributeValueOfArtikelnummerField();
		String actualWarennummerFieldAfterSave = uasp.getAttributeValueOfWarennummerField();
		String actualArtikelBezeichnungFieldAfterSave = uasp.getAttributeValueOfArtikelBezeichnungField();
		String expectedArtikelnummerFieldAfterSave = "form-control is-invalid";
		String expectedWarennummerFieldAfterSave = "form-control ui-autocomplete-input is-invalid";
		String expectedArtikelBezeichnungFieldAfterSave = "form-control col-12 is-invalid";
		Assert.assertEquals(actualArtikelnummerFieldAfterSave, expectedArtikelnummerFieldAfterSave,
				"::Artikelnummer Field class attribute Value BeforeSave is not as expected");
		Assert.assertEquals(actualWarennummerFieldAfterSave, expectedWarennummerFieldAfterSave,
				"::Warennummer Field class attribute Value BeforeSave is not as expected");
		Assert.assertEquals(actualArtikelBezeichnungFieldAfterSave, expectedArtikelBezeichnungFieldAfterSave,
				"::Warennummer Field class attribute Value BeforeSave is not as expected");
	}

	@Test(groups= "Run")
	public void verifyToWriteArtikelDetailsInExcel_TC() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		System.out.println(uwp.getTotalCountOfArtikel());
		for (int i = 0; i <3 ; i++) {//uwp.getWarenstammTableSize()
			if (uwp.getCountOfNumberOfArtikelInWarenstamm(i + 1) != "0") {
				uwp.clickWarrenstammIdByPassingValue(i);
				for (int row = 0; row < uasp.getArtikelstammtableSizw(); row++) {
					for (int column = 0; column < 8; column++) {
						uasp.writeArtikelstamDataToExcel((row), (column),
								uasp.getArtikelstammTableElementText(row, column));
					}
				}
			}
			uasp.clickOnZuruckButtonInArtikelstamm();
		}
	}

	@Test//(enabled = false)
	public void verifyDuplicationNotPossibleArtikel_TC54615()
			throws InvalidFormatException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		for (int i = 0; i < uwp.getWarenstammTableSize() / 5; i++) {
			if (uwp.getCountOfNumberOfArtikelInWarenstamm(i + 1) != "0") {
				uwp.clickWarrenstammIdByPassingValue(i);
				String artikelNumber = uasp.copyTheArtikelNumberInToArrayList();
				System.out.println(artikelNumber);
				uasp.clickOnNewArtikelHinzufugenButton();
				uasp.sendExistingArtikelNummerOnTextField(artikelNumber);
				uasp.sendWarennummerOnTextField();
				uasp.sendArtikelBezeichnungOnTextFieldForEdit();
				uasp.clickOnAddArtikelButton();
				String expected = "Artikelstamm - Artikelnummer existiert bereits!";
				uasp.waitForArtikelNumberExistingMessage();
				String actual = "Artikelstamm - " + uasp.readNotificationBarMessage();
				Assert.assertEquals(actual, expected, ":: Artikel exist message not as expected");
			}
		}
	}

	@Test(enabled = false)
	public void verifyWTN_TotalCount() throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		System.out.println(uasp.logIndataWTN());
	}
}
