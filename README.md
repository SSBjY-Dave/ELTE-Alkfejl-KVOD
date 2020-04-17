     ___                ___                   
    |   \ ___ _ _ _ __ | _ \___  ___ _ __  ___
    | |) / _ \ '_| '  \|   / _ \/ _ \ '  \(_-<
    |___/\___/_| |_|_|_|_|_\___/\___/_|_|_/__/
                                           
# Projekt ötlet:
## Funkcionális követelmények:
  * Adminisztrátori követelmények:
    * Lakók kapcsolatos CRUD munkavégzés lehetővététele, importálás Excelből
      * Lakók számára meghívó email készítése sablon alapján, konfigurált SMTP kapcsolat esetén ezek tömeges kiküldése
    * Lakók szobafoglalási állapotának manuális módosítása
    * Szobák speciális státuszba rakása, ezek:
      * Nem elérhető
      * Elérhető (alap)
      * Fiú szoba
      * Lány szoba
      * Kevert szoba (alap)
    * Szoba kapacitásának felülbírálása
    * Jelenlegi foglaltségi állapot megtekintése, Excelből/be importálás/exportálás
    * Lakókhoz cimkék rendelése, ezeknek a cimkéknek létrehozása, törlése, módosítása.
  * Felhasználói követelmények:
    * Szobák jelenlegi állapotának megtekintése
    * Jelentkezés szobába
    * Kijelentkezés szobából
    * Amennyiben a szoba a felhasználó szobába jelentkezése előtt üres volt, akkor lehetőség a szoba speciális státuszba rakására (fiú szoba, lány szoba, kevert szoba). Amennyiben a szoba ismét megüresedik ez az állapot alaphelyzetbe áll.
    * Szoba váltás tranzakció szinten
## Nem funkcionális követelmények:
  * Felhasználó barát interfész
  * Reszponzív megjelenítés
  * WCAG 2.0 standard teljesítése (ISO/IEC 40500:2012)
## Szakterületi fogalomjegyzék:
  * Lakó - Egy egyetemi hallgató vagy egyéb kollégiumi lakhatási jogával rendelkező természetes személy, aki felvételt nyert az aktuális kollégiumba és ezzel a jogával élve beköltözni kíván vagy élő tartózkodási jogát meghosszabítani kívánja.
  * Adminisztrátor - Az adott kollégiumhoz tartozó Kollégiumi Hallgatói Önkormányzat kijelölt személyei akik kezelik a kollégiumba való beköltözéssel kapcsolatos ügyeket.
  * CRUD - Programozási szakszó ami a "Create, read, update, delete" szavak rövidítését jelenti, aminek magyar megfelelői "Készít, olvas, frissít, töröl".
  * Importálás - Adatok felvitele már létező digitális állományból.
  * Exportálás - A programban található adatok általánosabban kezelhető digitális állományba való másolása.
  * Excel - A Microsoft Office programcsomag táblázatkezelő szoftvere.
  * Meghívó email - Olyan elektromos levél amiben egy a regisztráció befejezésére szolgáló oldalra vezető link található, ami tartalmaz egy egyedi adatot ami alkalmas annak bizonyítására, hogy az adott felhasználó valóban megkapta a meghívót és nem csak betöltötte az oldalt.
  * SMTP - Kommunikációs protokoll amit elektromos levelek (email) küldésére találtak ki, a rövidítés a "Simple Mail Transfer Protocol" szavakból áll össze.
  * Szobafoglalási állapot - Olyan leírás ami tartalmazza, hogy egy lakó melyik szobában található és ha van ilyen szoba akkor továbbá tartalmazza, a szoba adatai és a szoba többi lakójának nevét.
  * Nem elérhető szoba állapot - A szobába a beköltözés nem lehetséges.
  * Elérhető - A szobába be lehet költözni ha van még benne hely.
  * Fiú szoba - A szobába csak férfi lakók költözhetnek be.
  * Lány szoba - A szobába csak női lakók költözhetnek be.
  * Kevert szoba - A szobába bármelyik nem lakói beköltözhetnek.
  * Szoba kapacitása - A szobába maximum beköltöztethető lakók száma.
  * Szoba váltási tranzakció - A szoba csere műveleteinek (kiköltözés, beköltözés) egy műveletkénti végrehajtása a versenyhelyzet elkerülése végett.
  * Reszponzív - Felbontás független megjelenítési mód, a felhasználói felület alkalmazkodik a kijelző méretéhez és orientációjához.
  * WCAG - "Web Content Accessibility Guidelines" a webes felületek könnyű kezelhetőségének irányelvei amik lehetővé teszik látássérültek és egyéb fogyatékkal élő felhasználók számára a program használatát.
## Szerepkörök:
  * Adminisztrátor
  * Lakó
