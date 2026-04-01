SET SERVEROUTPUT ON;

DECLARE
    i NUMBER := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('LOOP:');
    i := 1;
    LOOP
        DBMS_OUTPUT.PUT_LINE(i);
        i := i + 1;
        EXIT WHEN i > 3;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('WHILE:');
    i := 1;
    WHILE i <= 3 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
        i := i + 1;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('FOR:');
    FOR j IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE(j);
    END LOOP;
END;
/