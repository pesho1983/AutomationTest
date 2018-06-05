package econt.steps.serenity;

import econt.Utils.Utils;
import econt.pages.OrderCourierPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Map;

public class OrderCourierStep {

    OrderCourierPage orderCourier;

    @Step
    public void openOrderCourierPage() {
        orderCourier.open();
    }

    @Step
    public void completeOrderCourierform(Map<String, String> data) {
        Utils.javascriptWindowScroll(500);
        orderCourier.completeOrderCourierForm(data);
    }
    @Step
    public void incompleteOrderCourierForm(Map<String, String> data) {
        Utils.javascriptWindowScroll(500);
        orderCourier.invalidCompleteOrderCourierForm(data);
    }
    @Step
    public void successOrder(String message) {
        Utils.javascriptWindowScroll(500);
        String test = orderCourier.succsessOrderCourier();
        Assert.assertEquals(message, test);
    }
    @Step
    public void unsuccessOrder(String message) {
        String test = orderCourier.unsuccsessOrderCourier();
        Assert.assertEquals(message, test);
    }
}
