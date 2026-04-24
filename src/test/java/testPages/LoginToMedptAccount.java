package testPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToMedptAccount {

	WebDriver driver;
	String medptWindow;
	String mailinatorWnidow;
	public String passcode;
	JavascriptExecutor js;
	Select select;
	String safetyRerpotName;
	private By emailLocator = By.xpath("//form[@class='v-form']//div/input[@id='Username']");
	private By nextButtonLocator = By.xpath("//form[@class='v-form']//div/button[@id='nextbtn']");
	private By passwordLocator = By.xpath("//form[@class='v-form']//div/input[@id='pwdbtn']");
	private By loginButtonLocator = By.xpath("//form[@class='v-form']//div/button[@id='btnlogin']");

	private By searchMailinatorLocator = By.xpath("//header[@id='site-header']//div/input[@id='search']");
	private By goButtonLocator = By
			.xpath("//header[@id='site-header']//div/button[@value='Search for public inbox for free']");

	private By mailinatorLocator = By.xpath(
			"//table[@class='table-striped jambo_table']//tbody/tr[contains(@id,'row_afghan2')]/td/following-sibling::td[contains(text(),'noreply@medpt.com')]");

	private By iframeLocator = By.id("html_msg_body");

	private By codeLocator = By.xpath("//html//body//p/b");
	private By submitLocator = By.xpath("//div[@class='flex pb-0']//button/div[contains(text(),'Submit')]");
	private By passcodLocator = By.xpath("//input[@id='Input_VerificationCode']");

	private By triportLocator = By
			.xpath("//div[@id='app']/div//div[contains(text(),' Multi-Functional Investigator Platform ')]");

	private By topMenuLocator = By.xpath("//ul[@id='desktopsearchwrap']//li[@id='topmenu-admin']/a[@id='drpMenuTool']");

//	private By portalAdminLocator = By.xpath(
//			"//div[@id='menu-container-topmenu-admin']//div[@id='menu-portaladmintools']/a");

	private By adminlistLocators = By.xpath("//div[@id='menu-container-topmenu-admin']//div//a");

	// ul[@id='desktopsearchwrap']//li[@id='topmenu-admin']/a[@id='drpMenuTool']

	private By uploadSafetyReportLocator = By
			.xpath("//div//a[@id='MainContent_rpParentFeatures_rpChildFeatures_3_FeatureURL_0']");

	private By listOfSRTypes = By.xpath("//div[@id='ctl00_MainContent_ddlSafetyReportType_DropDown']//div//ul//li");

	private By safetyReportTypedrodwonlocator = By.xpath("//div[@id='ctl00_MainContent_ddlSafetyReportType']");

	private By dilOptions = By.xpath("//div[@id='ctl00_MainContent_ddlDILTemplate_DropDown']//ul//li");

	private By ddl = By.xpath("//div[@id='ctl00_MainContent_ddlDILTemplate']");

	private By browseFile = By.xpath(
			"//div[@id='MainContent_pnlNewSafetyReport']//div/label[@class='custom-file-upload primaryBtn' and contains(text(),'Browse')]");

	private By selectAllsite = By.xpath(
			"//table[@id='MainContent_rdoAssignments']//tbody//tr//td//input[@id='MainContent_rdoAssignments_1']");

	private By submitButtonLocator = By.xpath("//input[@id='MainContent_btnSubmit']");

	private By selectCompoundLocator = By
			.xpath("//label[contains(normalize-space(),'Compound')]/following-sibling::span//span[@role='button']");

	private By selectCompoundLocatorList = By
			.xpath("//ul[@id='MainContent_meta_ctrl_1_0_3_listbox']//li[position()>1]");

	private By studyOfOriginLocator = By.xpath(
			"//label[contains(normalize-space(),'Study of Origin')]/following-sibling::span//span[@role='button']");

	private By studyOfOriginLocatorLists = By
			.xpath("//ul[@id='MainContent_meta_ctrl_1_1_4_listbox']//li[position()>1]");

	private By aetermLocator = By.xpath(
			"//div[@id='MainContent_metacontrols']//div//ul[@id='MainContent_meta_ctrl_1_2_7_taglist']//following-sibling::input");

	private By aetermlistsLocator = By.xpath("//ul[@id='MainContent_meta_ctrl_1_2_7_listbox']//li");

	private By initialOrFollowupLocator = By
			.xpath("//div/label[contains(text(),'Initial/Follow-up')]/following-sibling::div//span[@role='button']");

//	label[@id='MainContent_lbl_639123055316231735_meta_ctrl_1_3_8']//following-sibling::div[@id='MainContent_div_parent_meta_ctrl_1_3_8']
	private By selectInitialorFollowuplists = By.xpath(
			"//div[@id='MainContent_meta_ctrl_1_3_8-list']//div//ul[@id='MainContent_meta_ctrl_1_3_8_listbox']/li");

	private By globalcaseIdLocator = By
			.xpath("//div[@id='MainContent_metacontrols']//div//input[@id='MainContent_meta_ctrl_1_4_9']");

	private By countryOfOriginLocator = By
			.xpath("//div[@id='MainContent_metacontrols']//span[contains(text(),'-- Select Country of Origin --')]");

	private By countryLists = By.xpath("//div//ul[@id='MainContent_meta_ctrl_1_6_5_listbox']//li");

	private By clickAddSafetyButton = By.xpath("//div/input[@id='MainContent_btnAddSafetyReport']");

	private By calendarIconloctor = By
			.xpath("//table//tbody//tr//td//a[@id='ctl00_MainContent_meta_ctrl_1_5_10_popupButton']");

	private By calendarContainsLocator = By.xpath("//table[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar']");

	private By nextMonthCalendorLocator = By.xpath(
			"//table[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar']//tr//td//tbody//tr//td//a[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar_NN']");

	private By calendarMonthGetNameLocator = By.xpath(
			"//table[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar']//tr//td//tbody//tr//td[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar_Title']");

	private By daysContainerLocator = By
			.xpath("//table[@id='ctl00_MainContent_meta_ctrl_1_5_10_calendar_Top']//tbody//tr//td/a");

	private By infoMessageLocator = By.xpath("//div[@id='addfiles']//div[@id='MainContent_dvTitleExists']");

	private By safetReportLocator = By
			.xpath("//table[@id='MainContent_gvFiles']//tbody//tr//td//a[@id='MainContent_gvFiles_lnkTitle_0']");

	// div[@id='addfiles']//div[@id='MainContent_dvTitleExists']

	private By safetyReportPageLocator = By
			.xpath("//div[@class='nav-container']//section//ul//li[@id='menu-safetyreports-379']/a");

	private By susarLocator = By.xpath("//div[@id='content']//div//label[contains(text(),'SUSARs')]");

	private By safetyReportsTilesList = By.xpath("//div[contains(@class,'k-listview-content')]//label");

	private By successMessage = By.xpath("//div[@id='fullscreen-toasts']");

	// div[@id='fullscreen-toasts']//div[contains(text(),'Safety Report(s)
	// successfully created')]

	private By ldrmain = By.xpath("//div[@class='ldr-overlay']");

	private By ldrsub = By.xpath("//div[@id='MainContent_UpdateProgress1']");

	private By srtableData = By.xpath("//div[contains(@class,'k-grid-content')]//a[contains(@title,'Open document')]");

	WebDriverWait webwait;
	Actions actions;

	@Test(priority = 1)
	public void loginPage() throws AWTException, InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://secure.test.medpt.com/Account/Login");
		medptWindow = driver.getWindowHandle();
		driver.manage().window().maximize();
		actions = new Actions(driver);

		js = (JavascriptExecutor) driver;
		driver.findElement(emailLocator).sendKeys("afghan2@mailinator.com");
		driver.findElement(nextButtonLocator).click();
		webwait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement passwordField = webwait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
		passwordField.sendKeys("Saibaba1@3");
		driver.findElement(loginButtonLocator).click();

	}

	@Test(priority = 2)
	public void switchToNewTab() {

		driver.switchTo().newWindow(WindowType.TAB);
		mailinatorWnidow = driver.getWindowHandle();
		driver.get("https://www.mailinator.com/");
		driver.findElement(searchMailinatorLocator).sendKeys("afghan2@mailinator.com");
		driver.findElement(goButtonLocator).click();
		List<WebElement> elements = webwait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mailinatorLocator));

		for (WebElement element : elements) {
			element.click();
			break;

		}

		webwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
		WebElement code = webwait.until(ExpectedConditions.visibilityOfElementLocated(codeLocator));
		js.executeScript("arguments[0].scrollIntoView(true);", code);
		passcode = code.getText();
		driver.switchTo().defaultContent();

	}

	@Test(priority = 3, dependsOnMethods = "switchToNewTab")
	public void switchToOldTab() {

//		driver.close();
		driver.switchTo().window(medptWindow);
		driver.findElement(passcodLocator).sendKeys(passcode);
		driver.findElement(submitLocator).click();
	}

	@Test(priority = 4)
	public void trialPort() throws AWTException, InterruptedException {

		WebElement element = webwait.until(ExpectedConditions.elementToBeClickable(triportLocator));
		element.click();
		WebElement topMenu = webwait.until(ExpectedConditions.elementToBeClickable(topMenuLocator));

		actions.moveToElement(topMenu).perform();

		List<WebElement> elements = webwait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(adminlistLocators));

