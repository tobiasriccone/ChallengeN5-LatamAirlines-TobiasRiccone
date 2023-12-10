package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebElementUtils.getElementoBy;

public class BasePage {
    By cruzPopup = By.xpath("//button[@aria-label='Cerrar']");

    @Step("Cierra pop up")
    public BasePage cerrarPopup() {
        getElementoBy(cruzPopup).click();

        takeScreenshot();
        return this;
    }
}