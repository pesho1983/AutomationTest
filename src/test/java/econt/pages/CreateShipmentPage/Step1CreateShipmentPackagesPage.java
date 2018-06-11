package econt.pages.CreateShipmentPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static econt.Utils.Utils.WEBSITE_URL;
import static org.aspectj.runtime.internal.Conversions.intValue;

@DefaultUrl(WEBSITE_URL + "services/shipment-create/parcelType")
public class Step1CreateShipmentPackagesPage extends PageObject {

    @FindBy(id = "site-shipment")
    private WebElementFacade iframeElement;


    @FindBy(css = "label[for='rb-is_package']")
    private WebElementFacade packegesRadioButton;


    @FindBy(name = "package_qty")
    private WebElementFacade packageQuantity;

    @FindBy(css = "label[for='package_size_options_1']")
    private WebElementFacade packageType1;
    @FindBy(css = "label[for='package_size_options_2']")
    private WebElementFacade packageType2;
    @FindBy(css = "label[for='package_size_options_3']")
    private WebElementFacade packageType3;
    @FindBy(css = "label[for='package_size_options_4']")
    private WebElementFacade packageType4;

    @FindBy(name = "package_weight")
    private WebElementFacade packageWeight;


    @FindBy(name = "package_description")
    private WebElementFacade packageDescription;


    @FindBy(css = "label[for='specify_detailed_scecification']")
    private WebElementFacade detailedSpecificationCheckbox;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade nextStepButton;

    @FindBy(css = ".btn.ng-binding")
    private WebElementFacade succsessStep1;

    public void completeCreateShipmentFormPackages(Map<String, String> data) {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        this.packegesRadioButton.click();

       //int type = intValue(data.get("type"));
       //switch (type) {
       //    case 2:
       //        this.packageType2.click();
       //        break;
       //    case 3:
       //        this.packageType3.click();
       //        break;
       //    case 4:
       //        this.packageType4.click();
       //        break;
       //    default: packageType1.click();
       //        break;
       //}
        this.packageType2.click();
        this.packageDescription.type(data.get("description"));
        this.packageWeight.type(data.get("weight"));
        this.succsessStep1.click();

        getDriver().switchTo().parentFrame();
    }

    public String succsessStep1Packages() {
        getDriver().switchTo().frame((WebElement) this.iframeElement);
        return succsessStep1.getText();
    }
}