//		Optional<WebElement>clickPortalAdmin = elements.stream().filter(e->e.getText().trim().equals("Portal Admin")&&e.isEnabled()).findFirst();		
//		clickPortalAdmin.ifPresent(WebElement::click);

		for (WebElement e : elements) {

			if (e.getText().trim().equals("Portal Admin")) {
				e = webwait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
				break;
			}

		}

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(uploadSafetyReportLocator));

		WebElement uploadSafetyReport = webwait
				.until(ExpectedConditions.elementToBeClickable(uploadSafetyReportLocator));

		uploadSafetyReport.click();

		WebElement safetyReportType = webwait
				.until(ExpectedConditions.elementToBeClickable(safetyReportTypedrodwonlocator));

		safetyReportType.click();

		List<WebElement> listOfTypes = webwait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfSRTypes));

		for (WebElement types : listOfTypes) {

			if (types.getText().equals("SUSARs")) {
				types.click();
				break;
			}

		}

		webwait.until(ExpectedConditions.visibilityOfElementLocated(ddl)).click();

		List<WebElement> diloptions = webwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dilOptions));

		for (WebElement dilOptions : diloptions) {

			if (dilOptions.getText().equals("Not Applicable")) {
				dilOptions.click();
				break;
			}

		}

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(browseFile));

		webwait.until(ExpectedConditions.visibilityOfElementLocated(browseFile)).click();
		Thread.sleep(3000);

		StringSelection selection = new StringSelection("D:\\Desktop\\resumes\\sample.txt");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		WebElement compoundDropdown = webwait.until(ExpectedConditions.elementToBeClickable(selectCompoundLocator));
		compoundDropdown.click();

		List<WebElement> listOfcompounds = webwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectCompoundLocatorList));
		for (WebElement listOfElements : listOfcompounds) {

			if (listOfElements.getText().equals("matt")) {
				listOfElements.click();
			}
		}

		WebElement studyOfOrigin = webwait.until(ExpectedConditions.elementToBeClickable(studyOfOriginLocator));
		studyOfOrigin.click();

		List<WebElement> listsOfStudyOfOrigin = webwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(studyOfOriginLocatorLists));
		for (WebElement listOfElements : listsOfStudyOfOrigin) {

			if (listOfElements.getText().equals("12AB")) {
				listOfElements.click();

			}

		}

		WebElement aetermLocat = webwait.until(ExpectedConditions.elementToBeClickable(aetermLocator));
		aetermLocat.click();

		List<WebElement> listOfaeterms = webwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(aetermlistsLocator));

		for (WebElement listOfElements : listOfaeterms) {
			if (listOfElements.getText().equals("testing")) {
//				js.executeScript("arguments[0].scrollIntoView(true);", listOfElements);
				listOfElements.click();
				break;

			}

		}

		WebElement initfollowLocator = webwait.until(ExpectedConditions.elementToBeClickable(initialOrFollowupLocator));
		initfollowLocator.click();

		List<WebElement> initialOrfollowUplists = webwait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectInitialorFollowuplists));
		for (WebElement initorfollowup : initialOrfollowUplists) {
			if (initorfollowup.getText().trim().equals("Initial"))
			{
				ExpectedConditions.elementToBeClickable(initorfollowup);
				initorfollowup.click();
				break;

			}

		}

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

