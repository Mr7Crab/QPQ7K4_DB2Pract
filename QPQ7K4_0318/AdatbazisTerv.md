CREATE TABLE Hallgato (
    ID int PRIMATY KEY,
    Vnév varchar2(35),
    Knév Varchar2(35),
    Szülidő date,
    Lakcím varchar2(45)
);

CREATE TALE Projekt (
    Pkód int PRIMARY KEY,
    Név varchar2(60),
    Összérték int,
    Indul date,
    Zárul date
);

CREATE TABLE Dolgozik (
    ID int,
    Pkód int,
    PRIMARY KEY (ID, Pkód),
    FOREIGN KEY (ID) REFERENCES Hallgató(ID),
    FOREIGN KEY (Pkód) REFERENCES Projekt(Pkód)
);

INSERT INTO Hallgato (ID, Vnev, Knev, SzulIdo, Lakcim) VALUES
(2, 'Nagy', 'Péter', '2000-02-01', 'Budapest Károly u. 20'),
(3, 'Fehér', 'Piros', '2010-03-01', 'Pécs Erzsébet u. 30'),
(1, 'Kis', 'János', '2015-01-01', 'Miskolc Ferenc u. 10'),
(4, 'János', 'Pál', '1998-04-01', 'Debrecen Janos u. 40');

INSERT INTO Projekt (Pkod, Nev, Osszertek, Indul, Zarul) VALUES
(1, 'Lufi', 1200000, '2025-01-01', '2026-02-01'),
(2, 'Ragya', 2300000, '2024-01-01', '2026-03-01'),
(3, 'Táltos', 3400000, '2023-01-01', '2026-04-01'),
(4, 'Rófi', 4500000, '2024-01-01', '2026-05-01');

INSERT INTO Dolgozik (ID, Pkod) VALUES
(1, 1),
(2, 1),
(2, 3),
(3, 1);