# Herhalings-oefening (Maven, Unit testing, JDBC, DAO, Web components, Servlets)
---
Tijdens deze oefening gaan we 2 applicaties aanmaken die samenwerken met elkaar.

Het te schrijven programma betreft een boekings-applicatie voor deejays, en zal bestaan uit volgende entiteiten:
```
DEEJAY (id, naam, genre, aantal_boekingen)
BOEKING(id, datum, stad, deejay_id)
```

## Applicatie 1: Back-end applicatie
- Maak via maven een 'gewoon' project met de naam met groupId 'be.pxl' en artifactId 'DeejayBackend' aan.
- Maak de tabellen DEEJAY en BOEKING aan in een database naar keuze
- Maak de entiteiten Deejay en Boeking aan (gewone javabeans)
- Maak DAO's aan voor de entiteiten Deejay en Boeking
- Zorg ervoor dat je constructor van je DAO's de volgende parameters meekrijgt: driver, url, username, password (later gaan we die initialiseren via een servlet)
- De DAO voor Deejay bevat op z'n minst methodes voor:
    - ophalen lijst van alle deejays
    - toevoegen van een deejay
-    verwijderen van een deejay
- De DAO voor boeking bevat op z'n minst methodes voor:
    - ophalen lijst van alle boekingen, gesorteerd per datum
    - toevoegen van een boeking (zie °1 voor méér uitleg)
- Bouw de applicatie(jar file) met Maven, en push ze naar je lokale repository (zie tips onderaan)
- Controleer in je lokale Maven repository of de jar file effectief toegevoegd is (de repository is terug te vinden in de (verborgen) folder .m2/repository/be/pxl/DeejayBackend . De .m2 folder bevindt zich (meestal) onder je User folder.

- EXTRA: Testen schrijven is niét verboden! (maar dao's zijn niet dadelijk objecten die makkelijk testbaar zijn met hetgeen we tot nu toe geleerd hebben) 

(°1) Deze methode moet volgende functionaliteit bevatten:
- Naast het toevoegen van een boeking, moet je in de tabel DEEJAY ook het veld aantal_boekingen met 1 ophogen, gebaseerd op het BOEKING.deejay_id veld. Je werkt dus op 2 tabellen!
- Verifieer in je DAO of de deejay die dag reeds geboekt is. Een deejay kan maar 1 x per dag geboekt worden. Indien de deejay reeds geboekt is, throw je een DeejayNotAvailableException.
- Gebruik transacties (en doe aan rollback als bvb de DeejayNotAvailableException gethrowed werd.


## Applicatie 2: Web-applicatie
- - Maak via maven een 'web' project met de naam met groupId 'be.pxl' en artifactId 'boekingsapplicatie' aan.
- Schrijf 2 servlets, eentje voor het beheer van de deejays(DeejayServlet), en ééntje voor de boekingen(BoekingServlet)
- voeg in je Maven pom.xml file een dependency toe op de jar die je hebt aangemaakt in Applicatie 1. 
- Voeg aan het DeejayServlet de DeejayDao toe
- Voeg aan het BoekingServlet de BoekingDao toe
- Zorg dat beide servlets configureerbaar zijn via _initParams_, en configureer voor beide servlets de parameters driver, url, username, password zodanig dat deze bij initialisatie doorgegeven kunnen worden aan de constructor van de DAO.
- Voorzie op het DeejayServlet minstens methodes voor:
    - het ophalen van een lijst van deejays op path _/deejays_
    - het toevoegen van een deejay (ofwel kan je hier op de GET het formulier naar de browser sturen, en bij POST het ingevulde formulier verwerken; een andere opties is om een webpagina die het invulformulier bevat, mee te deployen, en enkel een POST methode te implementeren die het ingevulde formulier verwerkt)
- Voorzie op het BoekingServlet minstens methodes voor:
    - het ophalen van een lijst van boekingen op path _/boekingen_
    - het toevoegen van een boeking
    - OPGELET: Het formulier om een boeking te tonen moet ook een lijstje(combobox?) tonen waaruit je de dj kan kiezen die je wil boeken!
- Deploy je web-applicatie en surf met de browser naar je servlet via 'http://localhost:8080/boekingsapplicatie/boekingen'
---
## Tips
### Aanmaken Maven project
```
mvn archetype:create -DgroupId=be.pxl -DartifactId=DeejayBackEnd 
of 
mvn archetype:generate -DgroupId=be.pxl -DartifactId=DeejayBackEnd
```
### Aanmaken Maven 'web' project
```
mvn archetype:create -DgroupId=be.pxl -DartifactId=DeejayFrontend -DarchetypeArtifactId=maven-archetype-webapp
```
Bovenstaand commando maakt de folder-structuur aan voor een web-applicatie. Er moeten echter nog manueel folders bij aangemaakt worden als je bvb. servlets(java code dus) wil toevoegen aan je web-applicatie. Zo moet je oa de folder _src/main/java_ toevoegen in je Maven project(anders kan je nergens je source code voor je servlets kwijt)
Meer info over de folderstructuur kan je hier(https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) vinden.

### Jar aanmaken en installeren in de lokale repository 
```
mvn package install
```
