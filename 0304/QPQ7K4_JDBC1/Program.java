package QPQ7K4;

public class Program {
	
	public static void main(String[] args)
	{
		ConsoleMethords cm = new ConsoleMethords();
		DbMethods.Register();

		while(true){

			System.out.println("\nAUTÓ ADATBÁZIS ");
			System.out.println("1 - Új rekord beszúrás");
			System.out.println("2 - Ár módosítás rendszám alapján");
			System.out.println("3 - Törlés rendszám alapján");
			System.out.println("4 - Összes adat listázása");
			System.out.println("0 - Kilépés"); 

			int choice = cm.readInt("Választás");

			switch (choice){
				case 1:
					String rendszam = cm.readString("Kérelm a rendszámot:");
					String tipus = cm.readString("Kérelm a tipust:");
					String szin = cm.readString("Kérelm a színt:");
					String kor = cm.readInt("Kérelm a kort:");
					String ar = cm.readInt("Kérelm a tulajdonost:");
					String tulaj = cm.readString("Kérelm a tulajdonost:");
					DbMethods.Insert(rendszam, tipus, szin, kor ,ar ,tulaj);
					break;
				case 2:
					String r2 = cm.readString("Kérem a rendstámot");
					int ujAr = cm.readInt("Kérem az uj árat:");
					DbMethods.DeletData(r3, ujAr);
					break;
				case 3:
					String r3=cm.readString("Kérem a rendszámot: ");
					DbMethods.DeletData(r3);
					break;
				case 4:
					DbMethods.ReadAllData();
					break;
				case 0:
					System.out.println("kilépés...");
					return;
				default:
					System.out.println("Érvénytelen választás!");
					break;
			}
		}

	}
}
