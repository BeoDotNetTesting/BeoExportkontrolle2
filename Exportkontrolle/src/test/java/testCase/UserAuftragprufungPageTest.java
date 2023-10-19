package testCase;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import elementRepository.LoginPage;
import elementRepository.UserArtikelstammPage;
import elementRepository.UserAuftragprufungPage;
import elementRepository.UserMasterLoginPage;
import elementRepository.UserWarenstammPage;
import utilities.GeneralUtilities;

public class UserAuftragprufungPageTest extends BaseClass {
	UserWarenstammPage uwp;
	UserMasterLoginPage umLp;
	LoginPage lp;
	UserArtikelstammPage uasp;
	UserAuftragprufungPage uafp;
	GeneralUtilities gu = new GeneralUtilities();
  @Test
  public void f() throws InvalidFormatException, IOException {
	  lp = new LoginPage(driver);
		uwp = new UserWarenstammPage(driver);
		umLp = new UserMasterLoginPage(driver);
		uasp = new UserArtikelstammPage(driver);
		uafp=new UserAuftragprufungPage(driver);
		lp.sendUserName(logIndata(2));
		lp.sendPassword(logIndata(5));
		lp.clickLoginButton();
		umLp.clickOnbitteAuswahlenSelect();
		umLp.selectBeoIndiaTestFromDrop();
		umLp.anmeldenClick();
		umLp.clickOnAuftragprufungTabButton();
		for(int i=0;i<=2;i++) {
		uafp.clickOnEinstellungenButton();
		uafp.sendAllgemeineDatenForAuftragprufung();
		uafp.clickOnSpeichernButton();
		}
  }
}
