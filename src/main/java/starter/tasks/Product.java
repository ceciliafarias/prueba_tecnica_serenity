package starter.tasks;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HtmlAlert;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.userInterfaces.HomePage;
import starter.userInterfaces.ProductPage;

public class Product implements Task {

    public String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public static Product addToCart(String productName) {
        return new Product(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductPage.PRODUCT_ADD_TO_CART));
        WebDriverWait wait = new WebDriverWait(actor.usingAbilityTo(BrowseTheWeb.class).getDriver(),
                Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        actor.attemptsTo(
                Switch.toAlert(),
                Ensure.that(HtmlAlert.text()).contains("Product added"),
                Switch.toAlert().andAccept(),
                Click.on(HomePage.HOME_TITLE));
    }
}
