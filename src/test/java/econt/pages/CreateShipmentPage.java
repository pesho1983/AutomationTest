package econt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "services/order-courier")
public class CreateShipmentPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;

    @FindBy(css = "label[for='rb-is_document']")
    private WebElementFacade documentsRadioButton;

    @FindBy(css = "label[for='rb-is_package']")
    private WebElementFacade packegesRadioButton;

    @FindBy(css = "label[for='rb-is_pallet']")
    private WebElementFacade palettsRadioButton;

    @FindBy(name = "package_qty")
    private WebElementFacade packageQuantity;

    //Not required
    @FindBy(name = "package_description")
    private WebElementFacade packageDescription;


    @FindBy(css = "label[for='specify_detailed_scecification']")
    private WebElementFacade detailedSpecificationCheckbox;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade nextStepButton;


    public void completeOrderCourierForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.documentsRadioButton.click();


        this.packegesRadioButton.click();
        this.palettsRadioButton.click();
        this.packageQuantity.type(data.get("Quantity"));
        this.packageQuantity.type(data.get("Description"));

        getDriver().switchTo().parentFrame();
    }

}
