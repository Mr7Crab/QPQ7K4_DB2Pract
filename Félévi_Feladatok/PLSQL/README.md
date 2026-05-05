# 1) Táblák Létrehozása:
----
```sql
CREATE TABLE Kolcsonzo
(
  Kolcsonzo_ID INT NOT NULL,
  Nev VARCHAR(60) NOT NULL,
  EmailCim VARCHAR(80) NOT NULL,
  Lakcim VARCHAR(100) NOT NULL,
  Tiltott INT NOT NULL,
  Regisztracio_Datuma Date NOT NULL,
  PRIMARY KEY (Kolcsonzo_ID)
);

CREATE TABLE Konyv
(
  Konyv_ID INT NOT NULL,
  Tipus VARCHAR(30) NOT NULL,
  Szerzo_Neve VARCHAR(50) NOT NULL,
  Cim VARCHAR(80) NOT NULL,
  Kiado VARCHAR(50) NOT NULL,
  Kiadas_Ideje DATE NOT NULL,
  Konyvtar_Neve VARCHAR(80) NOT NULL,
  Darabszam INT NOT NULL,
  PRIMARY KEY (Konyv_ID)
);

CREATE TABLE Kolcsonzes
(
    Kolcsonzes_ID INT PRIMARY KEY,
    Kolcsonzes_Ideje DATE NOT NULL,
    Leadas_ideje DATE NOT NULL,
    Kolcsonzo_ID INT NOT NULL,
    Konyv_ID INT NOT NULL,
    FOREIGN KEY (Kolcsonzo_ID) REFERENCES Kolcsonzo(Kolcsonzo_ID),
    FOREIGN KEY (Konyv_ID) REFERENCES Konyv(Konyv_ID)
);
```

# 2) Tábla feltöltés:

```sql
INSERT INTO Kolcsonzo (Kolcsonzo_ID, Nev, EmailCim, LakCim, Tiltott) VALUES
    (1, 'Kiss Péter', 'kiss.peter@email.com', 'Budapest, Fő utrca 1.', 0, '2024-01-10'),
    (2, 'Nagy Anna', 'nagy.anna@email.com', 'Szeged, Kossuth tér 5.', 0, '2024-01-12'),
    (3, 'Tóth Balázs', 'toth.balazs@email.com', 'Debrecen, Piac utca 12.', 1, '2024-01-15'),
    (4, 'Szabó Éva', 'szabo.eva.email.com', 'Pécs, Rákóczi út 8.', 0, '2024-01-18'),
    (5, 'Varga Gábor', 'varga.gabor@email.com', 'Győr, Baross út 3.', 0, '2024-01-20');

INSERT INTO Konyv(Konyv_ID, Tipus, Szerzo_Neve, Cim, Kiado, Kiadas_Ideje, Konyvtar_Neve, Darabszam) VALUES
    (1, 'Regény', 'Jókai Mór', 'Az arany ember', 'Helikon', '2005-01-01', 'Központi Könyvtár', 3),
    (2, 'Sci-fi', 'Isaac Asimov', 'Alapítvány', 'Gabo', '2010-06-15', 'Városi Könyvtár', 5),
    (3, 'Fantasy', 'J.R.R. Tolkien', 'A Gyűrük Ura', 'Európa', '2001-09-21', 'Központi Könyvtár', 2),
    (4, 'Krimi', 'Agatha Chrisie', 'Tíz kicsi néger', 'Alexandra', '2012-03-10', 'Kerületi Knyvtár', 4),
    (5, 'Horror', 'Stephen King', 'Az', 'Animus', '2018-10-01', 'Városi Könyvtár', 6);

INSERT INTO Kolcsonzes (Kolcsonzes_ID, Kolcsonzes_Ideje, Leadas_ideje, Kolcsonzo_ID, Konyv_ID) VALUES
    (1, '2024-01-05', '2024-01-15', 1, 1),
    (2, '2024-01-20', '2024-01-30', 2, 1), 
    (3, '2024-02-01', '2024-02-10', 3, 2),
    (4, '2024-02-15', '2024-02-25', 1, 2),
    (5, '2024-03-01', '2024-03-10', 4, 3);
```

