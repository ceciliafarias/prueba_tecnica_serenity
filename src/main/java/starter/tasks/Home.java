package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.HomeQuestions;
import starter.userInterfaces.HomePage;

public class Home {

    public static Performable selectProduct(String productName) {
        WaitUntil.the(HomePage.PRODUCT_TABLE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(10).seconds();
        return Task.where("{0} select " + productName,
                actor -> {
                    Boolean productIsVisible = HomeQuestions.isProductVisible(productName).answeredBy(actor);
                    Boolean nextPageButtonIsClickable = HomeQuestions.isNextPageButtonClickable().answeredBy(actor);
                    while (!productIsVisible && nextPageButtonIsClickable) {
                        actor.attemptsTo(
                                Click.on(HomePage.NEXT_PAGE_BUTTON)
                        );
                        productIsVisible = HomeQuestions.isProductVisible(productName).answeredBy(actor);
                        nextPageButtonIsClickable = HomeQuestions.isNextPageButtonClickable().answeredBy(actor);
                    }
                    if (productIsVisible) {
                        actor.attemptsTo(
                                Click.on(HomePage.PRODUCT_NAME.of(productName))
                        );
                    } else {
                        throw new AssertionError("Product " + productName + " is not visible");
                    }
                }
        );
    }

    public static Task selectMenuItem(String menuItem) {
        WaitUntil.the(HomePage.MENU_ITEM.of(menuItem), WebElementStateMatchers.isClickable())
                .forNoMoreThan(10).seconds();
        return Task.where("{0} select " + menuItem,
                Click.on(HomePage.MENU_ITEM.of(menuItem)));
    }
}
