# MAVEN
## Oefening 1: Installeer Maven

  - Zie instructies op pagina 6 van de cursus
  - Configureer JAVA_HOME
  - Configureer MAVEN_HOME
  - Controleer of Maven succesvol geinstalleerd is: mvn --version

## Oefening 2: Maak een Maven project aan

  - mvn archetype:create -DgroupId=be.pxl -DartifactId=FirstApplication
  - Controleer of er een folder <FirstApplication> aangemaakt is
  - Controleer of er in die folder een pom.xml bestaat
  - Open de pom.xml en kijk of je begrijpt wat er staat
  - Controleer of er in die folder een src folder is aangemaakt
  - Bekijk alle folders, zodat je een idee krijgt hoe de structuur van een standaard maven project er uit ziet

## Oefening 3: Voeg een externe dependency toe aan het project  
  Voeg een dependency toe op het Spark framework (http://sparkjava.com/documentation.html), dit doe je in het <dependencies> blok in je pom.xml

```xml
<dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.3</version>
</dependency>
```

## Oefening 4: Maak een java class HelloWorld.java aan(zie http://sparkjava.com/documentation.html) in package be.pxl

  Maak een class aan die een REST endpoint beschikbaar stelt op http://localhost:4567/hello

  - Navigeer naar src/main/java
  - Navigeer verder naar de package be/pxl
  - Maak een class HelloWorld.java

```java
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
```
  - Compileer met maven: mvn clean install
  - Start de class HelloWorld
  - Open je browser en ga naar http://localhost:4567/hello

## Oefening 5: Maak een uitvoerbaar jar bestand

  - zie oefening ExecutableJar
  - bestudeer de maven-jar-plugin en experimenteer met de mainClass
  - bestudeer de maven-dependency-plugin en begrijp wat ${project.build.directory} betekent.
  - Voer mvn package uit
  - Voer java -jar <NaamVanDeJarInJeTargetFolder>.jar uit
  - Navigeer naar http://localhost:4567/hello
  - Stop het java programma
  - Pas de <name> aan
  - Voeg de commando's opnieuw uit. Wat is er veranderd?

## Extra oefening: properties

Zie opdracht 8 p.30

## Extra oefening: connecteren met een bedrijfs-repository

Zie cursus p. 27