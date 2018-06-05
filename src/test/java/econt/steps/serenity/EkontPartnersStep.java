package econt.steps.serenity;

import econt.Utils.Utils;
import econt.pages.EkontPartnersPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;


public class EkontPartnersStep {

    EkontPartnersPage ekontPartners;

    @Step
    public void openEkontPartnersPage() {
        ekontPartners.open();
    }

    @Step
    public void gdprAgree() {
        ekontPartners.gdprAgree();
    }

    @Step
    public void conditionsAccept()   {
        Utils.javascriptWindowScroll(3100);
        ekontPartners.setSeeMoreButton();
        ekontPartners.gdprAgreeIframe();
    }


    @Step
    public void fillData(Map<String, String> data) {
        Utils.javascriptWindowScroll(500);
        ekontPartners.completeForm(data);
    }

    @Step
    public void fillInvalidData(Map<String, String> data) {
        ekontPartners.completeFormWithInvalidData(data);
    }

    @Step
    public void successApplayment(String number) {
        String message = ekontPartners.succsessApllayment();
        Assert.assertEquals(number, message);
    }

    @Step
    public void unsuccessApplayment(String number) {
        String unsuccessfulМessage = ekontPartners.unsuccsessApllayment();
        Assert.assertEquals(number, unsuccessfulМessage);
    }






}
