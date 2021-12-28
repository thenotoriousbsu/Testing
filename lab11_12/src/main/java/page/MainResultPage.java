package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainResultPage extends AbstractPage {

    private final By departTime = By.xpath("//h2[contains(@class,'no-mp')]");
    private final By iframe = By.xpath("//iframe[contains(@id,'booking')]");
    private final By cityFrom = By.xpath("//div[contains(@class,'col-xs-6 text-left')]//p//br");

    public MainResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AbstractPage openPage() {
        driver.get(driver.getCurrentUrl());
        return this;
    }

    public String getDepartTime() {
        WebElement element = findByLocator(iframe);
        driver.switchTo().frame(element);
        return getElementListText(departTime);
    }

    public String getCityFrom() {
        WebElement element = findByLocator(iframe);
        driver.switchTo().frame(element);
        return getElementListText(cityFrom);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
