package PracaDomowa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class AddTagPage {

        @FindBy(id = "name")
        private WebElement nameField;

        @FindBy(id = "save")
        private WebElement saveButton;

        public AddTagPage(WebDriver driver, Logger logger) {
            super(driver, logger);
        }

        public AddTagPage fillAddTagForm(String TagName) {
            fillElement(nameField, TagName);
            if (TagName != null) {
                fillElement(nameField);
            }
            return this;
        }

    private void fillElement(WebElement nameField, String tagName) {
    }

    public TagsPage submitAddTagForm() {
            clickElement(saveButton);
            return new TagsPage(driver, logger);
        }

    private void clickElement(WebElement saveButton) {
    }
}