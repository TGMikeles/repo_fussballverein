
-- df vorname: word=givennames.list
-- df nachname: word=familynames.list
-- df position: word=position.list




CREATE TABLE Person ( --df: mult=1.0
 persnr Serial NOT NULL, --df: offset=100000 step=2 size=9999999
 vname VARCHAR(55), --df: text=vorname
 nname VARCHAR(55), --df: text=nachname
 geschlecht CHAR(1),--df: pattern='(M\W)'
 gebdate DATE --df: start=1900-01-02 end=2005-01-01
);