//		---------------->global case id 

		WebElement globalcaseLocator = webwait
				.until(ExpectedConditions.visibilityOfElementLocated(globalcaseIdLocator));
		globalcaseLocator.sendKeys("127");

		WebElement eventCalendar = webwait.until(ExpectedConditions.elementToBeClickable(calendarIconloctor));
		eventCalendar.click();

		webwait.until(ExpectedConditions.elementToBeClickable(calendarContainsLocator));

		WebElement getMonthName = webwait
				.until(ExpectedConditions.visibilityOfElementLocated(calendarMonthGetNameLocator));
		getMonthName.getText();
		WebElement nextMonth = webwait.until(ExpectedConditions.elementToBeClickable(nextMonthCalendorLocator));

		while (true) {

			if (getMonthName.getText().trim().equals("May 2026")) {
				break;
			}
			nextMonth.click();

//			webwait.until(ExpectedConditions.textToBePresentInElementLocated(calendarMonthGetNameLocator, "May 2026"));

		}

		List<WebElement> daysElement = driver.findElements(daysContainerLocator);

		for (WebElement days : daysElement) {

			if (days.isDisplayed() && days.isEnabled() && days.getText().equals("29")) {

				days.click();

			}

		}

		WebElement ctryOrignLocator = webwait
				.until(ExpectedConditions.visibilityOfElementLocated(countryOfOriginLocator));
		ctryOrignLocator.click();

		List<WebElement> ctylists = driver.findElements(countryLists);

		Set<WebElement> ctrySet = new HashSet<>(ctylists);

