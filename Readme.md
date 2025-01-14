
# Conversor de Monedas - Alura

Este es un proyecto de conversor de monedas, diseñado como parte de un desafío en el curso de Alura. La aplicación permite realizar conversiones entre distintas monedas utilizando una API externa para obtener tasas de cambio actualizadas.

## Descripción

El proyecto ofrece una interfaz de consola donde el usuario puede seleccionar el tipo de moneda que desea convertir y la moneda de destino. A través de una API externa, se obtienen las tasas de cambio y se calcula el valor convertido. Este proyecto permite practicar la interacción con APIs y el manejo de datos en tiempo real en una aplicación Java.

## Características

- **Conversión de Monedas**: El sistema permite convertir entre varias monedas como USD, ARS, EUR, entre otras.
- **Interacción con una API externa**: Utiliza una API pública para obtener las tasas de conversión en tiempo real.
- **Interfaz en Consola**: El proyecto tiene una interfaz de línea de comandos para la interacción con el usuario.

## Tecnologías utilizadas

- **Java 17**: El proyecto está desarrollado en Java utilizando las últimas características del lenguaje.
- **API de Tasa de Cambio**: Utiliza una API pública para obtener las tasas de conversión.
- **Gson**: Utilizado para procesar las respuestas JSON de la API.
- **HttpClient**: Para realizar las solicitudes HTTP a la API externa.

## Instalación

Sigue estos pasos para instalar y ejecutar el proyecto:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/JuanMA0190/ConversorMonedasAlura.git
   ```

2. **Compila el proyecto**:
   Puedes usar cualquier IDE como IntelliJ IDEA o Eclipse para compilar el proyecto. Si prefieres trabajar con la terminal, puedes utilizar Maven o Gradle.

3. **Configura tu API Key**:
   Este proyecto utiliza una clave API para acceder a la API de tasas de cambio. Asegúrate de crear una cuenta en la API correspondiente y colocar la clave en el archivo `ApiKey.txt`.

4. **Ejecuta el proyecto**:
   Una vez configurado, puedes ejecutar el archivo principal desde tu IDE o a través de la terminal:
   ```bash
   java -jar ConversorMonedasAlura.jar
   ```

## Uso

Una vez ejecutado el programa, el usuario podrá ver un menú interactivo para seleccionar las monedas de origen y destino, además de ingresar el valor a convertir. La aplicación utilizará la API para obtener las tasas de cambio y mostrar el resultado final.

## Ejemplo de ejecución

```
*******************************************************************
           Sea bienvenido/a al Conversor de Moneda:
                
*******************************************************************
                
0) Dolar => Peso argentino
1) Peso argentino => Dolar
2) Dolar => Real brasileño
3) Real brasileño => Dolar
4) Dolar => Peso colombiano
5) Peso colombiano => Dolar
6) Salir

*******************************************************************
Elija una opción:

0

Ingrese el valor que desea cambiar:

500

El valor = 500,0 [USD] corresponde al valor final de => 520125,00 [ARS]
```

## Contribuciones

Las contribuciones son bienvenidas. Si tienes una mejora o una corrección, puedes realizar un pull request con tus cambios.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

¡Gracias por usar el Conversor de Monedas Alura! Si tienes alguna duda, no dudes en abrir un issue o contactar al autor.
