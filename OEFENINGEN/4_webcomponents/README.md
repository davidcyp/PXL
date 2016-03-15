# WEB COMPONENTEN

## Voorbereiding

Download java EE 7 op http://www.oracle.com/technetwork/java/javaee/downloads/index.html
Download en installeer Tomcat https://tomcat.apache.org/download-90.cgi en volg de instructies in de cursus op p 76

## Oefening 1 : Maak de web-app structuur aan via Maven en maak een web-app met 1 statische index pagina
- Maak een web-app aan met behulp van Maven (of via Eclipse, zoals in de cursus op pagina 83 beschreven staat)
- Voeg aan je pom.xml de extra configuratie toe zoals beschreven op p.85 en p.86 (deze zorgt ervoor dat je project java 8 gebruikt, en dat je Tomcat server kan opgestart worden.
- Voeg een pagina index.html toe in de map src/main/webapp
- Voeg de map WEB-INF en daarin het bestand web.xml toe in de map src/main/webapp (voor inhoud, zie cursus p. 86)
- voer het commando mvn package cargo:deploy uit
- Surf naar http://localhost:8080/<naam van je maven artifact>

## Extra oefening - herhaling Maven, JDBC en DAO + leer het gebruik van POST en GET REST (adhv Spark framework)

Soms wil je gewoon snel een web-applicatie opzetten zonder dat je die wil deployen op een application server. Daarvoor zijn lightweight-frameworks ontstaan zoals Spark. Herinner je je nog ons "Hello World" voorbeeld uit les 1, waar je met je browser naar een url moest surfen? Wel, eigenlijk is dat een voorbeeld hiervan. Deze applicatie verbergt de complexiteit van het deployen(in de appserver) en configureren(in de web.xml) voor de programmeur.

- Maak een maven project aan
- Kopieer in je Maven pom de settings voor Java 8 (zie oefening 1, of poms uit les 1 en les 2)
- Voeg de dependency op het Spark framework toe (zie les 1)
- Voeg de dependency op je database driver toe (zie les 3)
- Herbruik de tabel STUDENT met velden ID, NAAM, STUDENTENCLUB, GEBOORTEDATUM van les 3 oefening 8
- Analyseer de code van les 1, en maak naar analogie een class aan met het Spark framework die voldoet aan de REST principes, nl:
- gebruik een GET operatie op <server/localhost>:<poort>/student om een lijst van studenten te tonen in je browser
- gebruik een POST operatie op <server/localhost>:<poort>/student om een student aan je database toe te voegen
- gebruik een GET operatie op <server/localhost>:<poort>/student/<ID> om de gegevens van 1 student op te halen
- Het staat je vrij een dao of statements te gebruiken