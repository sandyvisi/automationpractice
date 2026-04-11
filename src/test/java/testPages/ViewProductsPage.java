package testPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basePackage.BaseClass;

public class ViewProductsPage extends BaseClass {

	private By productsLocator = By.xpath(
			"//div[@class='shop-menu pull-right']//li//a[contains(text(),'Products') and contains(@href,'/products')]");

	private By productsListsLocator = By.xpath("//div[@class='product-image-wrapper']/div//li/a");
	private By productNameLocator = By.xpath("//div[@class='product-information']/h2");
	private By categoryNameLocator = By.xpath("//div[@class='product-information']/h2/following-sibling::p[1]");
	private By productPriceLocator = By.xpath("//div[@class='product-information']/span/span");
	private By availabilityAndConditionAndBrandLocator = By
			.xpath("//div[@class='product-information']//descendant::span/following-sibling::p");

	private void clickProductLink(By locator) {
		click(locator);
	}

	private void clickFirstProduct(By locator) {

		List<WebElement> listOfProducts = driver.findElements(locator);
		for (WebElement element : listOfProducts) {
			element.click();
			break;
		}

	}

	private void productName(By locator) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			System.out.println(element.getText());

		}

	}

	private void categoryName(By locator) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			System.out.println(element.getText());
		}

	}

	private void productPrice(By locator) {

		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			System.out.println(element.getText());
		}

	}

	private void clickProductInfo(By locator) {

		List<WebElement> productInfo = driver.findElements(locator);
		for (WebElement element : productInfo) {
			if (element.isDisplayed()) {

				System.out.println("product details :" + element.getText());

			}
		}

	}

	public void viewProductsFunctions()

	{

		clickProductLink(productsLocator);
		clickFirstProduct(productsListsLocator);
		productName(productNameLocator);
		categoryName(categoryNameLocator);
		productPrice(productPriceLocator);
		clickProductInfo(availabilityAndConditionAndBrandLocator);

	}

}
