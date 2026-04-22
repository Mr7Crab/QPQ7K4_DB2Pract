Elkészítettük az Auto táblát

# 1. Feladat:

## A Feladat rész
```sql
CREATE TABLE Auto (
    ID NUMBER(4,0) PRIMARY KEY,
    RENDSZAM CHAR(6),
    TIPUS VARCHAR2(30),
    SZIN VARCHAR2(30),
    KOR NUMBER(3,0),
    AR NUMBER(10,0),
    MUSZAKI_ERV DATE
);

INSERT INTO Auto VALUES (1, 'NC0927', 'Tesla Y', 'Fehér', 3, 26000000, TO_DATE('2024-03-12','YYYY-MM-DD'));

INSERT INTO Auto VALUES (2, 'MU2312', 'Suzuki Swift', 'Piros', 8, 1600000, TO_DATE('2025-09-05','YYYY-MM-DD'));

INSERT INTO Auto VALUES (3, '6NS418', 'Skoda Karoq', 'Kék', 2, 7000000, TO_DATE('2025-11-25','YYYY-MM-DD'));

INSERT INTO Auto VALUES (4, 'RWE611', 'Ford Focus', 'Sárga', 4, 5300000, TO_DATE('2025-12-05','YYYY-MM-DD'));

INSERT INTO Auto VALUES (5, 'PHD229', 'Skoda Scala', 'Fehér', 1, 6800000, TO_DATE('2025-06-10','YYYY-MM-DD'));

INSERT INTO Auto VALUES (6, 'ITZ215', 'Kia Ceed', 'Szürke', 3, 4900000, TO_DATE('2026-04-07','YYYY-MM-DD'));

INSERT INTO Auto VALUES (7, 'ABC123', 'Opel Corsa', 'Piros', 6, 3200000, TO_DATE('2024-08-05','YYYY-MM-DD'));

INSERT INTO Auto VALUES (8, '9ABC124', 'Opel Corsa', 'Kék', 2, 1200000, TO_DATE('2025-06-12','YYYY-MM-DD'));
```

`torolrendszám.sql`
```sql
CREATE PROCEDURE TorolRendszam(p_rendszam IN VARCHAR2) IS 
BEGIN
    DELETE FROM Auto
    WHERE rendszam = p_rendszam;
    
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Nincs ilyen rendszám!');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Sikeres törlés!');
    END IF
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Hiba történt!');
END
```
## B Feladat rész
`TipushozRendszam.sql`
```sql
CREATE OR REPLACE PROCEDURE TipushozRendszam(p_tipus IN VARCHAR2) IS
    v_rendszam Auto.rendszam%TYPE;
BEGIN
    SELECT rendszam
    INTO v_rendszam
    FROM Auto
    WHERE tipus = p_tipus;

    DBMS_OUTPUT.PUT_LINE('Rendszám: ' || v_rendszam);

EXCEPTION
    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('Nincs ilyen típusú autó!');

    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('Több ilyen típusú autó van!');
END;
```
## C Feladat rész
`szamolo.sql`
```sql
CREATE OR REPLACE PROCEDURE Szamol(
    a IN NUMBER,
    b IN NUMBER,
    muv IN VARCHAR2
)
IS
    ert FLOAT;
    jel CHAR(1);
    hibas_muvelet EXCEPTION;
BEGIN
    CASE muv
        WHEN 'add' THEN
            ert := a + b;
            jel := '+';
        WHEN 'sub' THEN
            ert := a - b;
            jel := '-';
        WHEN 'mul' THEN
            ert := a * b;
            jel := '*';
        WHEN 'div' THEN
            IF b = 0 THEN
                RAISE hibas_muvelet;
            END IF;
            ert := a / b;
            jel := '/';
        ELSE
            RAISE hibas_muvelet;
    END CASE;

    DBMS_OUTPUT.PUT_LINE(a || ' ' || jel || ' ' || b || ' = ' || ert);

EXCEPTION
    WHEN hibas_muvelet THEN
        DBMS_OUTPUT.PUT_LINE('Hibás művelet!');
END;
```

# 3. Feladat:

## A Feladat rész
Csomagok kezelése:
`ZooPackage.sql`
```sql
CREATE OR REPLACE ZooPckage AS
    PROCEDURE NewPet(i IN NUMBER, nev IN CHAR, fajta IN, CHAR, szul IN DATE, suly IN NUMBER, ertek IN NUMBER, gond IN CHAR);
    PROCEDURE DelPet(i IN NUMBER);
    PROCEDURE ModPet (i IN NUMBER, gond IN CHAR);
    PROCEDURE ListPet ();
    PROCEDURE PetNUmber ();  
END ZooPackage;
```
---
```sql 
CREATE OR REPLACE ZooPckage AS
    PROCEDURE NewPet(i IN NUMBER, nev IN CHAR, fajta IN, CHAR, szul IN DATE, suly IN NUMBER, ertek IN NUMBER, gond IN CHAR);
BEGIN
    INSERT INTO Zoo VALUES (i, nev, fajta, szul, suly, ertek, gond);
END;
    PROCEDURE DelPet (i, IN NUMBER) IS
    BEGIN
        FÍRLRZR FROM Zoo WHERE id = i;
    END;


    END;
END ZooPackage;
```