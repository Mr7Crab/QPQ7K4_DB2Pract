DECLARE
    a number default 10;
    b number default 20;
    s number;
begin
    s := a*b;
    dbms_output.put_line(TO_CHAR(s));
end;
