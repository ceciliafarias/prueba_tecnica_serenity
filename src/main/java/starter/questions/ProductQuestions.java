package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.userInterfaces.ProductPage;

public class ProductQuestions {

        public static Question<String> productName() {
                WaitUntil.the(ProductPage.PRODUCT_NAME, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(10).seconds();
                return Question.about("product name")
                                .answeredBy(actor -> BrowseTheWeb.as(actor).find(ProductPage.PRODUCT_NAME).getText());
        }

        public static Question<Integer> productPrice() {
                WaitUntil.the(ProductPage.PRODUCT_PRICE, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(10).seconds();
                return Question.about("product price")
                                .answeredBy(actor -> Integer
                                                .parseInt(BrowseTheWeb.as(actor).find(ProductPage.PRODUCT_PRICE)
                                                                .getText().split("\\*")[0]
                                                                .replace(" ", "").replace("$", "")));
        }
}
