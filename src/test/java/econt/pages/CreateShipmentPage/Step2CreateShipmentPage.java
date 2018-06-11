package econt.pages.CreateShipmentPage;

import econt.Utils.Utils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;


public class Step2CreateShipmentPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;
    //Sender Information
    @FindBy(name = "sender_name_surname")
    private WebElementFacade senderName;

    @FindBy(name = "sender_phone")
    private WebElementFacade senderPhone;

    @FindBy(name = "sender_email")
    private WebElementFacade senderEmail;

    @FindBy(name = "sender_country")
    private WebElementFacade senderCountry;

    @FindBy(name = "sender_city")
    private WebElementFacade senderCity;

    @FindBy(css = "label[for='pickup_location_sender_address']")
    private WebElementFacade addressRadioButton;

    @FindBy(name = "pickup_address")
    private WebElementFacade pickupAddress;

    @FindBy(name = "pickup_address_additional")
    private WebElementFacade pickupAddressAdditional;
    //Receiver Information
    @FindBy(name = "receiver_name_surname")
    private WebElementFacade receiverName;

    @FindBy(name = "receiver_phone")
    private WebElementFacade receiverPhone;

    @FindBy(name = "receiver_email")
    private WebElementFacade receiverEmail;

    @FindBy(name = "receiver_country")
    private WebElementFacade receiverCountry;

    @FindBy(name = "receiver_city")
    private WebElementFacade receiverCity;

    @FindBy(css = "label[for='delivery_location_receiver_address']")
    private WebElementFacade receiverAddressRadioButton;


    @FindBy(css = "input[name='delivery_location'][class*='full-width']")
    private WebElementFacade deliveryLocation;


    @FindBy(css = "label[for='delivery_return_receiver_address']")
    private WebElementFacade disposition;

    //Not required
    @FindBy(css = "label[for='delivery_instructions']")
    private WebElementFacade deliveryInstructionsCheckbox;

    //Not required
    @FindBy(name = "delivery_address_additional")
    private WebElementFacade deliveryAddressAdditional;

    //Има проблем с прихващането на този елемент!!!
    @FindBy(xpath = "//*[@id=\"step_2\"]/ng-include/form/fieldset/section/div/button")
    private WebElementFacade nextStepButton;

    @FindBy(name = "addons")
    private WebElementFacade successStep2;

    public void completeCreateShipmentFormSenderStep2(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        //Sender
        this.senderName.type(data.get("Sender Name"));
        this.senderEmail.type(data.get("Sender Email"));
        this.senderPhone.type(data.get("Sender Phone"));
        // this.senderCountry.type(data.get("Sender Country"));
        this.senderCity.type(data.get("Sender City"));
        this.addressRadioButton.click();
        this.pickupAddress.type(data.get("Pickup Address"));


        getDriver().switchTo().parentFrame();
    }

    public void completeCreateShipmentFormReceiverStep2(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);

        this.receiverName.type(data.get("Receiver Name"));
        this.receiverEmail.type(data.get("Receiver Email"));
        this.receiverPhone.type(data.get("Receiver Phone"));
        // this.receiverCountry.type(data.get("Receiver Country"));
        this.receiverCity.type(data.get("Receiver City"));
        this.receiverAddressRadioButton.click();
        this.deliveryAddressAdditional.click();
        this.deliveryLocation.type(data.get("Delivery Location"));
        this.disposition.click();
        this.nextStepButton.click();

        getDriver().switchTo().parentFrame();
    }


    public boolean successStep2() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return successStep2.isCurrentlyVisible();

    }
}