//		int citylength = ctrySet.size();

//		List<WebElement> listOfCountries = webwait
//				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryLists));
		for (WebElement listOfElements : ctrySet) {
			if (listOfElements.getText().equals("China")) {
				listOfElements.click();
				break;

			}

		}

		WebElement addsafetyreportbutton = webwait
				.until(ExpectedConditions.visibilityOfElementLocated(clickAddSafetyButton));
		addsafetyreportbutton.click();

		WebElement errorMessage;

		errorMessage = driver.findElement(infoMessageLocator);

		if (errorMessage.isDisplayed()) {
			System.out.println("THE ERROR MESSAGE IS ---------->" + errorMessage.getText());
			System.out.println(errorMessage.getText().contains("is already distributed"));
			return;
		}

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		WebElement safetyReportName = webwait.until(ExpectedConditions.elementToBeClickable(safetReportLocator));
		safetyRerpotName = safetyReportName.getText();
		System.out.println("Safety report name is----------> " + safetyRerpotName);

		WebElement allsite = webwait.until(ExpectedConditions.visibilityOfElementLocated(selectAllsite));
		allsite.click();

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		WebElement submit = webwait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
		submit.click();

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

	}

	@Test(priority = 5, dependsOnMethods = { "trialPort" })
	public void safetyRerportsPage() {

		boolean isDisappeared = webwait.until(ExpectedConditions.invisibilityOfElementLocated(successMessage));

		WebElement srPage = webwait.until(ExpectedConditions.elementToBeClickable(safetyReportPageLocator));

		if (isDisappeared) {
			srPage.click();
		}

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		List<WebElement> srtilesList = webwait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(safetyReportsTilesList));
		;

//		Optional<WebElement>srtile = srtilesList.stream().filter(s->s.getText().trim().equals("SUSARs")).findFirst();
//		srtile.ifPresent(WebElement::click);

		WebElement susarlocator = webwait.until(ExpectedConditions.elementToBeClickable(susarLocator));
		susarlocator.click();

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

		List<WebElement> srdocs = webwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(srtableData));

		for (WebElement srdocuments : srdocs) {
			if (srdocuments.getText().equals(safetyRerpotName)) {
				srdocuments.click();
			}
		}

		webwait.until(ExpectedConditions.invisibilityOfElementLocated(ldrsub));

	}

}
