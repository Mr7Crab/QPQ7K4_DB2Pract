create table zoo (
   id        int primary key,
   nev       varchar2(20),
   fajta     varchar2(30),
   szuletett date,
   suly      int,
   ertek     int,
   gondozo   varchar2(30)
);
// figyelni a dátum lekérésnél lehet hogy rossz
desc zoo
begin
   insert into zoo values ( 2,
                            'Molly',
                            'Majom',
                            to_date('10.03.2024','DD-MM-YYYY'),
                            40,
                            300000,
                            'Kis Janos' );
   insert into zoo values ( 2,
                            'Molly',
                            'Majom',
                            to_date('01.02.2024','DD-MM-YYYY'),
                            40,
                            300000,
                            'Kis Janos' );
   insert into zoo values ( 3,
                            'Decker',
                            'Elefánt',
                            to_date('10.03.2024','DD-MM-YYYY'),
                            2200,
                            300000,
                            'Kis Janos' );
   insert into zoo values ( 4,
                            'Dotty',
                            'Zsiráf',
                            to_date('05.09.2025','DD-MM-YYYY'),
                            890,
                            300000,
                            'Kis Janos' );
end;