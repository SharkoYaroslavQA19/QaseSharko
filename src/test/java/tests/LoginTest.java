package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void positiveLoginTest() {
        LoginPage.login(USERNAME,PASSWORD);
        Assert.assertTrue(HomePage.homePageOpen());
    }

    @Test(dataProvider = "negativeLoginData")
    public void negativeLoginTest(String userName, String password,String expectedErrorMessage) {
        LoginPage.login(userName, password);
        Assert.assertEquals(LoginPage.getMessageErrorText(), expectedErrorMessage);
    }

    @DataProvider(name = "negativeLoginData")
    public Object [][] negativeLoginTestData(){
        return new Object[][]{
                {"sharko@mail.ru",PASSWORD,"These credentials do not match our records."},
                {USERNAME,"122213","These credentials do not match our records."},
        };
    }
}