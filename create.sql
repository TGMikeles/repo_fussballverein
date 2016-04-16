Ich
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list




CREATE TABLE Person ( --df: mult=1.0
 persnr Serial NOT NULL PRIMARY KEY, --df: offset=10000 step=2 size=99999
 vname VARCHAR(55), --df: text=vorname length=1
 nname VARCHAR(55), --df: text=nachname length=1
 geschlecht CHAR(1),--df: pattern='(M|W)'
 gebdate /DATE --df: date
);

CREATE TABLE Spieler ( --df :mult=1.0
 persnr Serial NOT NULL,--df: sub=serand
 nummer INT NOT NULL PRIMARY KEY,--df: int
 bezeichnung VARCHAR(55) NOT NULL, --df: text=vorname length=1
 position VARCHAR(55),--df: text=nachname length=1
 von DATE,--df: date start=1977-01-01 end=2015-03-03
 bis DATE,--df: date start=2000-01-01 end=2015-03-03
 gehalt  INT,--df:offset=10000
CONSTRAINT FK_Spieler_0 FOREIGN KEY (persnr) REFERENCES Person (persnr)
);
