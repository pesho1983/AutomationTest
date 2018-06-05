package econt.steps;

import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import econt.steps.serenity.EkontPartnersStep;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class EkontPartnersSteps {
    @Steps
    EkontPartnersStep ekontPartners;

    @Given("^user is on partnership program page$")
    public void userIsOnPartnershipProgramPage() {
        ekontPartners.openEkontPartnersPage();
        ekontPartners.gdprAgree();
    }

    @When("^user read and accept terms$")
    public void userReadAndAcceptTerms() {
        ekontPartners.conditionsAccept();
    }

    @And("^complete application form partnership program$")
    public void completeApplicationFormPartnershipProgram(@Transpose Map<String, String> data) {
        ekontPartners.fillData(data);
    }

    @Then("^an agree message \"([^\"]*)\" is displayed$")
    public void anAgreeMessageIsDisplayed(String message) {
        ekontPartners.successApplayment(message);
    }

    @And("^fill application form partnership program with invalid data$")
    public void fillApplicationFormPartnershipProgramWithInvalidData(@Transpose Map<String, String> data) {
        ekontPartners.fillInvalidData(data);
    }

    @Then("^an error message \"([^\"]*)\" should displayed$")
    public void anErrorMessageShouldDisplayed(String errorMessage) {
        ekontPartners.unsuccessApplayment(errorMessage);
    }
}
