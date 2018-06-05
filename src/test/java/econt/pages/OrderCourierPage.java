package econt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;


@DefaultUrl(WEBSITE_URL + "services/order-courier")

public class OrderCourierPage extends PageObject {

    @FindBy(id = "site-order-courier")
    private WebElementFacade iframeElement;

    @FindBy(name = "name")
    private WebElementFacade name;

    @FindBy(name = "phone")
    private WebElementFacade phone;

    @FindBy(name = "email")
    private WebElementFacade email;

    @FindBy(name = "city")
    private WebElementFacade city;

    @FindBy(name = "address")
    private WebElementFacade address;

    @FindBy(css = "label[for='kind_1']")
    private WebElementFacade radioButton;

    @FindBy(name = "date")
    private WebElementFacade date;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade submitButton;

    @FindBy(css = ".ng-binding.ng-scope")
    private WebElementFacade test;

    @FindBy(css = ".econt-green.ng-binding")
    private WebElementFacade validOrderMessage;

    @FindBy(css = "div[ng-message].ng-scope")
    private WebElementFacade errorMessageDisplay;

    public void completeOrderCourierForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.name.type(data.get("Name"));
        this.phone.type(data.get("Phone"));
        this.email.type(data.get("Email"));
        this.city.type(data.get("City"));
        this.address.type(data.get("Address"));
        this.city.click();
        this.radioButton.click();
        this.date.click();
        this.submitButton.click();
        getDriver().switchTo().parentFrame();
    }

    public void invalidCompleteOrderCourierForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.name.type(data.get("Name"));
        this.phone.type(data.get("Phone"));
        this.email.type(data.get("Email"));
        this.city.type(data.get("City"));
        this.address.type(data.get("Address"));
        this.city.click();
        this.radioButton.click();

        getDriver().switchTo().parentFrame();
    }

    public String succsessOrderCourier() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return validOrderMessage.getText();
    }

    public String unsuccsessOrderCourier() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return errorMessageDisplay.getText();
    }

}
