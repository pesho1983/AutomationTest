package econt.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;

@DefaultUrl(WEBSITE_URL + "services/shipment-create/parcelType")
public class Step1CreateShipmentPackagesPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;



    @FindBy(css = "label[for='rb-is_package']")
    private WebElementFacade packegesRadioButton;



    @FindBy(name = "package_qty")
    private WebElementFacade packageQuantity;

    //Not required
    @FindBy(name = "package_description")
    private WebElementFacade packageDescription;


    @FindBy(css = "label[for='specify_detailed_scecification']")
    private WebElementFacade detailedSpecificationCheckbox;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade nextStepButton;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade succsessStep1;

    public void completeCreateShipmentForm(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.packegesRadioButton.click();

        this.packageQuantity.type(data.get("Quantity"));
        this.packageQuantity.type(data.get("Description"));
        this.succsessStep1.click();

        getDriver().switchTo().parentFrame();
    }

    public String succsessStep1() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return succsessStep1.getText();
    }
}
