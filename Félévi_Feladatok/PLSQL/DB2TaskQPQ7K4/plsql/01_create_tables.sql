create table kolcsonzo (
   kolcsonzo_id        number primary key,
   nev                 varchar2(60) not null,
   emailcim            varchar2(80) not null,
   lakcim              varchar2(100) not null,
   tiltott             number(1) default 0 not null,
   regisztracio_datuma date not null
);

create table konyv (
   konyv_id      number primary key,
   tipus         varchar2(30) not null,
   szerzo_neve   varchar2(50) not null,
   cim           varchar2(80) not null,
   kiado         varchar2(50) not null,
   kiadas_ideje  date not null,
   konyvtar_neve varchar2(80) not null,
   darabszam     number not null
);

create table kolcsonzes (
   kolcsonzes_id    number primary key,
   kolcsonzes_ideje date not null,
   leadas_ideje     date not null,
   kolcsonzo_id     number not null,
   konyv_id         number not null,
   constraint fk_kolcsonzes_kolcsonzo foreign key ( kolcsonzo_id )
      references kolcsonzo ( kolcsonzo_id ),
   constraint fk_kolcsonzes_konyv foreign key ( konyv_id )
      references konyv ( konyv_id )
);

create table kolcsonzes_naplo (
   naplo_id       number primary key,
   tabla_nev      varchar2(50),
   muvelet        varchar2(20),
   rekord_id      number,
   muvelet_datuma date default sysdate,
   leiras         varchar2(255)
);