# Backend
## Fejlesztői környezet
A projekt létrehozásához [Apache Maven](https://maven.apache.org/) használva, ezért bármilyen Maven támogatással rendelkező IDE képes a projektet megnyitni. A fejlesztéshez használt IDE: [JetBrains IntelliJ](https://www.jetbrains.com/idea/).  A projekt a Java programozási nyelvet használva késztült és a projekt célplatformja a JRE 11. A HTTP kérések manuális kiküldéséhez ajánlott eszköz: [Postman](https://www.postman.com/).
### IntelliJ beállítások
Mivel az IntelliJ előrecsomagoltan érkezik Mavennel, ezért amikor megnyitjuk vele a projekt mappáját minden függőség letöltésre kerül és konfigurálódik a pom.xml alapján.

Ha az egyetlen Java SDK van telepítve akkor az autómatikusan beállításra kerül a projekthez. A pom.xml-ben meg van jelölve a 11-es Java verziü ezért ha több SDK verzió van telepítve amik eggyike a 11-es, akkor az lesz kiválasztva. Ha több 11-es verziójú SDK van telepítve amelyikek eggyike az Open-JDK, akkor az lesz kiválasztva.ú
### Függőségek
 * org.springframework.boot:spring-boot-starter-data-jpa
 * org.springframework.boot:spring-boot-starter-web
 * org.springframework.boot:spring-boot-starter-jdbc
 * org.springframework.boot:spring-boot-devtools
 * com.h2database:h2
 * org.projectlombok:lombok
 * org.springframework.boot:spring-boot-starter-security
 * org.springframework.boot:spring-boot-starter-test (kivéve org.junit.vintage:junit-vintage-engine)
## Adatbázis struktúra
Ez a diagram mutatja az adatbázik struktúrát az adatbázis motor szemszögéből. Az alkalmazásban néhány dolog ezekből néhány dolog el van rejtve vagy nem így szerepel a használt JPA absztrakciói miatt. Például a LabelPersonJoinTable tábla nem létezik a kódban, mert ez csak arra van használva, hogy a sok-sok kapcsolat reprezentálva legyen az [ISO/IEC 19505-2:2012](https://www.iso.org/standard/52854.html) szabvány szerint.
 
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/database_layout.PNG)
## Könyvtár struktúra

	.
	|
	+---.gitignore
	|
	+---DormRooms.iml
	|
	+---mvnw
	|
	+---mvnw.cmd
	|
	+---pom.xml
	|
	+---README.md
	|
	+---data
	|	|
	|	+---database.mv.db
	|	|
	|	\---database.trace.db
	|
	+---docs
	|	\---uml
	|		|
	|		+---database_layout.PNG
	|		|
	|		+---enpoint_diagram.png
	|		|
	|		+---enpoint_diagram.pu
	|		|
	|		+---enpoint_query_sequence.png
	|		|
	|		+---enpoint_query_sequence.pu
	|		|
	|		\---backend
	|			|
	|			+---overview.png
	|			|
	|			+---package_controller.png
	|			|
	|			+---package_model.png
	|			|
	|			+---package_security.png
	|			|
	|			\---package_service.png
	|
	\---src
		+---main
		|	+---java
		|	|	\---hu
		|	|		\---elte
		|	|			\---alkfejl
		|	|				\---DormRooms
		|	|					|
		|	|					+---DormRoomsApplication.java
		|	|					|
		|	|					+---controller
		|	|					|	|
		|	|					|	+---AdminController.java
		|	|					|	|
		|	|					|	+---MainController.java
		|	|					|	|
		|	|					|	\---UserController.java
		|	|					|
		|	|					+---model
		|	|					|	|
		|	|					|	+---Gender.java
		|	|					|	|
		|	|					|	+---Label.java
		|	|					|	|
		|	|					|	+---LabelRepo.java
		|	|					|	|
		|	|					|	+---Layout.java
		|	|					|	|
		|	|					|	+---LayoutRepo.java
		|	|					|	|
		|	|					|	+---Person.java
		|	|					|	|
		|	|					|	+---PersonRepo.java
		|	|					|	|
		|	|					|	+---Role.java
		|	|					|	|
		|	|					|	+---Room.java
		|	|					|	|
		|	|					|	+---RoomRepo.java
		|	|					|	|
		|	|					|	+---RoomState.java
		|	|					|	|
		|	|					|	\---RoomType.java
		|	|					|
		|	|					+---security
		|	|					|	|
		|	|					|	+--AuthenticatedUser.java
		|	|					|	|
		|	|					|	+--CustomBasicAuthenticationEntryPoint.java
		|	|					|	|
		|	|					|	+--MyUserDetailsService.java
		|	|					|	|
		|	|					|	\--WebSecurityConfig.java
		|	|					|
		|	|					\---service
		|	|						|
		|	|						+---AdminModeService.java
		|	|						|
		|	|						\---UserModeService.java
		|	|
		|	\---resources
		|		|
		|		+---application.properties
		|		|
		|		\---import.sql
		|
		\---test
			\---java
				\---hu
					\---elte
						\---alkfejl
							\---DormRooms
								|
								\---DormRoomsApplicationTests.java

## UML
### Példa végpont lekérdezési szekvencia
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/enpoint_query_sequence.png)
### Backend
#### Service package
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/backend/package_service.png)
#### Security package
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/backend/package_security.png)
#### Model package
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/backend/package_model.png)
#### Controller package
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/backend/package_controller.png)
#### Áttekintés
![](https://github.com/SSBjY-Dave/ELTE-Alkfejl-KVOD/blob/master/docs/uml/backend/overview.png)