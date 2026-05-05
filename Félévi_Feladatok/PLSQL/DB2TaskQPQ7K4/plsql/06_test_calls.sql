SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Kölcsönzések listázása ---');
    kolcsonzes_pkg.listaz_kolcsonzesek;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Új kölcsönzés felvitele ---');
    kolcsonzes_pkg.uj_kolcsonzes(
        p_kolcsonzo_id => 1,
        p_konyv_id => 3,
        p_kolcsonzes_ideje => TO_DATE('2024-04-01', 'YYYY-MM-DD'),
        p_leadas_ideje => TO_DATE('2024-04-15', 'YYYY-MM-DD')
    );
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Kölcsönzés módosítása ---');
    kolcsonzes_pkg.modosit_kolcsonzes(
        p_kolcsonzes_id => 6,
        p_kolcsonzo_id => 2,
        p_konyv_id => 3,
        p_kolcsonzes_ideje => TO_DATE('2024-04-02', 'YYYY-MM-DD'),
        p_leadas_ideje => TO_DATE('2024-04-16', 'YYYY-MM-DD')
    );
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Adott kölcsönzés adatainak lekérdezése ---');
    DBMS_OUTPUT.PUT_LINE(kolcsonzes_pkg.kolcsonzes_adatok(6));
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Aggregált érték: kölcsönzések száma egy kölcsönzőnél ---');
    DBMS_OUTPUT.PUT_LINE(
        'A 2-es kölcsönző kölcsönzéseinek száma: ' ||
        kolcsonzes_pkg.kolcsonzesek_szama(2)
    );
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Kontroll trigger teszt: tiltott kölcsönző ---');
    kolcsonzes_pkg.uj_kolcsonzes(
        p_kolcsonzo_id => 3,
        p_konyv_id => 1,
        p_kolcsonzes_ideje => TO_DATE('2024-05-01', 'YYYY-MM-DD'),
        p_leadas_ideje => TO_DATE('2024-05-10', 'YYYY-MM-DD')
    );
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Törlés teszt ---');
    kolcsonzes_pkg.torol_kolcsonzes(6);
END;
/

SELECT *
FROM Kolcsonzes_Naplo
ORDER BY Naplo_ID;