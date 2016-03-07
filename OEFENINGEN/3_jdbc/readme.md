# JDBC

## Voorbereiding: opzetten database
### Via Docker(voor diegenen die ook offline een database willen, iets complexer)
- zie topic 'Docker stuff' op https://github.com/sch3lp/entmob_examples/

### Online via DB4Free.net(voor diegenen die enkel online een database willen, dit is het makkelijkste)
- surf naar https://www.db4free.net/signup.php en vul het formulier in(onthoud deze gegevens of noteer ze ergens!)
- Klik op de confirmatie-email die je via email gekregen hebt
- Via de website heb je toegang tot een phpadmin(zoals in een LAMP/MAMP stack)

### Of als je echt lui bent (niet aanbevolen!)
- connecteren naar noelvaes.eu (zie cursus p. 54)
### Voorbereiding
Voorbereiding (enkel uit te voeren indien je jdbc in een bestaand project wenst te gebruiken. Voor de oefeningen is dat niét nodig).
#### driver downloaden(postgres - docker)
- Voeg een dependency toe in je maven pom.xml die verwijst naar de postgres driver, de dependency is te vinden op http://mvnrepository.com/artifact/postgresql/postgresql/9.1-901-1.jdbc4

#### driver downloaden(mysql - db4free.net)
- Voeg in je project in de maven pom.xml een dependency toe aan je <dependencies>, die verwijst naar de mysql driver. Deze dependency kan je vinden op http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.38

Of als je het 'the hard way' wil doen, dan kan je ook:
- Download de driver op https://dev.mysql.com/downloads/connector/j/
- Klik op de driver zip of tar
- Klik op "No thanks, just start the download" (dat spaart je een registratie-stap uit)
- Open de zip/tar file, en kopieer de mysql-connector-java-5.1.38-bin.jar naar een folder, bvb naar <USERNAME>/drivers. Dit maakt het je makkelijker om hem later terug te vinden.

## Oefening 1: Maak een nieuw project aan met Maven, voeg de jdbc driver toe, en connecteer naar een bestaande database
- mvn archetype:generate -DgroupId=be.pxl -DartifactId=JdbcOefening1
- Voeg een dependency toe op de jdbc driver voor de door jouw gekozen database (ik gok er op dat dit voor 90% van de klas de mysql driver zal zijn). Zie bij 'voorbereiding' hierboven hoe je die dependency aan Maven kan toevoegen.
- Voeg een dependency op junit, mockito en toe (zie Addendum onderaan)
- kopieer de class test/java/be.pxl.jdbc/Oefening1Test.java uit project jdbc_db4free naar je eigen project
- Maak een eigen class onder main/java in package be.pxl.jdbc en met naam Oefening1.java
- Maak hierin een connectie naar de database db4free.net/davidcyp met username davidcyp en paswoord pxlpxl, en voer op die database volgende query uit met executeUpdate: INSERT INTO leerlingen (naam) VALUES ('<UWNAAMHIER>')
- Voer de test Oefening1Test uit, en implementeer Oefening1.java als dusdanig, dat de test slaagt.

## Oefening 2: gebruik van executeQuery
- Werk verder op het project dat je aangemaakt hebt in oefening 1.
- kopieer de class test/java/be.pxl.jdbc/Oefening2Test.java uit project jdbc_db4free naar je eigen project
- - Maak een eigen class onder main/java in package be.pxl.jdbc en met naam Oefening2.java
- Maak hierin een methode haalAlleTechnoDeejaysOp die gebruik maakt van executeQUery om volgende query uit te voeren: SELECT naam FROM deejays WHERE genre LIKE 'techno'
- Gebruik ResultSetUtil.mapStringFieldtToCollection(resultSet, "naam") (je kan deze class ook kopiëren uit het jdbc_db4free project)om de naam van alle dj's uit de resultset te halen en in een collection te stoppen (tenzij je liever zelf over de resultset itereert)
- (en zorg ervoor dat Oefening2Test slaagt)

## Oefening 3: Zoek het genre van "dj jos" 
- Maak een query die in de tabel 'deejays' gaat opzoeken welk het genre van 'dj jos' is (je kan hiervoor beginnen met de boilerplate code van de vorige oefeningen). Verder staat het je vrij te kiezen hoe dit te implementeren

## Oefening 4: Voeg jezelf als dj toe
- Maak een class waarmee je jezelf kan toevoegen aan de tabel 'deejay'. Kies je eigen dj-naam (kolom: naam) en je favoriete muziek-genre (kolom:genre).
- Voeg jezelf toe aan de tabel met behulp van executeUpdate, en verifieer het resultaat (dit zou '1' moeten zijn)

## Oefening 5: Voeg 3 deejays met hun genre toe via een prepared statement
- Maak een class waarmee je een collection van deejays kan toevoegen aan de tabel 'deejay'
- Maak hiervoor gebruik van een prepared statement waarin je dynamisch dj naam en genre invult

## Oefening 6: Transacties
- Maak op je eigen database een tabel 'bankrekening' aan
- Voeg aan de tabel 'rekening' 2 velden toe (rekeningnummer, saldo)
- Voeg 2 records toe: [rekeningnummer:1, saldo: 1000],[rekeningnummer:2, saldo:200] (via SQL, phpmyadmin,..of via een statement mag ook natuurlijk)
- Schrijf een class die een connectie maakt naar jouw database.
- Voeg volgende code toe aan je class:
```java
statement.executeUpdate("UPDATE bankrekening SET saldo = 800 WHERE rekeningnummer = 1");
if(true) throw new Exception("Oei, de data is nog niet gecommit en er loopt iets fout");
statement2.executeUpdate("UPDATE bankrekening SET saldo = 400 WHERE rekeningnummer = 2");
```
- Voer bovenstaande code uit en inspecteer de database. Wat is het saldo van rekeningnummer 1 en wat is het saldo van rekeningnummer 2?
- Pas in de database het saldo van rekening 1 terug aan naar '1000'
- Voeg nu transacties toe rond deze 2 statements, en voer de code opnieuw uit.
- Wat is nu het saldo van rekeningnummer 1?

## Oefening 7
- Maak een DAO die de gegevens van de 'deejays' tabel gaat uitlezen. De deejays tabel bevat 2 text(String) velden, nl. 'naam' en 'genre'. 
- Voeg 2 methodes toe aan de dao: getByName(String name) en update(Deejay deejay)

## Extra oefening
- Maak een class die een foto uitleest van de harde schijf, en deze in de database stopt(BLOB).

## Extra oefening
- Maak een class die een connectie maakt met de tabel 'deejays' en voor elke dj in de tabel de kolommen 'naam' en 'genre' naar de console schrijft

## Addendum
### Dependencies voor junit, mockito en assertj
```xml
 <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>1.10.19</version>
</dependency>
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.3.0</version>
</dependency>
```