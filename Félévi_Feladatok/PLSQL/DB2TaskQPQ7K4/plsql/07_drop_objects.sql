begin
   execute immediate 'DROP TRIGGER trg_kolcsonzes_naplo';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TRIGGER trg_kolcsonzes_kontroll';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TRIGGER trg_kolcsonzes_id';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP PACKAGE kolcsonzes_pkg';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP SEQUENCE kolcsonzo_seq';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP SEQUENCE konyv_seq';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP SEQUENCE kolcsonzes_seq';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP SEQUENCE naplo_seq';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TABLE Kolcsonzes_Naplo PURGE';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TABLE Kolcsonzes PURGE';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TABLE Konyv CASCADE CONSTRAINTS PURGE';
exception
   when others then
      null;
end;
/

begin
   execute immediate 'DROP TABLE Kolcsonzo CASCADE CONSTRAINTS PURGE';
exception
   when others then
      null;
end;
/