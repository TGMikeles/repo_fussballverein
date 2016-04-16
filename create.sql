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

CREATE TABLE Person ( --df: mult=1.0
 persnr Serial NOT NULL PRIMARY KEY, --df: offset=10000 step=2 size=99999
 vname VARCHAR(55), --df: text=vorname length=1
 nname VARCHAR(55), --df: text=nachname length=1
 geschlecht CHAR(1),--df: pattern='(M|W)'
 gebdate DATE --df: date
 CONSTRAINT PK_Person PRIMARY KEY (persnr)

);



CREATE TABLE Trainer (--df :mult=1.0
 persnr INT NOT NULL REFERENCES Person,--df :sub=serand
 gehalt int,--df: offset=10000
  von DATE,-- df: start=2000-01-01 end=2005-01-01
 bis DATE, --df : end=2016-01-01
 CONSTRAINT PK_Trainer PRIMARY KEY (persnr),
CONSTRAINT FK_Trainer_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
);

CREATE TABLE Standort (--df :mult=1.0
 sid INT NOT NULL, --df : int 
 land VARCHAR(255),--df :text=land.list length=1
 plz VARCHAR(255),--df :text=plz.list length=1
 ort VARCHAR(255),--df :text=ort.list length=1
 Standort ADD CONSTRAINT PK_Standort PRIMARY KEY (sid)
);
