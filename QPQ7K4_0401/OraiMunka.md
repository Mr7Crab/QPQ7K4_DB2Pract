CREATE TABLE Circles(
    Radius number(4) PRIMARY KEY,
    Circumference number,
    Area number
);

desc Circles

/kör kerülete konstans értékkel password: asd123
SELECT l Radius, 2*1*3.1415 Circumference from dual;


CREATE OR REPLACE Function PI RETUDN number AS
BEGIN
    RETURN 3.1415;
END;

//PI értékkel lekérdezés
SELECT l Radius, 3*1*PI() Circumference from dual;

//Kör kerülete r=1
DECLARE
    Radius number:=1;
    Circumference number;
BEGIN
    Circumference:= 2*Radius*PI;
    DBMS_OUTPUT.PUT_LINE('Radius: ' || Radius || ' Circumference: ' || Circumfenece);
END;

//több kör kerületének kiszámítása for ciklussal - változok megadása
DECLARE
    Circumfenece number;
    x number:=1;
    x number:=5;
BEGIN
    FOR i IN x..y LOOP
        Circumference:=2*i*PI();
        DBMS_OUTPUT.PUT_LINE('Radius: '||i||' Circumference: ' ||Circumference);
    END LOOP;
EMD;

//több 1...5 sugarú kör kerülete eljárással
CREATE OR REPLACE Procedure Circle (x in number, y in number) IS 
    Circumference number;
BEGIN
    FOR i IN x..y LOOP
        Circumference:= 2*i*PI();
        DBMS_OUTPUT.PUT_LINE('Radius: '||i||' Circumference: ' ||Circumference);
    END LOOP;
END;

BEGIN
    Circle(1,5);
END;

// a kör kerületét és a területét kiszámolása eljárással
CREATE OR REPLACE Procedure Circle (y in number, y in number) IS 
    Circumference number;
    Area number;
BEGIN
    FOR i IN x..y LOOP
        Circumference:=2*i*PI()
        Area:= POWER(i,2)*PI();
        DBMS_OUTPUT.PUT_LINE('Radius: '||i||' Circumference: ' ||Circumference||' Area: '|| Area);
    END LOOP;
END;

BEGIN
    Circle(1,5);
END;

//beszurás a kör adatainak beszurása a táblába
CREATE OR REPLACE Procedure Circle (x in number, y in number) IS 
    Circumference number;
    Area number;
BEGIN
    FOR i IN x..y LOOP
        Circumference:=2*i*PI()
        Area:= POWER(i,2)*PI();
        INSERT INTO Circles VALUE(i, CIrcumference, Area);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('A Circles táblába bekerültek az adatok.');
END;

BEGIN
    Circle(1,5);
END;


----------------- 


CREATE TABLE Zoo(
    ID int primary key,
    Nev varchar2(20),
    Fajta varchar2(30),
    Szuletett date,
    Suly int,
    Ertek int,
    Gondozo varchar2(30)
);
// figyelni a dátum lekérésnél lehet hogy rossz
desc zoo
BEGIN
INSERT INTO Zoo Values(2, 'Molly', 'Majom', TO_DATE('10.03.2024', 'DD-MM-YYYY'), 40, 300000, 'Kis Janos');
INSERT INTO Zoo Values(2, 'Molly', 'Majom', TO_DATE('01.02.2024', 'DD-MM-YYYY'), 40, 300000, 'Kis Janos');
INSERT INTO Zoo Values(3, 'Decker', 'Elefánt', TO_DATE('10.03.2024', 'DD-MM-YYYY'), 2200, 300000, 'Kis Janos');
INSERT INTO Zoo Values(4, 'Dotty', 'Zsiráf', TO_DATE('05.09.2025', 'DD-MM-YYYY'), 890, 300000, 'Kis Janos');
END;

select * from zoo;

------------------------

CREATE OR REPLACE PROCEDURE ErtekNovel(szazalek IN INT) IS
BEGIN
    UPDATE Zoo SET Ertek = Ertek + (Ertek * szazalek / 100);
END;

SELECT * FROM Zoo;
BEGIN
    ErtekNovel(10);
END;
SELECT * FROM Zoo;