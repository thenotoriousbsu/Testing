const { assert } = require('chai')
const webdriver = require('selenium-webdriver');
const { By } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const chromedriver = require('chromedriver');

describe('Ecoline test', () => {
  let driver;
  let clickWhenClickable;

  beforeEach(() => {
    const options = new chrome.Options();

    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage")

    driver = new webdriver.Builder()
      .withCapabilities(webdriver.Capabilities.chrome())
      .build();

    driver.manage().window().maximize();

    clickWhenClickable = async (locator, timeout) => {
      await driver.wait(function () {
        return driver.findElement(locator).then(function (element) {
          return element.click().then(function () {
            return true;
          }, function () {
            return false;
          })
        }, function () {
          return false;
        });
      }, timeout, 'Timeout waiting for ' + locator.value);;
    }
  });

  it('Should submit search', async (done) => {
    try {
      await driver.get('https://ecolines.net/ru/ru');

      await driver.findElement(By.xpath('//*[@id="ecolines-booking-form"]/div[3]/div[1]/div/div/button')).click();

      await driver.wait(clickWhenClickable(By.xpath('//*[@id="ecolines-booking-form"]/div[3]/div[1]/div/div/div/ul/li[75]'), 10000));
      await driver.wait(clickWhenClickable(By.xpath('//*[@id="ecolines-booking-form"]/div[3]/div[3]/div/div/div/ul/li[8]'), 10000));

      await driver.findElement(By.xpath('//*[@id="btn-booking"]')).click();

      assert.ok();
    } finally {
      await driver.quit();
    }
  });
});