create or replace trigger TArFigy before
   update of ar on termek
   for each row
begin
   if
      :old.ar is not null
      and :old.ar <> 0
   then
      if :new.ar > :old.ar * 1.2 then
         raise_application_error(
            -20001,
            'Nem megengedett mértékű a módosítás: 20%-nál nagyobb áremelés.'
         );
      elsif :new.ar < :old.ar * 0.8 then
         raise_application_error(
            -20002,
            'Nem megengedett mértékű a módosítás: 20%-nál nagyobb árcsökkentés.'
         );
      end if;

   end if;
end;
/