     ___                ___                   
    |   \ ___ _ _ _ __ | _ \___  ___ _ __  ___
    | |) / _ \ '_| '  \|   / _ \/ _ \ '  \(_-<
    |___/\___/_| |_|_|_|_|_\___/\___/_|_|_/__/
                                           
    Projekt ötlet:
    

	Funkcionális követelmények:
		Adminisztrátori követelmények:
			- Lakók kapcsolatos CRUD munkavégzés lehetővététele, importálás Excelből
			    - Lakók számára meghívó email készítése sablon alapján, konfigurált SMTP kapcsolat esetén ezek tömeges kiküldése
			- Lakók szobafoglalási állapotának manuális módosítása
			- Szobák speciális státuszba rakása, ezek:
				- Nem elérhető
				- Elérhető (alap)
				- Fiú szoba
				- Lány szoba
				- Kevert szoba (alap)
			- Szoba kapacitásának felülbírálása
			- Jelenlegi foglaltségi állapot megtekintése, Excelből/be importálás/exportálás
		Felhasználói követelmények:
			- Szobák jelenlegi állapotának megtekintése
			- Jelentkezés szobába
			- Kijelentkezés szobából
			- Amennyiben a szoba a felhasználó szobába jelentkezése előtt üres volt, akkor lehetőség a szoba speciális státuszba rakására (fiú szoba, lány szoba, kevert szoba). Amennyiben a szoba ismét megüresedik ez az állapot alaphelyzetbe áll.
			- Szoba váltás tranzakció szinten
	Nem funkcionális követelmények:
		- Felhasználó barát interfész
		- Reszponzív megjelenítés
		- WCAG 2.0 standard teljesítése (ISO/IEC 40500:2012)
	Szakterületi fogalomjegyzék:
		- Lakó - Egy egyetemi hallgató vagy egyéb kollégiumi lakhatási jogával rendelkező természetes személy, aki felvételt nyert az aktuális kollégiumba és ezzel a jogával élve beköltözni kíván vagy élő tartózkodási jogát meghosszabítani kívánja.
		- Adminisztrátor - Az adott kollégiumhoz tartozó Kollégiumi Hallgatói Önkormányzat kijelölt személyei akik kezelik a kollégiumba való beköltözéssel kapcsolatos ügyeket.
		- CRUD - Programozási szakszó ami a "Create, read, update, delete" szavak rövidítését jelenti, aminek magyar megfelelői "Készít, olvas, frissít, töröl".
		- Importálás - Adatok felvitele már létező digitális állományból.
		- Exportálás - A programban található adatok általánosabban kezelhető digitális állományba való másolása.
		- Excel - A Microsoft Office programcsomag táblázatkezelő szoftvere.
		- Meghívó email - Olyan elektromos levél amiben egy a regisztráció befejezésére szolgáló oldalra vezető link található, ami tartalmaz egy egyedi adatot ami alkalmas annak bizonyítására, hogy az adott felhasználó valóban megkapta a meghívót és nem csak betöltötte az oldalt.
		- SMTP - Kommunikációs protokoll amit elektromos levelek (email) küldésére találtak ki, a rövidítés a "Simple Mail Transfer Protocol" szavakból áll össze.
		- Szobafoglalási állapot - Olyan leírás ami tartalmazza, hogy egy lakó melyik szobában található és ha van ilyen szoba akkor továbbá tartalmazza, a szoba adatai és a szoba többi lakójának nevét.
		- Nem elérhető szoba állapot - A szobába a beköltözés nem lehetséges.
		- Elérhető - A szobába be lehet költözni ha van még benne hely.
		- Fiú szoba - A szobába csak férfi lakók költözhetnek be.
		- Lány szoba - A szobába csak női lakók költözhetnek be.
		- Kevert szoba - A szobába bármelyik nem lakói beköltözhetnek.
		- Szoba kapacitása - A szobába maximum beköltöztethető lakók száma.
		- Szoba váltási tranzakció - A szoba csere műveleteinek (kiköltözés, beköltözés) egy műveletkénti végrehajtása a versenyhelyzet elkerülése végett.
		- Reszponzív - Felbontás független megjelenítési mód, a felhasználói felület alkalmazkodik a kijelző méretéhez és orientációjához.
		- WCAG - "Web Content Accessibility Guidelines" a webes felületek könnyű kezelhetőségének irányelvei amik lehetővé teszik látássérültek és egyéb fogyatékkal élő felhasználók számára a program használatát.
	Szerepkörök:
		- Adminisztrátor
		- Lakó
