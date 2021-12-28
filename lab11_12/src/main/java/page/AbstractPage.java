package page;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT = 30;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPage();

    protected WebElement findByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    protected WebElement findByLocatorClickable(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
    }

    protected List<WebElement> findAll(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public String getElementText(By locator) {
        WebElement element = findByLocator(locator);
        return element.getText();
    }

    public String getElementListText(By locator) {
        List<WebElement> element = findAll(locator);
        return element.get(0).getText();
    }
}
