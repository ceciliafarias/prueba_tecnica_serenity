package starter.userInterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {
    public static final Target HOME_TITLE = Target.the("Home title")
            .located(By.id("nava"));

    public static final Target PRODUCT_TABLE = Target.the("Product table")
            .located(By.xpath("//div[@id='tbodyid']"));

    public static final Target PRODUCT_NAME = Target.the("{0}")
            .locatedBy("//a[text()='{0}']");

    public static final Target MENU_ITEM = Target.the("{0}")
            .locatedBy("//a[text()='{0}']");

    public static final Target NEXT_PAGE_BUTTON = Target.the("Next page button")
            .located(By.id("next2"));

    public static final Target PREVIOUS_PAGE_BUTTON = Target.the("Previous page button")
            .located(By.id("prev2"));

}
