package PracaDomowa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class TagsPage {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[6]/a")
    private WebElement addTagButton;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    public TagsPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public AddTagPage openAddEnvironmentPage() {
        clickElement(addTagButton);
        return new AddTagPage(driver, logger);
    }

    private void clickElement(WebElement addTagButton) {
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);

        private void clickElement (WebElement addTagButton){
        }

        private void isElementDisplayed () {
        }
    }

    private boolean isElementDisplayed(WebElement infoBox) {
    }
}