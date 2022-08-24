
package tests;

import Page.DefectPage;
import Page.HomePage;
import Page.Modal.CreateCase;
import Page.Modal.CreateDefect;
import Page.RepositoryPage;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Page.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected final static String USERNAME = "yasharko@mail.ru";
    protected final static String PASSWORD = "Engine@45";
    protected final static String PROJECT_NAME = "QA_19 Yaroslav";
    protected LoginPage LoginPage;
    protected Page.HomePage HomePage;
    protected Page.RepositoryPage RepositoryPage;
    protected Page.Modal.CreateCase CreateCase;
    protected Page.DefectPage DefectPage;
    protected Page.Modal.CreateDefect CreateDefect;
    Faker faker = new Faker();

    @BeforeClass
    public void setUp() {
        LoginPage = new LoginPage();
        CreateCase = new CreateCase();
        HomePage = new HomePage();
        RepositoryPage = new RepositoryPage();
        DefectPage = new DefectPage();
        CreateDefect = new CreateDefect();
    }

    @BeforeMethod
    public void navigate() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1900x1200";
        Configuration.timeout = 10000;
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();

    }
}