## Belangrijk: vooraleer je begint
(!) Lees eerst de opdracht door van de 1e tot de laatste zin.

(!) voeg volgende lijn aan persistence.xml toe als je je database tabellen wil laten genereren :             <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>

voeg ook volgende lijn toe:
            <property name="javax.persistence.schema-generation.drop-script-source" value="META-INF/disable_constraints.sql"/>

en voeg een file META-INF/disable_constraints.sql toe met volgende inhoud:

```
SET FOREIGN_KEY_CHECKS = 0;
```

(!) Zie onderaan voor een Main class waarmee je snel kan controleren of je persistence unit correct geconfigureerd is en waarmee je - indien je bovenstaande lijn aan persistence.xml toegevoegd hebt - je ook je schema kan aanmaken.




##### Maven dependencies
Kopieer de aangeleverde libraries naar je maven repository folder. Deze kan je standaard terugvinden op ~/.m2/repository. Je kan hem desgewenst ook herconfigureren in de Maven settings.xml, die terug te vinden is op MAVEN_HOME/conf/settings.xml.

### Toe te voegen aan elk Maven project (java 8 ondersteuning)
```
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
en 
```
  <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.testSource>1.8</maven.compiler.testSource>
        <maven.compiler.testTarget>1.8</maven.compiler.testTarget>
    </properties>
