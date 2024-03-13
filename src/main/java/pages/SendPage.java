package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

public class SendPage extends BasePage{

    MyLogger myLogger;

    public SendPage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Address or Domain Name\"]/following-sibling::android.widget.EditText)[1]")
    WebElement addressInput;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Amount\"]/following-sibling::android.widget.EditText)[1]")
    WebElement amountInput;

    public boolean isAddressInputDisplayed(){
        return AppiumUtils.isElementDisplayed(addressInput, driver);
    }

    public boolean isAmountInputDisplayed(){
        return AppiumUtils.isElementDisplayed(amountInput, driver);
    }
}
