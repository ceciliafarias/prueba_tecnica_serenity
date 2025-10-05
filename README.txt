================================================================================
    PROYECTO DE AUTOMATIZACIÓN - SERENITY BDD SCREENPLAY
    Pruebas E2E de Proceso de Compra en E-Commerce
================================================================================

DESCRIPCIÓN DEL PROYECTO
================================================================================

Este proyecto implementa una suite de pruebas automatizadas End-to-End (E2E) 
para validar el flujo completo de compra en un sitio web de comercio electrónico.
Utiliza el patrón Screenplay de Serenity BDD para crear pruebas mantenibles, 
escalables y fáciles de leer.

El flujo de prueba automatizado incluye:
  • Navegación a la página de inicio
  • Selección y adición de productos al carrito
  • Visualización del carrito de compras
  • Proceso de checkout
  • Llenado de formulario de facturación
  • Validación de compra exitosa


TECNOLOGÍAS Y FRAMEWORKS UTILIZADOS
================================================================================

• Serenity BDD (v4.2.9)
  Framework de automatización que proporciona reportes detallados y 
  documentación viva de las pruebas.

• Screenplay Pattern
  Patrón de diseño que modela las pruebas desde la perspectiva del usuario,
  mejorando la legibilidad y mantenibilidad del código.

• Cucumber (v7.20.1)
  Framework BDD para escribir pruebas en lenguaje natural (Gherkin).

• Selenium WebDriver
  Herramienta para automatizar la interacción con navegadores web.

• Java 17
  Lenguaje de programación utilizado para el desarrollo.

• Maven
  Herramienta de gestión de dependencias y construcción del proyecto.

• JUnit Platform (v1.11.3)
  Framework para ejecutar las pruebas.

• JavaFaker (v1.0.2)
  Librería para generar datos de prueba aleatorios.

• Lombok (v1.18.42)
  Librería para reducir código boilerplate en Java.


REQUISITOS PREVIOS
================================================================================

Para ejecutar este proyecto, necesitas tener instalado:

1. Java Development Kit (JDK) 17 o superior
   - Verificar instalación: java -version
   - Descargar desde: https://adoptium.net/

2. Apache Maven 3.6 o superior
   - Verificar instalación: mvn -version
   - Descargar desde: https://maven.apache.org/download.cgi

3. Navegador Web (Chrome, Firefox, Edge, etc.)
   - El driver del navegador se descarga automáticamente vía WebDriverManager

4. IDE recomendado (opcional pero recomendado)
   - IntelliJ IDEA
   - Eclipse
   - Visual Studio Code con extensiones de Java


ESTRUCTURA DEL PROYECTO
================================================================================

Prueba-tecnica-serenity/
│
├── src/
│   ├── main/java/starter/
│   │   ├── abilities/
│   │   │   └── NavigateTo.java              # Habilidad para navegar a URLs
│   │   │
│   │   ├── questions/                        # Preguntas que el actor hace al sistema
│   │   │   ├── HomeQuestions.java            # Validaciones de la página de inicio
│   │   │   ├── ProductQuestions.java         # Validaciones de productos
│   │   │   └── ShoppingCartQuestions.java    # Validaciones del carrito
│   │   │
│   │   ├── tasks/                            # Tareas que el actor puede realizar
│   │   │   ├── Home.java                     # Tareas en la página de inicio
│   │   │   ├── Product.java                  # Tareas con productos
│   │   │   └── ShoppingCart.java             # Tareas del carrito de compras
│   │   │
│   │   └── userInterfaces/                   # Elementos de UI (Page Objects)
│   │       ├── HomePage.java                 # Elementos de la página de inicio
│   │       ├── ProductPage.java              # Elementos de la página de producto
│   │       └── ShoppingCartPage.java         # Elementos del carrito
│   │
│   └── test/
│       ├── java/
│       │   ├── CucumberTestSuite.java        # Configuración de la suite de pruebas
│       │   │
│       │   ├── parameters/
│       │   │   └── ActorParameterType.java   # Tipos de parámetros personalizados
│       │   │
│       │   ├── stepDefinitions/
│       │   │   └── PurchaseSteps.java        # Definición de pasos Cucumber
│       │   │
│       │   └── utils/
│       │       ├── GenerateData.java         # Generador de datos de prueba
│       │       └── UserData.java             # Modelo de datos de usuario
│       │
│       └── resources/
│           ├── features/
│           │   └── Purchase.feature          # Escenarios de prueba en Gherkin
│           │
│           └── serenity.conf                 # Configuración de Serenity
│
├── pom.xml                                   # Configuración de Maven
└── README.txt                                # Este archivo


ARQUITECTURA SCREENPLAY
================================================================================

El proyecto sigue el patrón Screenplay que organiza el código en:

1. ACTORS (Actores)
   Representan a los usuarios que interactúan con el sistema.
   Ejemplo: "Alan" es el actor que realiza las compras.

2. ABILITIES (Habilidades)
   Capacidades que tiene un actor para interactuar con el sistema.
   Ejemplo: NavigateTo - habilidad para navegar a páginas web.

