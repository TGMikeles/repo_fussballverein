Ich
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list
--df mannschaft: word=mannschaft.list



CREATE TABLE Person ( --df: mult=1.0
 persnr Serial NOT NULL PRIMARY KEY, --df: offset=10000 step=2 size=99999
 vname VARCHAR(55), --df: text=vorname length=1
 nname VARCHAR(55), --df: text=nachname length=1
 geschlecht CHAR(1),--df: pattern='(M|W)'
 gebdate DATE --df: date
 CONSTRAINT PK_Person PRIMARY KEY (persnr)

);

CREATE TABLE Spieler ( --df :mult=1.0
 persnr Serial NOT NULL REFERENCES Person,--df: sub=serand
 nummer INT NOT NULL PRIMARY KEY,-- df: offset=1
 bezeichnung VARCHAR(55) NOT NULL REFERENCES Mannschaft, --df: text=vorname length=1
 position VARCHAR(55),--df: text=nachname length=1
 von DATE,--df: date start=1977-01-01 end=2015-03-03
 bis DATE,--df: date start=2000-01-01 end=2015-03-03
 gehalt  INT,--df:offset=10000
CONSTRAINT PK_Spieler PRIMARY KEY (persnr,nummer,bezeichnung),
CONSTRAINT FK_Spieler_0 FOREIGN KEY (persnr) REFERENCES Person (persnr),
CONSTRAINT FK_Spieler_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung)

);


CREATE TABLE Mannschaft ( --df :mult=1.0
 bezeichnung VARCHAR(55) NOT NULL,-- df :text=mannschaft length=1
 klasse VARCHAR(55), --df :text=nachname length=1
 naechstes_spiel date, -- date start=2016-01-01  end= 2020-01-01
CONSTRAINT PK_Person PRIMARY KEY (bezeichnung)
 );

 CREATE TABLE Trainer (--df :mult=1.0
  persnr INT NOT NULL REFERENCES Person,--df :sub=serand
  gehalt INT,--df: offset=10000
  von DATE,-- df: start=2000-01-01 end=2005-01-01
  bis DATE, --df : end=2016-01-01
  CONSTRAINT PK_Trainer PRIMARY KEY (persnr),
 CONSTRAINT FK_Trainer_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
 );

 CREATE TABLE Standort (
  sid INT NOT NULL,
  land VARCHAR(255),
  plz VARCHAR(255),
  ort VARCHAR(255),
  Standort ADD CONSTRAINT PK_Standort PRIMARY KEY (sid);
 );
 CREATE TABLE Angestellter (
  persnr INT NOT NULL,
  gehalt  INT,
  ueberstunden  CHAR(10),
  e_mail VARCHAR(55),
  CONSTRAINT PK_Angestellter PRIMARY KEY (persnr),
  CONSTRAINT FK_Angestellter_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
 );
 CREATE TABLE assitrainer (
  persnr INT NOT NULL,
  bezeichnung VARCHAR(55) NOT NULL,
  CONSTRAINT PK_assitrainer PRIMARY KEY (persnr,bezeichnung),
  CONSTRAINT FK_assitrainer_0 FOREIGN KEY (persnr) REFERENCES Trainer (persnr);
  CONSTRAINT FK_assitrainer_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung);
 );
 CREATE TABLE istKapitaen (
  persnr INT NOT NULL,
  nummer INT NOT NULL,
  bezeichnung VARCHAR(55) NOT NULL,
  CONSTRAINT PK_istKapitaen PRIMARY KEY (persnr,nummer,bezeichnung),
 CONSTRAINT FK_istKapitaen_0 FOREIGN KEY (persnr,nummer,bezeichnung) REFERENCES Spieler (persnr,nummer,bezeichnung),
 CONSTRAINT FK_istKapitaen_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung)

 );

 CREATE TABLE Mitglied (
  persnr INT NOT NULL,
  beitrag INT,
  CONSTRAINT PK_Mitglied PRIMARY KEY (persnr),
  CONSTRAINT FK_Mitglied_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)

 );

 CREATE TABLE Obmann (
  persnr INT NOT NULL,
  CONSTRAINT PK_Obmann PRIMARY KEY (persnr),
  CONSTRAINT FK_Obmann_0 FOREIGN KEY (persnr) REFERENCES Mitglied (persnr)
 );

 CREATE TABLE Zeitraum (
  persnr INT NOT NULL,
  anfang  DATE,
  ende DATE,
  CONSTRAINT PK_Zeitraum PRIMARY KEY (persnr),
  CONSTRAINT FK_Zeitraum_0 FOREIGN KEY (persnr) REFERENCES Angestellter (persnr)
 );
