package econt.steps;

import cucumber.api.PendingException;
import econt.steps.serenity.TrackShipmentStep;

import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class TrackShipmentSteps {
    @Steps
    TrackShipmentStep trackingSteps;


    @Given("^user is on track shipment page$")
    public void userIsOnTrackShipmentPage() {
        trackingSteps.openTrackShipmentPage();
    }

    @And("^click on gdpr agree button$")
    public void clickOnGdprAgreeButton() {
        trackingSteps.gdprAgree();
    }

    @When("^user enters valid data$")
    public void userEntersValidData(@Transpose Map<String, String> data) {
        trackingSteps.fillData(data);
    }


    @Then("^an \"([^\"]*)\" is displayed$")
    public void anIsDisplayed(String number) {
        trackingSteps.successTrack(number);
    }

    @When("^user enters invalid data$")
    public void userEntersInvalidData(@Transpose Map<String, String> data) {
        trackingSteps.fillInvalidData(data);
    }

    @Then("^an error message \"([^\"]*)\" is displayed$")
    public void anErrorMessageIsDisplayed(String error) {
        trackingSteps.unsuccessTrack(error);
    }

    @Then("^an \"([^\"]*)\" for multiply shipments is displayed$")
    public void anForMultiplyShipmentsIsDisplayed(String number) {
        trackingSteps.successTrack(number);
    }
}
