package Page.Modal;

import Elements.Input;
import Model.TestCase;

import static com.codeborne.selenide.Selenide.$;

public class CreateCase {
    public void fillForm(TestCase inputTestCase) {
        $("#title").setValue(inputTestCase.getTitle());
        new Input("Description").setValue(inputTestCase.getDescription());
        new Input("Pre-conditions").setValue(inputTestCase.getPreConditions());
        new Input("Post-conditions").setValue(inputTestCase.getPostConditions());

    }

    public void saveButtonClick() {
        $(("#save-case")).click();
    }
}