package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.AllureUtils.takeScreenshot;
import static utils.WebDriverUtils.WAIT;
import static utils.WebElementUtils.*;

public class TiendaPage {
    final String PAGE_NAME = "Tienda: ";

    By botonEquipajeEspecial = By.xpath("//button[descendant::h3[text()='Equipaje especial']]");
    By botonVerCaracteristicas = By.xpath("//a[text()='Ver caracter\u00EDsticas']");
    By detalleDelViaje = By.xpath("//h2[text()='Detalle de viaje']");
    String boton = "//button[descendant::span[text()='%s']]";
    String sumarEquipaje = "//strong[contains(text(),'equipaje')]/../../following-sibling::ul/li//button[@data-testid='add-%s-baggage']";

    @Step(PAGE_NAME + "Click en sumar equipaje de {kilos} kilos")
    public TiendaPage clickEnSumarEquipaje(int kilos) {
        By locatorBotonSumarEquipaje = buildLocatorVariable(sumarEquipaje, String.valueOf(kilos));
        WAIT.until(ExpectedConditions.elementToBeClickable(locatorBotonSumarEquipaje));

        getElementoBy(locatorBotonSumarEquipaje).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en vuelta")
    public TiendaPage clickVuelta() {
        By locatorBotonVuelta = buildLocatorVariable(boton, "Vuelta");

        getElementoBy(locatorBotonVuelta).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en equipaje especial")
    public TiendaPage clickEquipajeEspecial() {
        getElementoBy(botonEquipajeEspecial).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en Ver Caracter\u00EDsticas")
    public TiendaPage clickVerCaracteristicas() {
        getElementoBy(botonVerCaracteristicas).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Click en Agregar y continuar")
    public TiendaPage clickAgregarYContinuar() {
        By locatorBoton = buildLocatorVariable(boton, "Agregar y continuar");

        getElementoBy(locatorBoton).click();

        takeScreenshot();
        return this;
    }

    @Step(PAGE_NAME + "Se muestra el detalle del viaje")
    public TiendaPage seMuestraElDetalleDelViaje() {
        boolean seMuestra = getElementoBy(detalleDelViaje).isDisplayed();

        Assert.assertTrue("No se muestra el detalle del viaje", seMuestra);

        takeScreenshot();
        return this;
    }
}