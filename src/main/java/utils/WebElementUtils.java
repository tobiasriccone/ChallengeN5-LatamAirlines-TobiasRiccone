package utils;

import org.openqa.selenium.*;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebDriverUtils.*;

public class WebElementUtils {
    public static WebElement getElementoBy(By locator) {
        try { return DRIVER.findElement(locator); }
        catch (NoSuchElementException e) {
            takeScreenshot();
            String mensajeError = "No se encontro el elemento con el locator " + locator + " despues de " + System.getProperty("elementWait") + " segundos";
            throw new AssertionError(mensajeError);
        }
    }

    public static By buildLocatorVariable(String xpath, String variable) {
        String botonSumarEquipaje = String.format(xpath, variable);
        return By.xpath(botonSumarEquipaje);
    }
}