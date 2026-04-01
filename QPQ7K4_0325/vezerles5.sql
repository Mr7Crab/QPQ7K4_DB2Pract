SET SERVEROUTPUT ON;

DECLARE
    beosztas VARCHAR2(20) := 'root';
    teljes   VARCHAR2(50);
BEGIN
    CASE LOWER(beosztas)
        WHEN 'root' THEN teljes := 'Rendszergazda';
        WHEN 'dev'  THEN teljes := 'Fejlesztő';
        WHEN 'hr'   THEN teljes := 'Humánerőforrás munkatárs';
        WHEN 'pm'   THEN teljes := 'Projektmenedzser';
        ELSE teljes := 'Ismeretlen beosztás';
    END CASE;

    DBMS_OUTPUT.PUT_LINE('Beosztás: ' || teljes);
END;
/