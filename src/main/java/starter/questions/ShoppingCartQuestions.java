package starter.questions;

import starter.userInterfaces.ShoppingCartPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ShoppingCartQuestions {
    public static Question<Boolean> totalAmountIsVisible() {
        WaitUntil.the(ShoppingCartPage.PURCHASE_TOTAL_AMOUNT, WebElementStateMatchers.isPresent())
                .forNoMoreThan(10).seconds();
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.PURCHASE_TOTAL_AMOUNT).isVisible();
    }

    public static Question<Integer> getTotalAmount() {
        return actor -> Integer.parseInt(BrowseTheWeb.as(actor).find(ShoppingCartPage.PURCHASE_TOTAL_AMOUNT).getText());
    }

    public static Question<Boolean> isModalVisible() {
        WaitUntil.the(ShoppingCartPage.PLACE_ORDER_MODAL, WebElementStateMatchers.isCurrentlyVisible())
                .forNoMoreThan(10).seconds();
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.PLACE_ORDER_MODAL).isVisible();
    }

    public static Question<String> getConfirmationId() {
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.CONFIRMATION_ID).getText().split("Id:")[1]
                .split("\\n")[0].trim();
    }

    public static Question<Integer> getConfirmationAmount() {
        return actor -> Integer.parseInt(BrowseTheWeb.as(actor).find(ShoppingCartPage.CONFIRMATION_AMOUNT).getText()
                .split("Amount:")[1]
                .split("\n")[0].replace("USD", "").trim());
    }

    public static Question<String> getConfirmationCardNumber() {
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.CONFIRMATION_CARD_NUMBER).getText()
                .split("Card Number:")[1]
                .split("\n")[0].trim();
    }

    public static Question<String> getConfirmationName() {
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.CONFIRMATION_NAME).getText().split("Name:")[1]
                .split("\n")[0].trim();
    }

    public static Question<String> getConfirmationDate() {
        return actor -> BrowseTheWeb.as(actor).find(ShoppingCartPage.CONFIRMATION_DATE).getText().split("Date:")[1]
                .split("\n")[0].trim();
    }
}
