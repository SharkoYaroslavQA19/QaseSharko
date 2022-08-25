package tests;

import Model.Defect;;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateDefectTest extends BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void login() {
        LoginPage.login(USERNAME, PASSWORD);
    }

    @Test
    public void createDefect() {
        HomePage.openProject(PROJECT_NAME);
        RepositoryPage.defectsButtonClick();
        DefectPage.addDefectButtonClick();
        Defect newDefect = Defect.builder()
                .defectTitle(faker.address().city())
                .actualResult(faker.name().username())
                .build();
        CreateDefect.fillForm(newDefect);
        CreateDefect.CreateDefectClick();
        Assert.assertTrue(DefectPage.createDefect(newDefect.getDefectTitle()), String.format(newDefect.getDefectTitle()));




    }
}
