insert into kolcsonzo (
   kolcsonzo_id,
   nev,
   emailcim,
   lakcim,
   tiltott,
   regisztracio_datuma
) values ( 1,
           'Kiss Péter',
           'kiss.peter@email.com',
           'Budapest, Fő utca 1.',
           0,
           to_date('2024-01-10','YYYY-MM-DD') );

insert into kolcsonzo values ( 2,
                               'Nagy Anna',
                               'nagy.anna@email.com',
                               'Szeged, Kossuth tér 5.',
                               0,
                               to_date('2024-01-12','YYYY-MM-DD') );

insert into kolcsonzo values ( 3,
                               'Tóth Balázs',
                               'toth.balazs@email.com',
                               'Debrecen, Piac utca 12.',
                               1,
                               to_date('2024-01-15','YYYY-MM-DD') );

insert into kolcsonzo values ( 4,
                               'Szabó Éva',
                               'szabo.eva@email.com',
                               'Pécs, Rákóczi út 8.',
                               0,
                               to_date('2024-01-18','YYYY-MM-DD') );

insert into kolcsonzo values ( 5,
                               'Varga Gábor',
                               'varga.gabor@email.com',
                               'Győr, Baross út 3.',
                               0,
                               to_date('2024-01-20','YYYY-MM-DD') );

insert into konyv values ( 1,
                           'Regény',
                           'Jókai Mór',
                           'Az arany ember',
                           'Helikon',
                           to_date('2005-01-01','YYYY-MM-DD'),
                           'Központi Könyvtár',
                           3 );

insert into konyv values ( 2,
                           'Sci-fi',
                           'Isaac Asimov',
                           'Alapítvány',
                           'Gabo',
                           to_date('2010-06-15','YYYY-MM-DD'),
                           'Városi Könyvtár',
                           5 );

insert into konyv values ( 3,
                           'Fantasy',
                           'J.R.R. Tolkien',
                           'A Gyűrűk Ura',
                           'Európa',
                           to_date('2001-09-21','YYYY-MM-DD'),
                           'Központi Könyvtár',
                           2 );

insert into konyv values ( 4,
                           'Krimi',
                           'Agatha Christie',
                           'Tíz kicsi néger',
                           'Alexandra',
                           to_date('2012-03-10','YYYY-MM-DD'),
                           'Kerületi Könyvtár',
                           4 );

insert into konyv values ( 5,
                           'Horror',
                           'Stephen King',
                           'Az',
                           'Animus',
                           to_date('2018-10-01','YYYY-MM-DD'),
                           'Városi Könyvtár',
                           6 );

insert into kolcsonzes values ( 1,
                                to_date('2024-01-05','YYYY-MM-DD'),
                                to_date('2024-01-15','YYYY-MM-DD'),
                                1,
                                1 );

insert into kolcsonzes values ( 2,
                                to_date('2024-01-20','YYYY-MM-DD'),
                                to_date('2024-01-30','YYYY-MM-DD'),
                                2,
                                1 );

insert into kolcsonzes values ( 3,
                                to_date('2024-02-01','YYYY-MM-DD'),
                                to_date('2024-02-10','YYYY-MM-DD'),
                                3,
                                2 );

insert into kolcsonzes values ( 4,
                                to_date('2024-02-15','YYYY-MM-DD'),
                                to_date('2024-02-25','YYYY-MM-DD'),
                                1,
                                2 );

insert into kolcsonzes values ( 5,
                                to_date('2024-03-01','YYYY-MM-DD'),
                                to_date('2024-03-10','YYYY-MM-DD'),
                                4,
                                3 );

commit;