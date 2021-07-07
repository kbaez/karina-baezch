# karina-baezch

Api que retorna el precio del Bitcon cada 10 segundos.

Pre-requisitos:

Maven
Java JDK 1.8

Configure su proyecto

Clonar el proyecto desde Github, sitúese en el directorio root del proyecto y ejecute el siguiente comando desde la consola mvn clean install para poder buildear el proyecto y descargar todas sus dependencias. A continuación, puede ejecutar la aplicación con el comando mvn spring-boot:run.

La aplicación ejecutará en el puerto 8080 de localhost.

Una vez que la aplicación este corriendo podra visualizar los precios almacenados que obtiene en el tiempo que es levantado el proyecto en una base de datos que ejecuta en memoria (Database H2). Para consultar los elementos en la BD puede ingresar desde el navegador a http://localhost:8080/h2-console e ingresar con las siguientes credenciales y realizar las consultas necesarias:

User Name: sa 
Password: password

IMPORTANT: Una vez que se detiene y se vuelve a ejecutar la aplicación los elementos almacenados en la base de datos se pierden, ya que se encuentran almacenados en una BD que ejecuta en memoria (H2).

Uso de la API
Consultar un precio por fecha. Reemplace el parámetro date con uno acorde a la hora y fecha que levante el proyecto.
GET "localhost:8080/btc/price?date=2021-07-05T23:21:58"

Status: 200 OK

{
            "lprice": "34567.9",
            "curr1": "BTC",
            "curr2": "USD"
}

Consultar información entre 2 fechas. Reemplace el parámetro date con uno acorde a la hora y fecha que levante el proyecto.
GET "localhost:8080/btc/price?start=2021-07-05T23:21:58&end=2021-07-05T23:25:58"

Status: 200 OK

{
            "avgprice": "34567.9",
            "maxprice": "35567.9",
            "percent": "8.07"
}
