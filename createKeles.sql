
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list
-- df laender: word=laender.list
-- df orte: word=orte.list
-- df plz: word=postleitzahl.list

CREATE TABLE Mannschaft (
 bezeichnung VARCHAR(55) NOT NULL,
 klasse VARCHAR(55),
 naechstes_spiel VARCHAR(55)
);

ALTER TABLE Mannschaft ADD CONSTRAINT PK_Mannschaft PRIMARY KEY (bezeichnung);


CREATE TABLE Person (
 persnr Serial NOT NULL,
 vname VARCHAR(55), --df:
 nname VARCHAR(55),
 geschlecht CHAR(1),--df :pattern['M','W']
 gebdate DATE --df: date
);

ALTER TABLE Person ADD CONSTRAINT PK_Person PRIMARY KEY (persnr);


CREATE TABLE Spiel (
 mannschaft VARCHAR(55),
 datum DATE, --df:date
 gegner VARCHAR(55),
 ergebnis VARCHAR(55)
);


CREATE TABLE Spieler (
 persnr Serial NOT NULL,
 nummer INT NOT NULL,
 bezeichnung VARCHAR(55) NOT NULL,
 position VARCHAR(55),
 von DATE,
 bis DATE,
 gehalt  INT
);

ALTER TABLE Spieler ADD CONSTRAINT PK_Spieler PRIMARY KEY (persnr,nummer,bezeichnung);


CREATE TABLE spielt (
 persnr Serial NOT NULL,
 nummer INT NOT NULL,
 bezeichnung VARCHAR(55) NOT NULL,
 dauer INT --df :pattern[0-90]
);

ALTER TABLE spielt ADD CONSTRAINT PK_spielt PRIMARY KEY (persnr,nummer,bezeichnung);


CREATE TABLE Standort (
 sid INT NOT NULL,
 land VARCHAR(255),
 plz VARCHAR(255),
 ort VARCHAR(255)
);

ALTER TABLE Standort ADD CONSTRAINT PK_Standort PRIMARY KEY (sid);


CREATE TABLE Trainer (
 persnr Serial NOT NULL,
 gehalt INT,
 von DATE,
 bis DATE
);

ALTER TABLE Trainer ADD CONSTRAINT PK_Trainer PRIMARY KEY (persnr);


CREATE TABLE Angestellter (
 persnr Serial NOT NULL,
 gehalt  INT,
 ueberstunden  CHAR(10),
 e_mail VARCHAR(55)
);

ALTER TABLE Angestellter ADD CONSTRAINT PK_Angestellter PRIMARY KEY (persnr);


CREATE TABLE assitrainer (
 persnr Serial NOT NULL,
 bezeichnung VARCHAR(55) NOT NULL
);

ALTER TABLE assitrainer ADD CONSTRAINT PK_assitrainer PRIMARY KEY (persnr,bezeichnung);


CREATE TABLE cheftrainer (
 persnr Serial NOT NULL,
 bezeichnung VARCHAR(55) NOT NULL
);

ALTER TABLE cheftrainer ADD CONSTRAINT PK_cheftrainer PRIMARY KEY (persnr,bezeichnung);


CREATE TABLE istKapitaen (
 persnr Serial NOT NULL,
 nummer INT NOT NULL,
 bezeichnung VARCHAR(55) NOT NULL
);

ALTER TABLE istKapitaen ADD CONSTRAINT PK_istKapitaen PRIMARY KEY (persnr,nummer,bezeichnung);


CREATE TABLE Mitglied (
 persnr Serial NOT NULL,
 beitrag INT
);

ALTER TABLE Mitglied ADD CONSTRAINT PK_Mitglied PRIMARY KEY (persnr);


CREATE TABLE Obmann (
 persnr Serial NOT NULL
);

ALTER TABLE Obmann ADD CONSTRAINT PK_Obmann PRIMARY KEY (persnr);


CREATE TABLE Zeitraum (
 persnr Serial NOT NULL,
 anfang  DATE,
 ende DATE
);

ALTER TABLE Zeitraum ADD CONSTRAINT PK_Zeitraum PRIMARY KEY (persnr);


CREATE TABLE fanclub (
 name VARCHAR(255) NOT NULL,
 persnr Serial NOT NULL,
 gegruendet  DATE,
 sid INT
);

ALTER TABLE fanclub ADD CONSTRAINT PK_fanclub PRIMARY KEY (name,persnr);


ALTER TABLE Spieler ADD CONSTRAINT FK_Spieler_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);
ALTER TABLE Spieler ADD CONSTRAINT FK_Spieler_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE spielt ADD CONSTRAINT FK_spielt_0 FOREIGN KEY (persnr,nummer,bezeichnung) REFERENCES Spieler (persnr,nummer,bezeichnung);


ALTER TABLE Trainer ADD CONSTRAINT FK_Trainer_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Angestellter ADD CONSTRAINT FK_Angestellter_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE assitrainer ADD CONSTRAINT FK_assitrainer_0 FOREIGN KEY (persnr) REFERENCES Trainer (persnr);
ALTER TABLE assitrainer ADD CONSTRAINT FK_assitrainer_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE cheftrainer ADD CONSTRAINT FK_cheftrainer_0 FOREIGN KEY (persnr) REFERENCES Trainer (persnr);
ALTER TABLE cheftrainer ADD CONSTRAINT FK_cheftrainer_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE istKapitaen ADD CONSTRAINT FK_istKapitaen_0 FOREIGN KEY (persnr,nummer,bezeichnung) REFERENCES Spieler (persnr,nummer,bezeichnung);
ALTER TABLE istKapitaen ADD CONSTRAINT FK_istKapitaen_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung);


ALTER TABLE Mitglied ADD CONSTRAINT FK_Mitglied_0 FOREIGN KEY (persnr) REFERENCES Person (persnr);


ALTER TABLE Obmann ADD CONSTRAINT FK_Obmann_0 FOREIGN KEY (persnr) REFERENCES Mitglied (persnr);


ALTER TABLE Zeitraum ADD CONSTRAINT FK_Zeitraum_0 FOREIGN KEY (persnr) REFERENCES Angestellter (persnr);


ALTER TABLE fanclub ADD CONSTRAINT FK_fanclub_0 FOREIGN KEY (persnr) REFERENCES Obmann (persnr);
ALTER TABLE fanclub ADD CONSTRAINT FK_fanclub_1 FOREIGN KEY (sid) REFERENCES Standort (sid);
