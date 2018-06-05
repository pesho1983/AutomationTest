package econt.steps;

import cucumber.api.PendingException;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import econt.steps.serenity.OrderCourierStep;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class OrderCourierSteps {
    @Steps
    OrderCourierStep orderCourier;


    @Given("^user is on order courier page$")
    public void userIsOnOrderCourierPage() throws Throwable {
        orderCourier.openOrderCourierPage();
    }

    @And("^complete order courier form$")
    public void completeOrderCourierForm(@Transpose Map<String, String> data) throws Throwable {
        orderCourier.completeOrderCourierform(data);
    }

    @Then("^an success order courier message \"([^\"]*)\" is displayed$")
    public void anSuccessOrderCourierMessageIsDisplayed(String message) throws Throwable {
        orderCourier.successOrder(message);
    }

    @And("^complete order courier form with invalid data$")
    public void completeOrderCourierFormWithInvalidData(@Transpose Map<String, String> data) throws Throwable {
        orderCourier.incompleteOrderCourierForm(data);
    }

    @Then("^an error message for order courier \"([^\"]*)\" should displayed$")
    public void anErrorMessageForOrderCourierShouldDisplayed(String messsage) throws Throwable {
       orderCourier.unsuccessOrder(messsage);
    }
}