3. TASKS (Tareas)
   Acciones de alto nivel que un actor puede realizar.
   Ejemplo: Home.selectProduct() - seleccionar un producto.

4. INTERACTIONS (Interacciones)
   Acciones de bajo nivel con elementos de UI.
   Ejemplo: Click.on(), Enter.theValue()

5. QUESTIONS (Preguntas)
   Consultas sobre el estado del sistema.
   Ejemplo: HomeQuestions.isOnHomePage()

6. USER INTERFACES (Interfaces de Usuario)
   Definición de elementos de la página (Page Objects).
   Ejemplo: HomePage.PRODUCT_LINK


CONFIGURACIÓN DEL PROYECTO
================================================================================

Archivo: pom.xml
----------------
Versiones principales:
  - Serenity BDD: 4.2.9
  - Cucumber: 7.20.1
  - JUnit Platform: 1.11.3
  - Java: 17


CÓMO EJECUTAR LAS PRUEBAS
================================================================================

1. INSTALAR DEPENDENCIAS
   mvn clean install -DskipTests

2. EJECUTAR TODAS LAS PRUEBAS
   mvn clean verify

3. EJECUTAR PRUEBAS CON UN TAG ESPECÍFICO
   mvn clean verify -Dcucumber.filter.tags="@purchase"

4. EJECUTAR UN FEATURE ESPECÍFICO
   mvn clean verify -Dcucumber.features=src/test/resources/features/Purchase.feature

5. EJECUTAR EN MODO HEADLESS (sin interfaz gráfica)
   mvn clean verify -Dheadless.mode=true

6. EJECUTAR CON UN NAVEGADOR ESPECÍFICO
   mvn clean verify -Dwebdriver.driver=chrome
   mvn clean verify -Dwebdriver.driver=firefox
   mvn clean verify -Dwebdriver.driver=edge


GENERACIÓN DE REPORTES
================================================================================

Después de ejecutar las pruebas, Serenity genera reportes automáticamente:

1. UBICACIÓN DE REPORTES
   target/site/serenity/index.html

2. ABRIR REPORTE
   • En Windows: start target/site/serenity/index.html
   • En Mac/Linux: open target/site/serenity/index.html
   • Manualmente: Navegar a la carpeta y abrir index.html en un navegador

3. GENERAR REPORTE MANUALMENTE
   mvn serenity:aggregate

4. TIPOS DE REPORTES INCLUIDOS
   • Resumen ejecutivo de pruebas
   • Resultados por feature y escenario
   • Capturas de pantalla de cada paso
   • Logs detallados de ejecución
   • Métricas y estadísticas


ESCENARIOS DE PRUEBA IMPLEMENTADOS
================================================================================

Feature: Purchase
-----------------

Scenario Outline: Purchase product
  Given Alan open the the browser in the shopping page
  And is in home page
  When select and add to cart "<products>" item
  And go to shopping cart
  And place order
  And fill billing detail form
  Then the purchase must be successful

  Examples:
    | products                                         |
    | Samsung galaxy s6, Nokia lumia 1520, MacBook Pro |


DATOS DE PRUEBA
================================================================================

El proyecto utiliza JavaFaker para generar datos aleatorios:
  • Nombres de usuario
  • Países
  • Ciudades
  • Números de tarjeta de crédito
  • Fecha


SOLUCIÓN DE PROBLEMAS
================================================================================

1. ERROR: "Maven not found"
   Solución: Instalar Maven y agregarlo al PATH del sistema

2. ERROR: "Java version mismatch"
   Solución: Verificar que JAVA_HOME apunte a JDK 17 o superior

3. ERROR: "WebDriver not found"
   Solución: El proyecto usa WebDriverManager que descarga drivers 
            automáticamente. Verificar conexión a internet.

4. ERROR: "Tests not running"
   Solución: Ejecutar mvn clean install -DskipTests primero

5. ERROR: "Browser not opening"
   Solución: Verificar que el navegador esté instalado o usar otro:
            mvn clean verify -Dwebdriver.driver=firefox


MEJORES PRÁCTICAS IMPLEMENTADAS
================================================================================

✓ Patrón Screenplay para mejor legibilidad y mantenibilidad
✓ Separación de responsabilidades (Tasks, Questions, UI)
✓ Uso de Page Objects para elementos de UI
✓ Generación de datos de prueba aleatorios
✓ Esperas implícitas y explícitas manejadas por Serenity
✓ Capturas de pantalla automáticas en cada paso
✓ Reportes detallados con documentación viva
✓ Configuración centralizada en archivos properties
✓ Uso de tags para organizar y filtrar pruebas


COMANDOS ÚTILES DE MAVEN
================================================================================

mvn clean                    # Limpiar archivos compilados
mvn compile                  # Compilar código fuente
mvn test                     # Ejecutar pruebas unitarias
mvn verify                   # Ejecutar pruebas de integración
mvn serenity:aggregate       # Generar reportes Serenity
mvn clean verify -X          # Ejecutar con logs detallados (debug)
mvn dependency:tree          # Ver árbol de dependencias
mvn clean install            # Instalar en repositorio local

================================================================================
                            FIN DEL DOCUMENTO
================================================================================
