## Getting Started
Con las siguientes instrucciones logrará el correcto
 funcionamiento del proyecto en su máquina local para fines de desarrollo y prueba.
 
### Prerequisites
Lo que necesita para instalar el software:

* Java SDK 8.x or higher
* Maven 3.x or higher

### Building & Testing
Realizar la ejecución de los siguientes comandos:

```
mvn clean            # Clean project
mvn test             # Build & run tests (no integration test)
mvn verify           # Build, run integration test and run static code validation

# Use this for tag execution
Regresión de todos los CP API A0719
clean verify -Dcucumber.filter.tags=@RegresionA0719

Regresión de todos los CP Servicios IFX
clean verify -Dcucumber.filter.tags=@Regresion(Código de servicio)

Ejecutar caso en especifico de API A0719
clean verify -Dcucumber.filter.tags=@cp01

Ejecutar caso en especifico de Servicios IFX
clean verify -Dcucumber.filter.tags=@caso1Api(Código de servicio)

```

## Built With
El proyecto usa las siguientes librerias para el Build y Test:

* [Maven](https://maven.apache.org/) - Gestor de dependencias
* [RestAssured](https://github.com/rest-assured/rest-assured/wiki/Usage) - Test API REST
* [SerenityBDD](http://www.thucydides.info/docs/serenity/#first-steps) - Librería SerenityBDD 
* [PMD](https://pmd.github.io/latest/pmd_rules_java.html) - Analizador de código estático
* [Spotbugs](https://find-sec-bugs.github.io/bugs.htm) - Analizador de seguridad en código
* [Poi](https://mvnrepository.com/artifact/org.apache.poi/poi) - Lectura y Escritura en Archivo Excel
* [JSON Object]
* [Filters]

## Authors
**EVERIS PERU-NTT DATA**  
GISELL QUISPE
 


## License

Copyright (C) Everis Perú - All Rights Reserved - Proprietary and confidential
