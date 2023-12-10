package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebElementUtils.*;

public class SeleccionDeVuelosPage {
    final String PAGE_NAME = "Selecci\u00F3n de vuelos: ";

    By botonIrAAsientos = By.xpath("//button[descendant::span[contains(text(),'Ir a asientos')]]");
    String primerVuelo = "//span[contains(text(),'vuelo de %s')]/../../../../following-sibling::ol/li[1]";
    String categoriaVuelo = "//span[text()='%s']/../following-sibling::div//button";

    @Step(PAGE_NAME + "Seleccionar primer vuelo de {tipoVuelo} con categor\u00EDa {categoria}")
    public SeleccionDeVuelosPage seleccionarPrimerVuelo(String tipoVuelo, String categoria) {
        By locatorVueloAElegir = buildLocatorVariable(primerVuelo, tipoVuelo);
        By locatorCategoriaVuelo = buildLocatorVariable(this.categoriaVuelo, categoria);

        getElementoBy(locatorVueloAElegir).click();
        getElementoBy(locatorCategoriaVuelo).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click bot\u00F3n Ir a asientos")
    public SeleccionDeVuelosPage clickBotonIrAAsientos() {
        getElementoBy(botonIrAAsientos).click();

        takeScreenshot();
        return this;
    }
}