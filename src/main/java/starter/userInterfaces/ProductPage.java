package starter.userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage extends PageObject {

    public static final Target PRODUCT_NAME = Target.the("Product name")
            .locatedBy("//h2[@class='name']");

    public static final Target PRODUCT_PRICE = Target.the("Product price")
            .locatedBy("//h3[@class='price-container']");

    public static final Target PRODUCT_ADD_TO_CART = Target.the("Add to cart button")
            .locatedBy("//a[text()='Add to cart']");
}
