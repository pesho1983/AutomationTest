package econt.steps;

import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import econt.steps.serenity.CreateShipmentStep;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class CreateShipmentSteps {

    @Steps
    CreateShipmentStep createShipment;

    @Given("^user is on create shipment page$")
    public void userIsOnCreateShipmentPage() throws Throwable {
        createShipment.openEkontPartnersPage();
        createShipment.gdprAgree();
    }


    @When("^complete create shipment Step One form documents$")
    public void completeCreateShipmentStepOneFormDocuments(@Transpose Map<String, String> data) throws Throwable {
        createShipment.completeCretateShipmentFormStep1(data);
    }

    @Then("^\"([^\"]*)\" you cah fill data in Step Two$")
    public void youCahFillDataInStepTwo(boolean expectedMessage) throws Throwable {
        createShipment.successCreateShipmentStep1(expectedMessage);
    }


    @Then("^\"([^\"]*)\" you cah fill data in Step Tree$")
    public void youCahFillDataInStepTree(boolean expectedMessage) throws Throwable {
        createShipment.successCreateShipmentStep2(expectedMessage);
    }

    //@And("^complete create shipment Step Two form$")
    //public void completeCreateShipmentStepTwoForm(@Transpose Map<String, String> data) throws Throwable {
    //    createShipment.completeCreateShipmentFormStep2(data);
    //}

    @And("^complete create shipment Step Two form for sender$")
    public void completeCreateShipmentStepTwoFormForSender(@Transpose Map<String, String> data) throws Throwable {
        createShipment.completeCreateShipmentFormSenderStep2(data);
    }

    @And("^complete create shipment Step Two form for receiver$")
    public void completeCreateShipmentStepTwoFormForReceiver(@Transpose Map<String, String> data) throws Throwable {
        createShipment.completeCreateShipmentFormReceiverStep2(data);
    }
}
