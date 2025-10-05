package starter.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage {
    public static final Target PURCHASE_TOTAL_AMOUNT = Target.the("Purchase Total Amount")
            .located(By.id("totalp"));
    public static final Target PLACE_ORDER_BUTTON = Target.the("Place Order button")
            .located(By.xpath("//button[text()='Place Order']"));

    public static final Target PLACE_ORDER_MODAL = Target.the("Place Order Modal")
            .located(By.xpath("//div[@id='orderModal']//div[contains(@class,'modal-content')]"));

    public static final Target TOTAL_AMOUNT = Target.the("Total Amount")
            .located(By.id("totalm"));

    public static final Target NAME_INPUT = Target.the("Name Input")
            .located(By.id("name"));

    public static final Target COUNTRY_INPUT = Target.the("Country Input")
            .located(By.id("country"));

    public static final Target CITY_INPUT = Target.the("City Input")
            .located(By.id("city"));

    public static final Target CREDIT_CARD_INPUT = Target.the("Credit Card Input")
            .located(By.id("card"));

    public static final Target MONTH_INPUT = Target.the("Month Input")
            .located(By.id("month"));

    public static final Target YEAR_INPUT = Target.the("Year Input")
            .located(By.id("year"));

    public static final Target PURCHASE_BUTTON = Target.the("Purchase Button")
            .located(By.xpath("//button[text()='Purchase']"));

    public static final Target PURCHASE_SUCCESS_MESSAGE = Target.the("Purchase Success Message")
            .located(By.xpath("//h2[text()='Thank you for your purchase!']"));

    public static final Target CONFIRMATION_ID = Target.the("Purchase ID")
            .located(By.xpath("//p[contains(., 'Id:')]"));

    public static final Target CONFIRMATION_AMOUNT = Target.the("Purchase Amount")
            .located(By.xpath("//p[contains(., 'Amount:')]"));

    public static final Target CONFIRMATION_CARD_NUMBER = Target.the("Purchase Card Number")
            .located(By.xpath("//p[contains(., 'Card Number:')]"));

    public static final Target CONFIRMATION_NAME = Target.the("Purchase Name")
            .located(By.xpath("//p[contains(., 'Name:')]"));

    public static final Target CONFIRMATION_DATE = Target.the("Purchase Date")
            .located(By.xpath("//p[contains(., 'Date:')]"));
}