```
### Zorg dat je via de Maven CLI:
- ... een gewoon Maven project kan aanmaken
- ... een Maven web-project kan aanmaken

### Maven web-project met ook nog gewone classes
Opgelet, een Maven web-project creëert niet alle folders. Indien je dus zelf nog classes wil toevoegen(of bvb. een servlet wil schrijven) in je Maven web-project, dan moet je nog enkele extra folders manueel aan je project toevoegen:
src/main/java

In je IDE markeer je die best ook nog als 'sources' folder.

### Controleer je IDE
Controleer in je IDE of al je settings correct ingesteld staan om met Java 8 te werken. Zo verlies je geen waardevolle tijd.

### Lokale database
- Zorg dat je een JDBC driver voor je lokale database ter beschikking hebt(m.a.w. dat die in je Maven repository zit)
- Zorg dat je je lokale database kan opstarten
- Zorg dat je een connectie kan maken naar je lokale database via de JDBC driver
- Zorg dat je tabellen kan creëren/droppen op je lokale database (eventueel via een tool zoals phpmyadmin of puur via DDL)

### Controleer of Apache Tomcat correct geinstalleerd is
- Zorg dat je Tomcat kan opstarten / stoppen
- Zorg dat geen andere applicatie de Tomcat poort blokkeert
- Indien een andere applicatie de Tomcat poort blokkeert, zorg dan dat je weet hoe je deze kan uitzetten
- Zorg dat je weet hoe je een war-bestand kan deployen op Tomcat

### Zet je internet(wifi) uit!!!!
Tijdens de examens zal er geen internet beschikbaar zijn. Daarom is het uitermate belangrijk dat we op voorhand al controleren of we al onze projecten kunnen aanmaken zonder te rekenen op internet-verbinding. Daarom kopieerden we in stap 1 ook al alle libraries in onze lokale Maven repository.

(!) Deze oefening moet je dus maken met alle internet-verbindingen uitgezet. 

### Tips!
- In tegenstelling tot in normale code, zal je eventueel een Class.forName(..) moeten gebruiken als je een database-connectie wil aanmaken van uit je servlet code.
- Gebruik packages om een onderscheid te maken tussen je layers.

## HERHALINGSOEFENING als voorbereiding op de EXAMENS
Tijdens deze oefening gaan we een Maven web-applicatie maken waarmee we kunnen stemmen op YouTube en Vimeo videos. 
Deze oefening focust eerst op de opbouw van de CRUD schermen. Tijdens de volgende 2 weken gaan we de applicatie verder uitbouwen en eventueel refactoren. De database tabellen gaan we genereren van uit de domein-objecten.

### Domein-model

Het initiële domein-model bestaat uit volgende classes:

- VideoSource.java 
    - enum; values YOUTUBE, VIMEO

- Category.java
    - 2 constructors: (name) (name, ageRestriction, minimumAge)
    - name::String
    - ageRestriction::boolean
    - minimumAge::int
    
- Video.java
    - source::VideoSource
    - name::String
    - url::String
    - category::Category

- Voter.java
    - name::String
    - dateOfBirth::Date
    
### Gelaagde architectuur
Implementeer de applicatie aan de hand van een gelaagde architectuur. Hou er rekening mee dat elke laag zijn verantwoordelijkheden heeft, en enkel kan communiceren met de onderliggende laag.
De lagen die we in onze applicatie hebben zijn:
- View (bevat de servlets en jsps)
- Services (wordt aangesproken door view laag, bevat mogelijks business logic en delegeert naar het domein via de DAO's)
- Domain(bevat de domein objecten en de DAO's)

We spreken af van niet rechtstreeks onze domeinobjecten te exposen in de view. Daarom doen we de vertaalslag van domein-object naar een view-specifiek object in onze services laag. Daar 'plukken' we de properties die we aan onze view willen doorgeven uit ons domein-object (of set van domein-objecten) en stoppen we die in een javabean(pojo) die we aan onze view laag meegeven. (nota: deze javabeans kunnen we bvb gaan gebruiken in onze JSP's)
### Implementatie
- Maak een Maven web-applicatie aan. Vergeet de tips van bovenaan deze pagina toe te passen!!!
- Implementeer de domein-entiteiten VideoSource, Category, Video, Voter
- Annoteer de domein-entiteiten met de nodige annotaties
- Maak een persistence unit aan voor je domein met de naam "videos"
- Configureer je ORM als dusdanig dat je de database tabellen kan creëren van uit de java toepassing
- Schrijf een kleine java Main class die een entityManager aanmaakt voor je persistence-unit "videos". Deze laat je toe om de tabellen te genereren in de database zonder dat we de nog niet afgewerkte web-applicatie moeten deployen op tomcat.
- Maak een DAO aan die gebruikt maakt van JPA(!!) om de domein-objecten op te halen voor alle domein classes. Encapsuleer de connectie naar je database in deze DAOs. Je kan de DAO code uitbreiden naargelang je van uit de view-layer data moet ophalen. (Lees daarom zeker nu dadelijk door welke services je moet aanmaken), naamgeving: <domein-object<type>Dao.java bvb. VideoJpaDao of VideoJdbcDao.
- EXTRA: Maak voor Voter.java ook een JDBC DAO aan
- Maak de volgende services aan met volgende methodes:
    - VideoService(add, getAll, update, getById)
    - CategoryService(add, getAll)
    - VoterService(add, getAll)
- Maak volgende servlets aan(beschrijving volgt):
    - VideoServlet
        - beschikbaar op URI /video
        - GET naar /video toont een leeg invulformulier (JSP) waarop je een nieuwe video kan toevoegen
        - POST naar /video voegt een video toe (service#add of service#update, afhankelijk of de video al een id heeft of niet)
        - GET naar /video/all haalt alle videos op (gebruik eventueel JSTL tag <c:forEach> om alle videos te tonen op je JSP
        - GET naar /video?id=<id> haalt de video met <id> op
    - AdminServlet
        - beschikbaar op URI /admin
        - GET naar /admin/category toont een invulformulier(JSP of HTML) waarmee je een nieuwe category kan toevoegen
        - POST naar /admin/category voegt een category toe (service#add)
        - GET naar /admin/voter toont een invulformulier om een Voter toe te voegen
        - POST naar /admin/voter voegt een voter toe (wederom via de service)
        - GET naar /admin/category/all toont een lijst van alle categories in het systeem
        - GET naar /admin/voter/all toont een lijst van alle voters in het systeem
- Voeg een custom error-pagina toe die getoond wordt als je een URI aanroept die niet gekend is door onze web-applicatie. (invulling naar keuze)

Deploy je applicatie op Tomcat

-----------

Beschikbare dependencies: 
```
<dependencies>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>4.3.8.Final</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>

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

    </dependencies>
```
## VERVOLG
- voeg aan de videoService een methode toe die (via JPA) alle videos gaat ophalen voor een gegeven category.name (nvdr. video heeft een property category, dus...)
- oefen de @Column en @Table annotaties nog eens in (indien je ze nog niet gebruikt heb)

## Voorbeeld main.xml

```
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("videos");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ... 
        transaction.commit();

        entityManager.close();
    }
}
```
