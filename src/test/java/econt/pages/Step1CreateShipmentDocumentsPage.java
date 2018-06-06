package econt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "services/shipment-create/parcelType")
public class Step1CreateShipmentDocumentsPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;

    @FindBy(css = "label[for='rb-is_document']")
    private WebElementFacade documentsRadioButton;

    @FindBy(css = "label[for='rb-is_pallet']")
    private WebElementFacade palettsRadioButton;

    @FindBy(name = "package_qty")
    private WebElementFacade packageQuantity;

    //Not required
    @FindBy(name = "package_description")
    private WebElementFacade packageDescription;
    //Not required
    @FindBy(css = "label[for='specify_detailed_scecification']")
    private WebElementFacade detailedSpecificationCheckbox;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade nextStepButton;

    @FindBy(id = "step_2")
    private WebElementFacade succsessStep1;

    public void completeCreateShipmentForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.documentsRadioButton.click();
        this.packageQuantity.type(data.get("Quantity"));
        this.packageDescription.type(data.get("Description"));
        this.nextStepButton.click();

        getDriver().switchTo().parentFrame();
    }

    public boolean successStep1() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return succsessStep1.isCurrentlyVisible();
    }
}
