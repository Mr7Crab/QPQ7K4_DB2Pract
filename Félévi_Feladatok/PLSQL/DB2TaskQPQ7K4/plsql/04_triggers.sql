CREATE OR REPLACE TRIGGER trg_kolcsonzes_id
BEFORE INSERT ON Kolcsonzes
FOR EACH ROW
BEGIN
    IF :NEW.Kolcsonzes_ID IS NULL THEN
        :NEW.Kolcsonzes_ID := kolcsonzes_seq.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_kolcsonzes_kontroll
BEFORE INSERT OR UPDATE ON Kolcsonzes
FOR EACH ROW
DECLARE
    v_tiltott NUMBER;
BEGIN
    SELECT TILTOTT
    INTO v_tiltott
    FROM KOLCSONZO
    WHERE KOLCSONZO_ID = :NEW.KOLCSONZO_ID;

    IF v_tiltott = 1 THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Tiltott kolcsonzo nem kolcsonozhet konyvet.'
        );
    END IF;

    IF :NEW.LEADAS_IDEJE < :NEW.KOLCSONZES_IDEJE THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'A leadas ideje nem lehet korabbi, mint a kolcsonzes ideje.'
        );
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(
            -20003,
            'Nem letezik ilyen kolcsonzo.'
        );
END;
/

CREATE OR REPLACE TRIGGER trg_kolcsonzes_naplo
AFTER INSERT OR UPDATE OR DELETE ON Kolcsonzes
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        INSERT INTO Kolcsonzes_Naplo (
            Naplo_ID,
            Tabla_Nev,
            Muvelet,
            Rekord_ID,
            Muvelet_Datuma,
            Leiras
        ) VALUES (
            naplo_seq.NEXTVAL,
            'Kolcsonzes',
            'INSERT',
            :NEW.Kolcsonzes_ID,
            SYSDATE,
            'Új kölcsönzés rögzítve.'
        );

    ELSIF UPDATING THEN
        INSERT INTO Kolcsonzes_Naplo (
            Naplo_ID,
            Tabla_Nev,
            Muvelet,
            Rekord_ID,
            Muvelet_Datuma,
            Leiras
        ) VALUES (
            naplo_seq.NEXTVAL,
            'Kolcsonzes',
            'UPDATE',
            :NEW.Kolcsonzes_ID,
            SYSDATE,
            'Kölcsönzés módosítva.'
        );

    ELSIF DELETING THEN
        INSERT INTO Kolcsonzes_Naplo (
            Naplo_ID,
            Tabla_Nev,
            Muvelet,
            Rekord_ID,
            Muvelet_Datuma,
            Leiras
        ) VALUES (
            naplo_seq.NEXTVAL,
            'Kolcsonzes',
            'DELETE',
            :OLD.Kolcsonzes_ID,
            SYSDATE,
            'Kölcsönzés törölve.'
        );
    END IF;
END;
/

