package Page.Modal;

import Elements.Input;
import Model.Defect;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateDefect {
    public void fillForm(Defect inputDefect) {
        $("#title").setValue(inputDefect.getDefectTitle());
        new Input("Actual result").setValue(inputDefect.getActualResult());

    }

    public void CreateDefectClick() {
        $((By.xpath("//button[text()='Create defect']"))).click();
    }
}
