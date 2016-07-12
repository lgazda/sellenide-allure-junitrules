package pl.net.gazda.test.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class SearchResultsPage {
    public ElementsCollection getResults() {
        return $$("#ires .g");
    }
    public SelenideElement getResult(int index) {
        return $("#ires .g", index);
    }
    public String getTitle() {
        return title();
    }
}