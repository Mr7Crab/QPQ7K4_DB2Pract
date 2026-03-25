DECLARE
    minimum number := 10;
    maximum number := 100;
    ertek number := 99;
BEGIN
    IF ertek < minimum THEN
        dbms_output.put_line('Tul kicsi!');
    ELSIF maximum < ertek THEN
        dmbs_output.put_line('Tul nagy!');
    ELSE
        dmbs_output.put_line('Beleesik a tartományba!!!');
    END IF
END;