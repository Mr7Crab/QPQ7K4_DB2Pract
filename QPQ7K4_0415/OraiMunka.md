I.Task 
    - I. Task

A) Feladat:
    - Piros auto tábla készitése

Piros_Auto_create.sql
---
```sql
CREATE TABLE Piros_Auto(
    rsz varchar2 (20),
    tipus varchar2 (20),
    szin, varchar2 (20),
    kor number (3, 0), 
    ar number (10,0)
);
```
2. Feladat:

Piros_Auto_feltolt.sql 
---
```sql
INSERT INTO Piros_Auto(rsz, tipus, szin, kor, ar) VALUES
    ('ABC500', 'Opel COrsa', 'piros', 8, 800000),
    ('MCC325', 'Opel Insiqnia', 'fekete', 2, 6800000),
    ('BBM104', 'Suzuki Swift', 'piros', 5, 150000),
    ('CHR411', 'Renault Twingo', 'piros', 12, 70000),
    ('JRZ932', 'BMW M3', 'fekete', 5, 450000),
    ('JEG113', 'Opel Corsa', 'piros', 7, 90000),
    ('DER842', 'Seat Ibiza', 'szürke', 14, 50000),
    ('BAB422', 'Lada 1300S', 'fehér', 28, 220000)
    ('UFF666', 'Audi TT', 'fekete', 4, 750000);
```
3. Feladat:

MasikPiros_Auto.sql
---
```sql
CREATE TABLE MasikPiros_Auto(
    rsz varchar2 (20),
    tipus varchar2 (20),
    szin, varchar2 (20),
    kor number(3),
    ar number (10)
);
```
4. Feladat:

PirosAuto.sql
---
```sql
DECLARE
  CURSOR piros IS
    SELECT * FROM Piros_Auto
    WHERE szin = 'piros';

  x piros%ROWTYPE;

BEGIN
  OPEN piros;

  LOOP
    FETCH piros INTO x;
    EXIT WHEN piros%NOTFOUND;

    INSERT INTO MasikPiros_Auto (rsz, tipus, szin, kor, ar)
    VALUES (x.rsz, x.tipus, x.szin, x.kor, x.ar);

  END LOOP;

  CLOSE piros;

  COMMIT;
END;
/
```
5. Feladat:
---
```sql



```
6. Feladat:
---
```sql



```