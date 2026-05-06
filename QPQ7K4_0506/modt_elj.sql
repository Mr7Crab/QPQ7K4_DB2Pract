create or replace procedure modt (
   p_tkod in termek.tkod%type,
   p_ar   in termek.ar%type
) is
begin
   update termek
      set
      ar = p_ar
    where tkod = p_tkod;

   if sql%rowcount = 0 then
      raise_application_error(
         -20001,
         'Nincs ilyen termékkód: ' || p_tkod
      );
   else
      dbms_output.put_line('Ár módosítva. Termekkód:  '
                           || p_tkod
                           || ',  új ára: ' || p_ar);
   end if;
end;
/