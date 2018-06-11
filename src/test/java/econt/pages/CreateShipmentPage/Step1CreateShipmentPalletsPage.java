package econt.pages.CreateShipmentPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "services/shipment-create/parcelType")
public class Step1CreateShipmentPalletsPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;

    @FindBy(css = "label[for='rb-is_pallet']")
    private WebElementFacade palettsRadioButton;

    @FindBy(css = "label[for='pallet_type_1']")
    private WebElementFacade standartPalletButton;

    @FindBy(name = "pallet_qty")
    private WebElementFacade palletsQuantity;

    @FindBy(name = "pallet_weight")
    private WebElementFacade palletWeight;

    @FindBy(name = "pallet_height")
    private WebElementFacade palletHeight;

    @FindBy(name = "package_description")
    private WebElementFacade palletsDescription;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade nextStepButton;

    //List of web elements JAVA!!!
    @FindBy(css = "")
    private WebElementFacade errorStep1;


    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade succsessStep1;

    public void completeCreateShipmentFormPallets(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);

        this.palettsRadioButton.click();
        this.standartPalletButton.click();

        this.palletsQuantity.type(data.get("quantity"));
        this.palletWeight.type(data.get("weight"));
        this.palletHeight.type(data.get("height"));
        this.palletsDescription.type(data.get("description"));

            this.succsessStep1.click();

        getDriver().switchTo().parentFrame();
    }

    public void completeCreateShipmentFormPalletsIncorrect(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);

        this.palettsRadioButton.click();
        this.standartPalletButton.click();

        this.palletsQuantity.type(data.get("quantity"));
        this.palletWeight.type(data.get("weight"));
        this.palletHeight.type(data.get("height"));
        this.palletsDescription.type(data.get("description"));

        getDriver().switchTo().parentFrame();
    }

     public String errorStep1Pallets() {
         getDriver().switchTo().frame((WebElement) this.iframeElement);
         return errorStep1.getText();
     }

}
