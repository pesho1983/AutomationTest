package econt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "partners")

public class EkontPartnersPage extends PageObject {

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade gdprAgree;

    @FindBy(css = ".arrow-rt.ng-binding")
    private WebElementFacade seeMoreButton;

    @FindBy(name = "name")
    private WebElementFacade name;

    @FindBy(name = "phone")
    private WebElementFacade phone;

    @FindBy(name = "email")
    private WebElementFacade email;

    @FindBy(name = "town")
    private WebElementFacade town;

    @FindBy(css = "label[for='partner-location-no']")
    private WebElementFacade location;

    @FindBy(name = "area")
    private WebElementFacade area;

    @FindBy(css = "label[for='partner-plans-to-rent']")
    private WebElementFacade choice;

    @FindBy(id = "submit_button")
    private WebElementFacade submitButton;

    @FindBy(id = "site-partner")
    private WebElementFacade iframeElement;

    @FindBy(css = ".success.ng-scope")
    private WebElementFacade succsessApllayment;

    @FindBy(css = "div[ng-message].ng-scope")
    private WebElementFacade errorMessageDisplay;


    public void gdprAgree() {
        waitFor(ExpectedConditions.elementToBeClickable(gdprAgree));
        gdprAgree.click();
    }

    public void gdprAgreeIframe() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        gdprAgree.click();
        getDriver().switchTo().parentFrame();
    }

    public void setSeeMoreButton() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        seeMoreButton.click();
        getDriver().switchTo().parentFrame();
    }

    public void completeForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.name.type(data.get("Name"));
        this.phone.type(data.get("Phone"));
        this.email.type(data.get("Email"));
        this.town.type(data.get("Town"));
        this.location.click();
        this.area.type(data.get("Area"));
        this.choice.click();
        this.submitButton.click();
        getDriver().switchTo().parentFrame();
    }

    public void completeFormWithInvalidData(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.name.type(data.get("Name"));
        this.phone.type(data.get("Phone"));
        this.email.type(data.get("Email"));
        this.town.type(data.get("Town"));
        this.location.click();
        this.area.type(data.get("Area"));
        this.choice.click();
        getDriver().switchTo().parentFrame();
    }

    public String succsessApllayment() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return succsessApllayment.getText();
    }

    public String unsuccsessApllayment() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return errorMessageDisplay.getText();
    }
}
