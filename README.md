# Microservicio calculadora
Microservicio de calculadora utilizando las tecnologías de Spring-boot y Maven que expone una API que, a partir de unos parámetros de entrada, es capaza de  realiza las funcionalidades básicas de suma y resta.


## Estructura
Para comprender adecuadamente un proyecto Maven Spring Boot, es importante entender la estructura de carpetas y archivos que éste contiene. El proyecto sigue una convención de estructura de directorios, lo que facilita su comprensión y su mantenimiento.

La estructura se divide en dos carpetas principales: "src" y "target". La carpeta "src" a su vez contiene dos subcarpetas importantes: "main" y "test". La primera de ellas, "src/main", es donde se encuentra el código fuente del proyecto y es donde se realiza el trabajo principal de desarrollo. La carpeta "src/test" es donde se encuentran las pruebas unitarias del proyecto.

Dentro de "src/main", hay varias carpetas que tienen un propósito específico en el proyecto:
- La carpeta "controller" contiene las clases de controladores o endpoints de la aplicación, que son los encargados de recibir las solicitudes HTTP y proporcionar las respuestas correspondientes.
- La carpeta "exception" contiene las clases de excepciones personalizadas que se lanzan cuando ocurre algún error en la aplicación. Además contiene la clase RestExceptionHandler que es un controlador de excepciones.
- La carpeta "factory" contiene la clase "OperacionFactory", que es una fábrica de objetos encargada de crear instancias de las clases que implementan la interfaz "Operacion".
- La carpeta "service" contiene las clases que definen la lógica de negocio de la aplicación. En este caso, la calculadora realiza operaciones matemáticas y las clases que implementan la interfaz "Operacion" son las encargadas de realizar los cálculos.
- La carpeta "util" contiene clase TracerConfiguration, para registrar el resultado de la operación.
- La carpeta "resources" los archivos de configuración de la aplicación

![imagen](https://user-images.githubusercontent.com/115168729/233434974-4c778540-abcb-4146-8aa2-59f109fac0ea.png)

## Dependencias
A continuación se indican las dependencias utilizadas en el proyecto:
- _spring-boot-starter-web_: una dependencia que proporciona las funcionalidades para construir aplicaciones web usando Spring Boot. Incluye Tomcat como servidor embebido.
- _spring-boot-starter-validation_: una dependencia que agrega soporte para la validación de datos en Spring y otros componentes de Spring, utilizando las anotaciones de validación.
- _spring-boot-starter-test_: una dependencia que proporciona un conjunto de librerías para escribir pruebas unitarias y de integración en Spring Boot, incluyendo JUnit, Mockito, y más.
- _io.corp.calculator:tracer_: una dependencia externa que, que se instala localmente a través del plugin de Maven Install. Esta librería puede ser una herramienta de rastreo de la ejecución del código que puede ser usada para la resolución de problemas y para el análisis de rendimiento.

Además, hay tres plugins de construcción:
- _spring-boot-maven-plugin_: un plugin que proporciona soporte para la creación de un archivo ejecutable (jar) para Spring Boot, lo que significa que puede ser ejecutado como una aplicación independiente sin necesidad de un servidor de aplicaciones externo.
- _maven-install-plugin_: un plugin que permite instalar una dependencia que no se encuentra en un repositorio Maven local o remoto, en el repositorio local de Maven. En este caso, se usa para instalar la librería "tracer" localmente.
- _jacoco-maven-plugin_: un plugin que se utiliza para la generación de un informe de cobertura de código que muestra la cantidad de código que se ejecutó durante las pruebas. Se puede consultar el informe en la ruta "target\site\jacoco\index.html"

## Funcionalidades implementadas y alcance del servicio 
El proyecto implementa una API REST que proporciona una funcionalidad de calculadora básica. La API tiene un endpoint calculo que acepta dos parámetros: una lista de n operandos y una cadena que indica la operación a realizar.

Para realizar el cálculo, se utiliza una interfaz Operacion que tiene un método calcular que acepta una lista de operandos y devuelve el resultado de la operación. Las clases Suma y Resta implementan la interfaz Operacion y se utilizan para realizar las operaciones de suma y resta, respectivamente.

La clase OperacionFactory es una clase auxiliar que crea instancias de objetos Operacion en función del parámetro de operación recibido en el endpoint calculo. Si el parámetro no es suma o resta, se lanza una excepción OperacionInvalidaException. 
La fábrica se encarga de devolver la instancia adecuada de Operacion según el operador recibido. De esta manera, se puede agregar nuevas implementaciones de Operacion sin modificar el código de la clase CalculadoraServiceImpl.

La clase CalculadoraServiceImpl es una implementación de la interfaz CalculadoraService, que utiliza la clase OperacionFactory para obtener una instancia de Operacion y realizar el cálculo con los operandos recibidos.

Como se comentaba anteriormente, el servicio gestiona también los errores cuando se introducen parámetros incorrectos o no válidos. Si se introduce una operación no válida, se devuelve un error 400 Bad Request con un mensaje de error que indica que la operación no es válida. Si se omiten los operandos, se devuelve un error 400 Bad Request con un mensaje de error que indica que los operandos no son válidos.

En resumen, la API implementa la funcionalidad básica de una calculadora, permitiendo realizar operaciones de suma y resta con una lista de operandos y devolviendo el resultado en formato JSON a través del endpoint calculo.


## Procedimientos de compilación y ejecución 
- Descargar el proyecto de Github `git clone https://github.com/JorgeDevGit/calculadora.git`
- Opcional. Generar el informe jacoco con `mvn verify`
- Compilación y construcción del .jar `mvn clean install`
- Para ejecutar la aplicación situarse en la carpeta target y ejecutar `java -jar target/calculadora-0.0.1-SNAPSHOT.jar`
  Este comando inicia la aplicación Spring Boot y la hace disponible en http://localhost:9090/.

## Ejemplos de llamadas de la API 
- Suma de dos números: http://localhost:9090/api/calculo?operando=2.3&operando=2.5&operacion=suma
Resultado 4.8 

![imagen](https://user-images.githubusercontent.com/115168729/233455368-cf835e51-31d2-41b2-aa82-82f2994f0245.png)
-  Suma de tres números: http://localhost:9090/api/calculo?operando=2.3&operando=2.5&operando=1&operacion=suma
Resultado 5.8 

![imagen](https://user-images.githubusercontent.com/115168729/233455590-3a3bc0f1-7805-4340-ac6e-220acb49dcda.png)

- Resta de dos números: http://localhost:9090/api/calculo?operando=2.5&operando=1.5&operacion=resta
Resultado 1 

![imagen](https://user-images.githubusercontent.com/115168729/233456027-525d9164-04c9-4e7c-bb6c-3d853aa8a95c.png)

- Resta de tres números: http://localhost:9090/api/calculo?operando=2.5&operando=1.5&operando=0.5&operacion=resta
Resultado 0.5

![imagen](https://user-images.githubusercontent.com/115168729/233456223-18fe081e-b89a-44f5-9c15-8f9e80dc4972.png)

- Operación inválida: http://localhost:9090/api/calculo?operando=4&operando=2&operacion=division
Resultado Error

![imagen](https://user-images.githubusercontent.com/115168729/233456609-7bd809ac-9855-458b-9658-b0998cbe634c.png)

- Operandos vacíos: http://localhost:9090/api/calculo?operando=&operacion=suma
Resultado Error

![imagen](https://user-images.githubusercontent.com/115168729/233456773-63799616-e533-449c-8b35-ebae477a0900.png)
