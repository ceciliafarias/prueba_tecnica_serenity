package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.userInterfaces.ShoppingCartPage;

public class ShoppingCart {
    
    public static Task checkoutCartShopping() {
        WaitUntil.the(ShoppingCartPage.PLACE_ORDER_BUTTON, WebElementStateMatchers.isClickable())
                .forNoMoreThan(10).seconds();
        return Task.where("{0} place order",
                Click.on(ShoppingCartPage.PLACE_ORDER_BUTTON));
    }

    public static Task fillBillingForm(String name, String country, String city, String creditCard, String month, String year) {
        return Task.where("{0} fill billing form",
                Enter.theValue(name).into(ShoppingCartPage.NAME_INPUT),
                Enter.theValue(country).into(ShoppingCartPage.COUNTRY_INPUT),
                Enter.theValue(city).into(ShoppingCartPage.CITY_INPUT),
                Enter.theValue(creditCard).into(ShoppingCartPage.CREDIT_CARD_INPUT),
                Enter.theValue(month).into(ShoppingCartPage.MONTH_INPUT),
                Enter.theValue(year).into(ShoppingCartPage.YEAR_INPUT),
                Click.on(ShoppingCartPage.PURCHASE_BUTTON));
    }
}
