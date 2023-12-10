package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebElementUtils.buildLocatorVariable;
import static utils.WebElementUtils.getElementoBy;

public class SeleccionDeAsientosPage {
    final String PAGE_NAME = "Selecci\u00F3n de asientos: ";

    By asientoDisponible = By.xpath("//button[@aria-disabled='false' and @data-selected='false'][1]");
    String boton = "//button[descendant::span[contains(text(),'%s')]]";

    @Step(PAGE_NAME + "Selecciona {cant} asiento/s disponible")
    public SeleccionDeAsientosPage clickAsientoDisponible(int cant) {
        for (int i = 0 ; i < cant ; i++) getElementoBy(asientoDisponible).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en boton Pasar al siguiente vuelo")
    public SeleccionDeAsientosPage clickBotonPasarAlSiguienteVuelo() {
        By locatorBoton = buildLocatorVariable(boton, "Pasar al siguiente vuelo");

        getElementoBy(locatorBoton).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en Agregar y continuar")
    public SeleccionDeAsientosPage clickBotonAgregarYContinuar() {
        By locatorBoton = buildLocatorVariable(boton, "Agregar y continuar");

        getElementoBy(locatorBoton).click();

        takeScreenshot();
        return this;
    }
}