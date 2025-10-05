package starter.questions;

import starter.userInterfaces.HomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class HomeQuestions {

    public static Question<Boolean> isOnHomePage() {
        WaitUntil.the(HomePage.HOME_TITLE, WebElementStateMatchers.isVisible());
        return Question.about("Is on home page").answeredBy(
                actor -> BrowseTheWeb.as(actor).find(HomePage.HOME_TITLE).isDisplayed());
    }

    public static Question<Boolean> isProductVisible(String productName) {
        return Question.about("The product " + productName + " is visible").answeredBy(
                actor -> {
                    try {
                        BrowseTheWeb.as(actor).find(HomePage.PRODUCT_NAME.of(productName)).isDisplayed();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    public static Question<Boolean> isProductTableVisible() {
        return Question.about("The product table is visible").answeredBy(
                actor -> BrowseTheWeb.as(actor).find(HomePage.PRODUCT_TABLE).isDisplayed());
    }

    public static Question<Boolean> isNextPageButtonClickable() {
        return Question.about("The next page button is clickable").answeredBy(
                actor -> {
                    try {
                        BrowseTheWeb.as(actor).find(HomePage.NEXT_PAGE_BUTTON).isClickable();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
    }
}
