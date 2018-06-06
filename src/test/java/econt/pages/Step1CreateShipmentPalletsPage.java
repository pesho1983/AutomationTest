package econt.pages;

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


}
