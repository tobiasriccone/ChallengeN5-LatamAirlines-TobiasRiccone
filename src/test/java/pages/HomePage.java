package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebElementUtils.*;

public class HomePage {
    final String PAGE_NAME = "Home: ";

    String boton = "//button[descendant::span[contains(text(),'%s')]]";
    String input = "//input[@placeholder='%s']";
    String desplegable = "//span[text()='%s']";

    @Step(PAGE_NAME + "Agrega {cant} pasajero/s de tipo {tipoPasajero}")
    public HomePage agregarPasajeros(int cant, String tipoPasajero) {
        By locatorBotonDesplegable = buildLocatorVariable(boton, "1 pasajero");
        By locatorBotonSumarPasajero = buildLocatorVariable(boton, "Agregar un " + tipoPasajero);

        getElementoBy(locatorBotonDesplegable).click();
        for (int i = 0 ; i < cant ; i++) getElementoBy(locatorBotonSumarPasajero).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Selecciona cabina {tipoCabina}")
    public HomePage seleccionarCabina(String tipoCabina) {
        By locatorDesplegableCabina = buildLocatorVariable(boton, "Seleccionar tipo de cabina");
        By locatorCabina = buildLocatorVariable(boton, tipoCabina);

        getElementoBy(locatorDesplegableCabina).click();
        getElementoBy(locatorCabina).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Ingresa {origen} como Origen")
    public HomePage ingresarOrigen(String origen) {
        By locatorInputOrigen = buildLocatorVariable(input, "Origen");
        By desplegableOrigenLocator = buildLocatorVariable(desplegable, origen);

        getElementoBy(locatorInputOrigen).sendKeys(origen);
        getElementoBy(desplegableOrigenLocator).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Ingresa {destino} como Destino")
    public HomePage ingresarDestino(String destino) {
        By locatorInputDestino = buildLocatorVariable(input, "Destino");
        By desplegableDestinoLocator = buildLocatorVariable(desplegable, destino);

        getElementoBy(locatorInputDestino).sendKeys(destino);
        getElementoBy(desplegableDestinoLocator).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Ingresa {dia} de {mes} del {anio} como Fecha de Ida")
    public HomePage ingresarFechaIda(int anio, String mes, int dia) {
        By locatorInputFechaIda = buildLocatorVariable(input, "Fecha");
        String mesAnio = mes + " " + anio;
        By locatorFecha = By.xpath("//strong[text()='" + mesAnio + "']/../following-sibling::table//span[text()='" + dia + "']");

        getElementoBy(locatorInputFechaIda).click();
        getElementoBy(locatorFecha).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Ingresa {dia} de {mes} del {anio} como Fecha de Vuelta")
    public HomePage ingresarFechaVuelta(int anio, String mes, int dia) {
        String mesAnio = mes + " " + anio;
        By locatorFecha = By.xpath("//strong[text()='" + mesAnio + "']/../following-sibling::table//span[text()='" + dia + "']");

        getElementoBy(locatorFecha).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click bot\u00F3n Buscar")
    public HomePage clickBotonBuscar() {
        By locatorBotonBuscar = buildLocatorVariable(boton, "Buscar");

        getElementoBy(locatorBotonBuscar).click();

        takeScreenshot();
        return this;
    }
}