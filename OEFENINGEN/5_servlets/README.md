# SERVLETS
## Oefening 1 : Maak je eigen 'hello world' servlet
- Maak via Maven een web-app 'applicatie1' aan
- Extend de class HttpServlet en implementeer de doGet methode (zie cursus p.93 voor de implementatie)
- Configureer je servlet via annotaties op het pad '/hallo'
- Deploy je web-applicatie en surf met de browser naar je servlet via 'http://localhost:8080/applicatie1/hallo'

## Oefening 2: Maak de servlet van oefening1 beschikbaar op verschillende paden
- Pas oefening 1 als dusdanig aan dat je de servlet kan aanspreken via de URLs 'http://localhost:8080/applicatie1/hallo' en 'http://localhost:8080/applicatie1/goedendag'

## Oefening 3: Maak een servlet met initialisatie-parameters
- Maak een servlet GreetingServlet.java aan, het welke je kan bereiken op '/greeting'
- Configureer de servlet met je eigen greeting(bvb. 'Welkom!' en deploy
- Surf naar je servlet op 'http://localhost:8080/applicatie1/greeting'
- Pas je initialisatie-parameter aan naar 'Hallo!' en deploy
- Surf opnieuw naar je servlet op 'http://localhost:8080/applicatie1/greeting'

## Oefening 4: Servlet met request parameter
- Pas je GreetingServlet aan, zodat je een naam kan meegeven aan je servlet
- Vraag aan de 'request' van je doGet methode een parameter op met de naam 'naam'
- Implementeer het servlet zodanig dat ie als response 'Goedemiddag <NAAM UIT DE PARAMETER>' naar je browser terugstuurt. Het woord "Goedemiddag" komt uit je initialisatie-parameter, de <NAAM UIT DE PARAMETER> moet je opvragen aan je request,en geef je mee van uit je browser (zie url voorbeeld in volgende puntje)
- Surf naar het servlet en geef het een parameter 'naam' mee, bvb. 'http://localhost:8080/applicatie1/sayhi?naam=David'

## Oefening 5: Servlet dat 2 getallen optelt (via GET)
- Maak een TelOpServlet.java aan, dat bereikbaar is via een GET request op url 'http://localhost:8080/applicatie1/telop?number1=12&number2=13'

## Oefening 6: Servlet dat 2 getallen optelt (via POST)
- Maak een TelOpServlet.java aan, dat bereikbaar is via een POST request op url 'http://localhost:8080/applicatie1/telop'
- Maak een HTML formulier aan, zie de cursus p.104, pas de 'action' aan naar 'telop' (ipv 'Addition)

## Oefening 7: Uitgebreide oefening op doPost, geintegreerd met DAOs
Maak opdracht 4 uit de cursus, p. 106
