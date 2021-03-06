Ich
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list
--df mannschaft: word=mannschaft.list
--df plz: word=plz.list
--df ort: word=ort.list
--df land: word=land.list
--df klasse: word=klasse.list


CREATE TABLE Mannschaft ( --df :mult=1.0
 bezeichnung VARCHAR(55) NOT NULL,-- df :text=mannschaft length=1
 klasse VARCHAR(55), --df :text=klasse length=1
 naechstes_spiel date, -- date start=2016-01-01  end= 2020-01-01
CONSTRAINT PK_Mannschaft PRIMARY KEY (bezeichnung)
 );

CREATE TABLE Person ( --df: mult=4.0
 persnr Serial NOT NULL PRIMARY KEY, --df: offset=10000 step=2 size=99999
 vname VARCHAR(55), --df: text=vorname length=1
 nname VARCHAR(55), --df: text=nachname length=1
 geschlecht CHAR(1),--df: pattern='(M|W)'
 gebdate DATE --df: date
 CONSTRAINT PK_Person PRIMARY KEY (persnr)

);



CREATE TABLE Trainer (--df :mult=1.0
 persnr Serial NOT NULL REFERENCES Person(persnr),
 gehalt int,--df: offset=10000
  von DATE,-- df: start=2000-01-01 end=2005-01-01
 bis DATE, --df : end=2016-01-01
 CONSTRAINT PK_Trainer PRIMARY KEY (persnr),
CONSTRAINT FK_Trainer_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
);

CREATE TABLE Standort (--df :mult=1.0
 sid INT NOT NULL, --df : offset=1
 land VARCHAR(55), --df: text=land length=1
 plz VARCHAR(55), --df: text=plz length=1
 ort VARCHAR(55), --df: text=ort length=1
CONSTRAINT PK_Standort PRIMARY KEY (sid)
);

CREATE TABLE Angestellter (--df: mult=1.0
 persnr Serial NOT NULL REFERENCES Person(persnr),
 gehalt decimal(10,2),--df:nogen
 ueberstunden  INT,--df: offset=1 size=10
 e_mail VARCHAR(255),--df :pattern='[a-z]{3,8}\.[a-z]{3,8}@(gmail|yahoo)\.com'
 CONSTRAINT PK_Angestellter PRIMARY KEY (persnr),
 CONSTRAINT FK_Angestellter_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
);

CREATE TABLE assitrainer (-- df: mult=1.0
 persnr Serial NOT NULL REFERENCES Person(persnr),
 bezeichnung VARCHAR(55) NOT NULL REFERENCES Mannschaft(bezeichnung),
 CONSTRAINT PK_assitrainer PRIMARY KEY (persnr,bezeichnung),
 CONSTRAINT FK_assitrainer_0 FOREIGN KEY (persnr) REFERENCES Trainer (persnr),
 CONSTRAINT FK_assitrainer_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung)
);




CREATE TABLE Mitglied ( --df : mult=1.0
 persnr Serial NOT NULL REFERENCES Person(persnr),
 beitrag INT,--df:offset=1
 CONSTRAINT PK_Mitglied PRIMARY KEY (persnr),
 CONSTRAINT FK_Mitglied_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
);

CREATE TABLE Obmann (--df : mult=1.0
 persnr Serial NOT NULL REFERENCES Person(persnr),
 CONSTRAINT PK_Obmann PRIMARY KEY (persnr),
 CONSTRAINT FK_Obmann_0 FOREIGN KEY (persnr) REFERENCES Mitglied (persnr)
);



 CREATE TABLE Spieler ( --df :mult=1.0
  persnr Serial NOT NULL REFERENCES Person(persnr),
    position VARCHAR(55),--df: text=position length=1
    von DATE,--df: date start=1977-01-01 end=2015-03-03
    bis DATE,--df: date start=2000-01-01 end=2015-03-03
    gehalt  INT,--df: nogen
    CONSTRAINT PK_Spieler PRIMARY KEY (persnr),
    CONSTRAINT FK_Spieler_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
 );

 CREATE TABLE istKapitaen ( --df: mult=1.0
  persnr Serial NOT NULL REFERENCES Person(persnr),
  trikotnummer Serial NOT NULL,--df :offset=1 step=1 size=100
  CONSTRAINT PK_istKapitaen PRIMARY KEY (persnr,trikotnummer),
  CONSTRAINT FK_istKapitaen_0 FOREIGN KEY (trikotnummer) REFERENCES Person (trikotnummer)
 );
 CREATE TABLE spielt ( --df: mult=1.0
  persnr Serial NOT NULL REFERENCES Spieler(persnr),
  bezeichnung VARCHAR(55) NOT NULL REFERENCES Mannschaft(bezeichnung),
  dauer INT
  CONSTRAINT PK_spielt PRIMARY KEY (persnr,bezeichnung),
  CONSTRAINT FK_istKapitaen_0 FOREIGN KEY (persnr) REFERENCES Spieler (persnr),
  CONSTRAINT FK_istKapitaen_ 1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung)
 );

 CREATE TABLE cheftrainer (-- df: mult=1.0
  persnr Serial NOT NULL REFERENCES Person(persnr),
  bezeichnung VARCHAR(55) NOT NULL REFERENCES Mannschaft(bezeichnung),
  CONSTRAINT PK_cheftrainer PRIMARY KEY (persnr,bezeichnung),
  CONSTRAINT FK_cheftrainer_0 FOREIGN KEY (persnr) REFERENCES Trainer (persnr),
  CONSTRAINT FK_cheftrainer_1 FOREIGN KEY (bezeichnung) REFERENCES Mannschaft (bezeichnung)
 );
