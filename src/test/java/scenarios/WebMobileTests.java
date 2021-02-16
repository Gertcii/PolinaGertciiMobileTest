package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.ConfProperties;

import java.util.List;

public class WebMobileTests extends BaseTest {

    private String inputText = ConfProperties.getInputText();
    private String url = ConfProperties.getUrl();

   // @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
   // public void simpleWebTest() throws InterruptedException {
   //     getDriver().get("http://iana.org"); // open IANA homepage
//
   //     // Make sure that page has been loaded completely
   //     new WebDriverWait(getDriver(), 10).until(
   //             wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
   //     );
//
   //     // Check IANA homepage title
   //     assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";
//
   //     // Log that test finished
   //     System.out.println("Site opening done");
   // }

    @Test(groups = {"web"}, description = "Search via google search field and check that we have a proper results")
    public void googleSearchTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        getDriver().get(url);

        getPo().getWelement("searchTextField").click();
        getPo().inputText("searchTextField", inputText);
        List<WebElement> searchResult = getPo().getWebElements("resultList");

        assert (searchResult.size() > 0);

    }

}
