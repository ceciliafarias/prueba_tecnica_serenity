package stepDefinitions;

import starter.abilities.NavigateTo;
import starter.questions.ShoppingCartQuestions;
import starter.questions.HomeQuestions;
import starter.questions.ProductQuestions;
import starter.tasks.Home;
import starter.tasks.Product;
import starter.tasks.ShoppingCart;
import utils.Const;
import utils.GenerateData;
import utils.UserData;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PurchaseSteps {
    private int totalPrice = 0;

    @Given("{actor} open the the browser in the shopping page")
    public void theBrowserMustBeOpen(Actor actor) {
        actor.wasAbleTo(NavigateTo.theShoppingPage());
    }

    @Given("is in home page")
    public void theUserIsInHomePage() {
        Ensure.that(HomeQuestions.isOnHomePage().answeredBy(OnStage.theActorInTheSpotlight())).isTrue();
    }

    @When("select and add to cart {string} item")
    public void theUserSelectAItem(String productName) {
        String[] products = productName.split(",");
        for (String product : products) {
            product = product.trim();
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Home.selectProduct(product),
                    Ensure.that(ProductQuestions.productName()).contains(product));
            int productPrice = ProductQuestions.productPrice().answeredBy(OnStage.theActorInTheSpotlight());
            totalPrice += productPrice;
            OnStage.theActorInTheSpotlight().remember(Const.PURCHASE_TOTAL, totalPrice);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Product.addToCart(product));
        }
    }

    @And("go to shopping cart")
    public void goToShoppingCart() {
        int purchaseTotal = OnStage.theActorInTheSpotlight().recall(Const.PURCHASE_TOTAL);
        OnStage.theActorInTheSpotlight().attemptsTo(
            Home.selectMenuItem("Cart"),
            Ensure.that(ShoppingCartQuestions.totalAmountIsVisible()).isTrue(),
            Ensure.that(ShoppingCartQuestions.getTotalAmount()).isEqualTo(purchaseTotal)
        );
    }

    @And("place order")
    public void placeOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShoppingCart.checkoutCartShopping(),
                Ensure.that(ShoppingCartQuestions.isModalVisible()).isTrue());
    }

    @And("fill billing detail form")
    public void fillBillingDetailForm() {
        UserData userData = GenerateData.as(OnStage.theActorInTheSpotlight()).generateUserData();
        OnStage.theActorInTheSpotlight().remember(Const.USER_DATA, userData);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShoppingCart.fillBillingForm(userData.getName(), userData.getCountry(), userData.getCity(),
                        userData.getCreditCard(), userData.getMonth(), userData.getYear()));
    }

    @Then("the purchase must be successful")
    public void thePurchaseMustBeSuccessful() {
        int purchaseTotal = OnStage.theActorInTheSpotlight().recall(Const.PURCHASE_TOTAL);
        UserData userData = OnStage.theActorInTheSpotlight().recall(Const.USER_DATA);
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern(Const.DATE_FORMAT)); 
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ShoppingCartQuestions.getConfirmationId()).isNotNull(),
                Ensure.that(ShoppingCartQuestions.getConfirmationAmount()).isEqualTo(purchaseTotal),
                Ensure.that(ShoppingCartQuestions.getConfirmationCardNumber()).isEqualTo(userData.getCreditCard()),
                Ensure.that(ShoppingCartQuestions.getConfirmationName()).isEqualTo(userData.getName()),
                Ensure.that(ShoppingCartQuestions.getConfirmationDate()).isEqualTo(today));
    }
}
