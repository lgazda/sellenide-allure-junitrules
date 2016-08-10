package pl.net.gazda.test.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplicationPage {
    @FindBy(how = How.ID, using = "userSelect")
    private SelenideElement userSelect;
    @FindBy(how = How.ID, using = "showMessageButton")
    private SelenideElement showMessageButton;
    @FindBy(how = How.ID, using = "messageBox")
    private SelenideElement messageBox;

    public ApplicationPage selectUser(String name) {
        userSelect().selectOptionByValue(name);
        return this;
    }

    public ApplicationPage clickShowMessageButton() {
        showMessageButton.click();
        return this;
    }

    public SelenideElement userSelect() {
        return userSelect;
    }

    public ElementsCollection userSelectOptions() {
        return userSelect.$$("option");
    }

    public SelenideElement messageBox() {
        return messageBox;
    }
}
