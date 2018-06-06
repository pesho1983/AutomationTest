package econt.steps.serenity;

import econt.Utils.Utils;
import econt.pages.Step1CreateShipmentDocumentsPage;
import econt.pages.EkontPartnersPage;
import econt.pages.Step2CreateShipmentPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class CreateShipmentStep {


    Step1CreateShipmentDocumentsPage createShipment;
    Step2CreateShipmentPage createShipmentPageStep2;
    EkontPartnersPage ekontPartners;

    @Step
    public void openEkontPartnersPage() {
        createShipment.open();
    }

    @Step
    public void gdprAgree() {
        ekontPartners.gdprAgree();
    }

    @Step
    public void completeCretateShipmentFormStep1(Map<String, String> data) {
        createShipment.completeCreateShipmentForm(data);
    }

    @Step
    public void successCreateShipmentStep1(boolean expectedMessage) {
        boolean actualMessage = createShipment.successStep1();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Step
    public void completeCreateShipmentFormSenderStep2(Map<String, String> data) {
        createShipmentPageStep2.completeCreateShipmentFormSenderStep2(data);
    }

    @Step
    public void completeCreateShipmentFormReceiverStep2(Map<String, String> data) {
        Utils.javascriptWindowScroll(3000);
        createShipmentPageStep2.completeCreateShipmentFormReceiverStep2(data);
    }

    @Step
    public void successCreateShipmentStep2(boolean expectedMessage) {
        boolean actualMessage = createShipmentPageStep2.successStep2();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
