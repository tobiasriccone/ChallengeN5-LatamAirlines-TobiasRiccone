# language: es
@smoke
Característica: Navegacion por Latam Airlanes

  Antecedentes:
    Dado el usuario navega hacia el sitio y cierra el pop up

  @id-1
  Escenario: El usuario reserva un vuelo
    Cuando el usuario ingresa los datos del vuelo
    Y selecciona los vuelos
    Y selecciona los asientos
    Y registra el equipaje
    Entonces se muestra el resumen del vuelo
    Y se visualiza las caracteristicas del equipaje especial