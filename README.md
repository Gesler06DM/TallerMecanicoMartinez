# Taller Mecánico Martínez - Sistema de Gestión de Citas

## Descripción del proyecto

Este proyecto fue desarrollado con el objetivo de crear un sistema para administrar las citas de un taller mecánico. El sistema permite registrar y organizar la información de los clientes que solicitan diferentes servicios, facilitando el control de las citas y evitando manejar la información de forma desordenada.

Para desarrollar el proyecto utilicé Java, Maven, JDBC y MariaDB. También desarrollé una interfaz gráfica con Java Swing para que el sistema sea más fácil de utilizar.

## Funciones principales

El sistema permite realizar las operaciones principales de un CRUD:

- Registrar nuevas citas.
- Consultar las citas almacenadas.
- Buscar citas.
- Actualizar la información de una cita.
- Eliminar citas.
- Mostrar las citas registradas en una tabla.
- Validar la información ingresada por el usuario.

## Información de cada cita

Cada cita contiene los siguientes datos:

- ID de la cita.
- Nombre del cliente.
- Fecha y hora.
- Servicio solicitado.
- Duración del servicio en minutos.
- Estado de la cita.

Los estados utilizados son pendiente, completado y cancelada.

## Estructura del proyecto

El proyecto fue dividido principalmente en dos módulos:

### taller_mecanico_citas_core

Este módulo contiene la lógica principal del sistema. Aquí se encuentra el modelo de las citas y el acceso a la base de datos.

Se encarga de realizar operaciones como guardar, consultar, buscar, actualizar y eliminar citas utilizando JDBC.

### taller_mecanico_citas_ui

Este módulo contiene la interfaz gráfica del sistema desarrollada con Java Swing.

Su función es permitir que el usuario pueda ingresar y administrar las citas mediante campos, botones y una tabla. La interfaz se comunica con el módulo Core para realizar las operaciones correspondientes en la base de datos.

## Base de datos

Para almacenar la información utilicé MariaDB.

La conexión con la base de datos se realiza mediante JDBC y permite que la información registrada permanezca almacenada aunque se cierre el programa.

También se utiliza un script SQL para la creación y configuración de la estructura necesaria de la base de datos.

## Validaciones

Durante el desarrollo agregué validaciones para evitar información incorrecta, por ejemplo:

- Campos obligatorios.
- Validación del nombre del cliente.
- Validación de los servicios disponibles.
- Validación de fecha y hora.
- Validación de la duración del servicio.
- Validación del estado de la cita.
- No permitir citas con fecha y hora en el pasado.

## Tecnologías utilizadas

- Java.
- Java Swing.
- JDBC.
- MariaDB.
- Maven.
- Eclipse IDE.

## Funcionamiento general

El usuario ingresa la información de una cita desde la interfaz gráfica. Antes de realizar la operación, el sistema verifica que los datos sean válidos.

Después, la interfaz se comunica con el módulo Core y este se encarga de realizar la operación correspondiente en la base de datos.

De esta manera mantuve separada la interfaz gráfica de la lógica y del acceso a los datos, logrando que el proyecto quedara más organizado y fácil de comprender.

## Autor

Gesler Duque