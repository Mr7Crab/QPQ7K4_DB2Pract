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