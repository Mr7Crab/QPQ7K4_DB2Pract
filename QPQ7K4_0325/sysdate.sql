DECLARE
    d DATE,
BEGIN
    SELECT sysdate INTO d FORM dual;
    bdms_output.put_line(d);
END;