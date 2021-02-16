package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;
import setup.ConfProperties;

public class NativeMobileTests extends BaseTest {

    private String email = ConfProperties.getEmail();
    private String userName = ConfProperties.getUserName();
    private String password = ConfProperties.getPassword();

    //@Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    //public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
    //    getPo().getWelement("signInBtn").click();
    //    System.out.println("Simplest Android native test done");
//
    //}

    @Test(groups = {"native"}, description = "New user registration test")
    public void registerNewAccountTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        getPo().getWelement("regAccount").click();
        getPo().inputText("emailField", email);
        getPo().inputText("userNameField", userName);
        getPo().inputText("passField", password);
        getPo().inputText("confPassField", password);
        getPo().getWelement("regNewAccount").click();
        getPo().inputText("loginField", email);
        getPo().inputText("passwordField", password);
        getPo().getWelement("signInBtn").click();

        assert (getPo().getWelement("BudgetActivity").isDisplayed()) : "Page BudgetActivity is not opened";
    }

}
