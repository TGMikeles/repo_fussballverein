create table person(
persnr INTEGER,
vname  varchar(255),
nname  varchar (255),
geschlecht char(1),
gebdat   date,
PRIMARY KEY (persnr)
);

create table spieler(
bezeichnung VARCHAR(255),
persnr INTEGER,
nummer INTEGER,
gehalt integer,
position  varchar(255),
von   date,
bis   date,
primary Key (nummer),
FOREIGN Key(persnr) references person(persnr),
FOREIGN KEY(bezeichnung) references mannschaft(bezeichnung)
);

create table istkapitaen(
persnr INTEGER,
nummer INTEGER,
bezeichnung varchar(255),
FOREIGN Key(persnr) references person(persnr),
FOREIGN Key(nummer) references spieler(nummer),
foreign key (bezeichnung) references mannschaft(bezeichnung)
);
create table spiel(
mannschaften varchar(255),
datum date,
gegner varchar(255),
ergebnis varchar(255)
);
create table spielt(
persnr integer,
nummer integer,
foreign key(persnr) references person(persnr),
foreign key(nummer) references spieler(nummer)
);

create table angestellter(
persnr INTEGER,
gehalt integer,
ueberstunden integer,
e_mail varchar(255),
FOREIGN Key(persnr) references person(persnr)
);

create table mitglied(
persnr INTEGER,
beitrag integer,
FOREIGN Key(persnr) references person(persnr)
);

create table trainer(
persnr INTEGER,
nummer INTEGER,
gehalt integer,
von   date,
bis   date,
FOREIGN Key(persnr) references person(persnr)
);

create table mannschaft(
bezeichnung varchar(255),
klasse varchar(255),
naechstes_spiel date,
primary key(bezeichnung)
);

create table cheftrainer(
persnr integer,
bezeichnung varchar(255),
foreign key (persnr) references person(persnr),
foreign key (bezeichnung)references mannschaft(bezeichnung)
);


create table standort(
sid integer,
land varchar(255),
ort varchar(255),
plz varchar(255),
primary key (sid)
);

create table fanclub(
name varchar(255),
sid  integer,
persnr integer,
gegruendet date,
PRIMARY key(name),
foreign key(sid) references standort(sid),
foreign key(persnr) references person(persnr)
);
create table obmann(
persnr integer,
foreign key(persnr) references person(persnr)
);
create table zeitraum(
persnr integer,
name varchar(255),
sid integer,
anfang date,
ende date,
foreign key(persnr) references person(persnr),
foreign key(name) references fanclub(name),
foreign key (sid) references standort(sid)
);

create table assitrainer(
persnr integer,
bezeichnung varchar(255),
foreign key(persnr) references person(persnr),
foreign key (bezeichnung) references mannschaft(bezeichnung)
);

