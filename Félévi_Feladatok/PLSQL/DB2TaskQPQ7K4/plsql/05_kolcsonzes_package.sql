CREATE OR REPLACE PACKAGE kolcsonzes_pkg AS

    PROCEDURE uj_kolcsonzes(
        p_kolcsonzo_id IN NUMBER,
        p_konyv_id IN NUMBER,
        p_kolcsonzes_ideje IN DATE,
        p_leadas_ideje IN DATE
    );

    PROCEDURE modosit_kolcsonzes(
        p_kolcsonzes_id IN NUMBER,
        p_kolcsonzo_id IN NUMBER,
        p_konyv_id IN NUMBER,
        p_kolcsonzes_ideje IN DATE,
        p_leadas_ideje IN DATE
    );

    PROCEDURE torol_kolcsonzes(
        p_kolcsonzes_id IN NUMBER
    );

    FUNCTION kolcsonzes_adatok(
        p_kolcsonzes_id IN NUMBER
    ) RETURN VARCHAR2;

    FUNCTION kolcsonzesek_szama(
        p_kolcsonzo_id IN NUMBER
    ) RETURN NUMBER;

    PROCEDURE listaz_kolcsonzesek;

END kolcsonzes_pkg;
/


CREATE OR REPLACE PACKAGE BODY kolcsonzes_pkg AS

    PROCEDURE uj_kolcsonzes(
        p_kolcsonzo_id IN NUMBER,
        p_konyv_id IN NUMBER,
        p_kolcsonzes_ideje IN DATE,
        p_leadas_ideje IN DATE
    )
    AS
    BEGIN
        INSERT INTO Kolcsonzes (
            Kolcsonzes_ID,
            Kolcsonzes_Ideje,
            Leadas_Ideje,
            Kolcsonzo_ID,
            Konyv_ID
        ) VALUES (
            NULL,
            p_kolcsonzes_ideje,
            p_leadas_ideje,
            p_kolcsonzo_id,
            p_konyv_id
        );

        DBMS_OUTPUT.PUT_LINE('Új kölcsönzés sikeresen rögzítve.');

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Hiba az új kölcsönzés rögzítésekor: ' || SQLERRM);
    END uj_kolcsonzes;


    PROCEDURE modosit_kolcsonzes(
        p_kolcsonzes_id IN NUMBER,
        p_kolcsonzo_id IN NUMBER,
        p_konyv_id IN NUMBER,
        p_kolcsonzes_ideje IN DATE,
        p_leadas_ideje IN DATE
    )
    AS
    BEGIN
        UPDATE Kolcsonzes
        SET Kolcsonzo_ID = p_kolcsonzo_id,
            Konyv_ID = p_konyv_id,
            Kolcsonzes_Ideje = p_kolcsonzes_ideje,
            Leadas_Ideje = p_leadas_ideje
        WHERE Kolcsonzes_ID = p_kolcsonzes_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Nincs ilyen azonosítójú kölcsönzés.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Kölcsönzés sikeresen módosítva.');
        END IF;

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Hiba a kölcsönzés módosításakor: ' || SQLERRM);
    END modosit_kolcsonzes;


    PROCEDURE torol_kolcsonzes(
        p_kolcsonzes_id IN NUMBER
    )
    AS
    BEGIN
        DELETE FROM Kolcsonzes
        WHERE Kolcsonzes_ID = p_kolcsonzes_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Nincs ilyen azonosítójú kölcsönzés.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Kölcsönzés sikeresen törölve.');
        END IF;

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Hiba a kölcsönzés törlésekor: ' || SQLERRM);
    END torol_kolcsonzes;


    FUNCTION kolcsonzes_adatok(
        p_kolcsonzes_id IN NUMBER
    ) RETURN VARCHAR2
    AS
        v_eredmeny VARCHAR2(500);
    BEGIN
        SELECT 'Kölcsönzés ID: ' || kz.Kolcsonzes_ID ||
               ', Kölcsönző: ' || ko.Nev ||
               ', Könyv: ' || k.Cim ||
               ', Kölcsönzés ideje: ' || TO_CHAR(kz.Kolcsonzes_Ideje, 'YYYY-MM-DD') ||
               ', Leadás ideje: ' || TO_CHAR(kz.Leadas_Ideje, 'YYYY-MM-DD')
        INTO v_eredmeny
        FROM Kolcsonzes kz
        JOIN Kolcsonzo ko ON kz.Kolcsonzo_ID = ko.Kolcsonzo_ID
        JOIN Konyv k ON kz.Konyv_ID = k.Konyv_ID
        WHERE kz.Kolcsonzes_ID = p_kolcsonzes_id;

        RETURN v_eredmeny;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 'Nincs ilyen azonosítójú kölcsönzés.';
        WHEN OTHERS THEN
            RETURN 'Hiba történt: ' || SQLERRM;
    END kolcsonzes_adatok;


    FUNCTION kolcsonzesek_szama(
        p_kolcsonzo_id IN NUMBER
    ) RETURN NUMBER
    AS
        v_db NUMBER;
    BEGIN
        SELECT COUNT(*)
        INTO v_db
        FROM Kolcsonzes
        WHERE Kolcsonzo_ID = p_kolcsonzo_id;

        RETURN v_db;

    EXCEPTION
        WHEN OTHERS THEN
            RETURN -1;
    END kolcsonzesek_szama;


    PROCEDURE listaz_kolcsonzesek
    AS
        CURSOR c_kolcsonzesek IS
            SELECT kz.Kolcsonzes_ID,
                   ko.Nev,
                   k.Cim,
                   kz.Kolcsonzes_Ideje,
                   kz.Leadas_Ideje
            FROM Kolcsonzes kz
            JOIN Kolcsonzo ko ON kz.Kolcsonzo_ID = ko.Kolcsonzo_ID
            JOIN Konyv k ON kz.Konyv_ID = k.Konyv_ID
            ORDER BY kz.Kolcsonzes_ID;

        v_sor c_kolcsonzesek%ROWTYPE;
    BEGIN
        OPEN c_kolcsonzesek;

        LOOP
            FETCH c_kolcsonzesek INTO v_sor;
            EXIT WHEN c_kolcsonzesek%NOTFOUND;

            DBMS_OUTPUT.PUT_LINE(
                v_sor.Kolcsonzes_ID || ' - ' ||
                v_sor.Nev || ' - ' ||
                v_sor.Cim || ' - ' ||
                TO_CHAR(v_sor.Kolcsonzes_Ideje, 'YYYY-MM-DD') || ' - ' ||
                TO_CHAR(v_sor.Leadas_Ideje, 'YYYY-MM-DD')
            );
        END LOOP;

        CLOSE c_kolcsonzesek;

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Hiba a kölcsönzések listázásakor: ' || SQLERRM);
    END listaz_kolcsonzesek;

END kolcsonzes_pkg;
/