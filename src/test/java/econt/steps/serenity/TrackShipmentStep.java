package econt.steps.serenity;

import econt.pages.TrackShipmentPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class TrackShipmentStep {

    TrackShipmentPage trackShipmentPage;


    @Step
    public void openTrackShipmentPage() {
        trackShipmentPage.open();
    }

    @Step
    public void gdprAgree() {
        trackShipmentPage.gdprAgree();
    }

    @Step
    public void fillData(Map<String, String> data) {
        String parcelNumber = data.get("shipment number");
        trackShipmentPage.completeForm(parcelNumber);
    }

    @Step
    public void fillInvalidData(Map<String, String> data) {
        String parcelNumber = data.get("shipment number");
        trackShipmentPage.testForm(parcelNumber);
    }

    @Step
    public void successTrack(String number) {
        String trackShipmentNumber = trackShipmentPage.getTrackShipmentNumber();
        Assert.assertEquals(number, trackShipmentNumber);
    }

    @Step
    public void unsuccessTrack(String number) {
        String errorMessage = trackShipmentPage.errorMessageDisplayed();
        Assert.assertEquals(number, errorMessage);
    }

}
