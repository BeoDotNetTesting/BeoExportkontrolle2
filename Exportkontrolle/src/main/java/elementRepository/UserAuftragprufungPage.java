package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class UserAuftragprufungPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	String warenstammName, artikelNummer;

	public UserAuftragprufungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Einstellungen']")
	WebElement einstellungenButton;
	@FindBy(id = "mainContent_txtBelegnummer")
	WebElement belegnummerField;
	@FindBy(id = "mainContent_txtEmfangername")
	WebElement emfangernameField;
	@FindBy(xpath="//a[@id='mainContent_btnSave']//span[text()='Speichern']")
	WebElement speichernButton;
	@FindBy(id="mainContent_txtLand")
	WebElement landField;

	public void clickOnEinstellungenButton() {
		einstellungenButton.click();
	}

	public void sendAllgemeineDatenForAuftragprufung() {
		belegnummerField.sendKeys("BELNUM"+gu.randon(1000));
		emfangernameField.sendKeys("emfangername"+gu.randon(1000));
		landField.sendKeys("AD - Andorra");
	}
	public void clickOnSpeichernButton() {
		speichernButton.click();
	}
}
