package tests;

import Model.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCaseTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        LoginPage.login(USERNAME,PASSWORD);
    }


    @Test
    public void createCase() {
        HomePage.openProject(PROJECT_NAME);
        RepositoryPage.addCaseClick();
        TestCase newTestCase = TestCase.builder()
                .title(faker.address().city())
                .description(faker.animal().name())
                .preConditions(faker.name().username())
                .postConditions(faker.name().username())
                .build();
        CreateCase.fillForm(newTestCase);
        CreateCase.saveButtonClick();
        Assert.assertTrue(RepositoryPage.createCase(newTestCase.getTitle()), String.format(newTestCase.getTitle()));

    }
}