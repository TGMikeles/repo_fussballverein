
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list




CREATE TABLE Person ( --df: mult=1.0
 persnr Serial NOT NULL, --df: offset=10000 step=2 size=99999 
 vname VARCHAR(55), --df: text=vorname
 nname VARCHAR(55), --df: text=nachname
 geschlecht CHAR(1),--df: pattern='(M\W)'
 gebdate DATE --df: date
);
