DECLARE
    a number := 10;
    b number :=81;
BEGIN
    IF a > b THEN
        dbms_output.put_line('Az "a" szam a nagyobb!');
    ELSE
        dbms_output.put_line('Az "b" szam a nagyobb!');
    END IF;
END;         