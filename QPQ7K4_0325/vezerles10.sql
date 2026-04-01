SET SERVEROUTPUT ON;

DECLARE
    n    NUMBER := 10;
    elso NUMBER := 0;
    masodik NUMBER := 1;
    kov NUMBER;
BEGIN
    IF n >= 1 THEN
        DBMS_OUTPUT.PUT_LINE(elso);
    END IF;

    IF n >= 2 THEN
        DBMS_OUTPUT.PUT_LINE(masodik);
    END IF;

    FOR i IN 3..n LOOP
        kov := elso + masodik;
        DBMS_OUTPUT.PUT_LINE(kov);
        elso := masodik;
        masodik := kov;
    END LOOP;
END;
/