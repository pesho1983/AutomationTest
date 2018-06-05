package econt.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "services/track-shipment")

public class TrackShipmentPage extends PageObject {
    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade gdprAgree;

    @FindBy(css = ".btn.btn-primary.ebtn-main.btn-block.ng-binding")
    private WebElementFacade submitButton;

    @FindBy(name = "parcelNumbers")
    private WebElementFacade parcelNumbersTextArea;


    @FindBy(id = "site-trace")
    private WebElementFacade iframeElement;


    @FindBy(xpath = "//strong[not(contains(@style, 'display: none'))]")
    private WebElementFacade trackShipmentNumber;


    @FindBy(css = ".econt-msg.error.ng-binding")

    private WebElementFacade errorMessageDisplayed;

    public void gdprAgree() {
        gdprAgree.click();
    }

    public WebElementFacade getIframeElement() {
        return iframeElement;
    }

    public void completeForm(String number) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.parcelNumbersTextArea.type(number);
        this.submitButton.click();
        getDriver().switchTo().parentFrame();
    }

    public void testForm(String number) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.parcelNumbersTextArea.type(number);
        getDriver().switchTo().parentFrame();
    }

    public String getTrackShipmentNumber() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        String number = this.trackShipmentNumber.getText();
        getDriver().switchTo().parentFrame();
        return number;
    }

    public String errorMessageDisplayed() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        String number = this.errorMessageDisplayed.getText();
        getDriver().switchTo().parentFrame();
        return number;
    }
}
