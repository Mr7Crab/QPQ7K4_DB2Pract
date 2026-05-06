drop table termek cascade constraints;

create table termek (
   tkod      char(3) primary key,
   nev       varchar2(20) not null,
   ar        number(38,0),
   leiras    varchar2(20),
   kategoria char(3) not null
);