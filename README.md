# ChallengeN5-LatamAirlines-TobiasRiccone
## Descripción
Proyecto de automatización de pruebas UI
## Requisitos
- Java 11 +
- Chrome
## Ejecución
Una vez clonado el proyecto, pararse en el proyecto y ejecutar en la terminal el comando "./gradlew clean CucumberTest", luego ejecutar "./gradlew allureDownload allureServe" para visualizar el reporte
## Características del proyecto
- Desarrollado con Java y Gradle como gestor
- Utiliza Cucumber para definir los casos de prueba
- Genera reportes detallados con Allure (paso a paso con screenshots)
- Ejecución parametrizada con tags. Esto significa que si al comando de ejecución le pasamos "-Dtags="@tag"" se ejecutarán los escenarios con ese tag. Ejemplo: "./gradlew clean CucumberTest -Dtags="@smoke""
- Los datos utilizados en los casos de prueba provienen de un json, por lo que pueden variar en la ejecución dependiendo del json que le pasemos
- Existe la opcion de adjuntar al reporte los pdfs que generan el sitio web. Por default se descargar en "build/downloads" y al hacer "addFile(nombrePDF)" se adjunta
- Tambien podemos movernos entre las pestañas que se abren en el navegador, haciendo "switchWindow(nombrePestaña)"
