package steps;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pages.*;

import java.io.File;

import static utils.JsonUtils.*;
import static utils.WebDriverUtils.DRIVER;
import static utils.WebDriverUtils.switchWindow;

public class StepsDefinitions {
    private final BasePage basePage = new BasePage();
    private final HomePage homePage = new HomePage();
    private final SeleccionDeVuelosPage seleccionDeVuelosPage = new SeleccionDeVuelosPage();
    private final SeleccionDeAsientosPage seleccionDeAsientosPage = new SeleccionDeAsientosPage();
    private final TiendaPage tiendaPage = new TiendaPage();
    private final JsonNode data = getJsonNodeByFile(new File("src/test/resources/data/VueloData.json"));

    @Dado("^el usuario navega hacia el sitio y cierra el pop up$")
    public void elUsuarioNavegaHaciaElSitioYCierraElPopUp() {
        DRIVER.get(System.getProperty("appUrl"));
        basePage.cerrarPopup();
    }

    @Cuando("^el usuario ingresa los datos del vuelo$")
    public void elUsuarioIngresaLosDatosDelVuelo() {
        homePage
                .agregarPasajeros(
                        getIntValue(data, "/pasajeros/cantidad") - 1,
                        getStringValue(data, "/pasajeros/tipoPasajeroExtra")
                )
                .seleccionarCabina(getStringValue(data, "/cabina"))
                .ingresarOrigen(getStringValue(data, "/origen"))
                .ingresarDestino(getStringValue(data, "/destino"))
                .ingresarFechaIda(
                        getIntValue(data, "/fechaIda/anio"),
                        getStringValue(data, "/fechaIda/mes"),
                        getIntValue(data, "/fechaIda/dia")
                )
                .ingresarFechaVuelta(
                        getIntValue(data, "/fechaVuelta/anio"),
                        getStringValue(data, "/fechaVuelta/mes"),
                        getIntValue(data, "/fechaVuelta/dia")
                )
                .clickBotonBuscar();
    }

    @Y("^selecciona los vuelos$")
    public void seleccionaLosVuelos() {
        switchWindow("Selecci\u00F3n de vuelos");
        basePage.cerrarPopup();
        seleccionDeVuelosPage
                .seleccionarPrimerVuelo("ida", getStringValue(data, "/cabina"))
                .seleccionarPrimerVuelo("vuelta", getStringValue(data, "/cabina"))
                .clickBotonIrAAsientos();
    }

    @Y("^selecciona los asientos$")
    public void seleccionaLosAsientos() {
        seleccionDeAsientosPage
                .clickAsientoDisponible(getIntValue(data, "/pasajeros/cantidad"))
                .clickBotonPasarAlSiguienteVuelo()
                .clickAsientoDisponible(getIntValue(data, "/pasajeros/cantidad"))
                .clickBotonAgregarYContinuar();
    }

    @Y("^registra el equipaje$")
    public void seleccionaElEquipaje() {
        tiendaPage
                .clickEnSumarEquipaje(getIntValue(data, "/pesoEquipaje"))
                .clickVuelta()
                .clickEnSumarEquipaje(getIntValue(data, "/pesoEquipaje"))
                .clickEquipajeEspecial()
                .clickVerCaracteristicas()
                .clickAgregarYContinuar();
    }

    @Entonces("^se muestra el resumen del vuelo$")
    public void seMuestranElResumenDelVuelo() {
        tiendaPage.seMuestraElDetalleDelViaje();
    }

    @Y("^se visualiza las caracteristicas del equipaje especial$")
    public void seVisualizaLasCaracteristicasDelEquipajeEspecial() {
        switchWindow("Equipaje especial");
    }
}