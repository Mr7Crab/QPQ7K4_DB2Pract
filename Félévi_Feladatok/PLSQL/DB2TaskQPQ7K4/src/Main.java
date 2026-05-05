// Itt indul a program, itt van a főmenü.

import java.util.Scanner;
public class Main {
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        KolcsonzoService kolcsonzoService = new KolcsonzoService();
        KonyvService konyvService = new KonyvService();
        KolcsonzesService kolcsonzesService = new KolcsonzesService();

        while (true) { 
            System.out.println("=== Főmenü ===");
            System.out.println("1. Kölcsönzők listázása");
            System.out.println("2. Új kölcsönző hozzáadása");
            System.out.println("3. Kölcsönző módosítása");
            System.out.println("4. Kölcsönző törlése");
            System.out.println("5. Könyvek listázása");
            System.out.println("6. Új könyv felvétele");
            System.out.println("7. Könyv módosítása");
            System.out.println("8. Könyv törlése");
            System.out.println("9. Kölcsönzések listázása");
            System.out.println("10. Új kölcsönzés felvétele");
            System.out.println("11. Könyv keresése cím szerint");
            System.out.println("12. Könyv keresése cím és szerző szerint");
            System.out.println("13. Kölcsönző keresése név szerint");
            System.out.println("14. Kölcsönzés módosítása");
            System.out.println("15. Kölcsönzés törlése");
            System.out.println("16. Kölcsönzések keresése kölcsönző és könyv alapján");
            System.out.println("0. Kilépés");
            System.out.print("Választás: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    kolcsonzoService.listAll();
                    break;
                case 2:
                    kolcsonzoService.insert(sc);
                    break;
                case 3:
                    kolcsonzoService.update(sc);
                    break;
                case 4:
                    kolcsonzoService.delete(sc);
                    break;
                case 5:
                    konyvService.listAll();
                    break;
                case 6:
                    konyvService.insert(sc);
                    break;
                case 7:
                    konyvService.update(sc);
                    break;
                case 8:
                    konyvService.delete(sc);
                    break;
                case 9:
                    kolcsonzesService.listAllJoined();
                    break;
                case 10:
                    kolcsonzesService.insert(sc);
                    break;
                case 11:
                    konyvService.searchByTitle(sc);
                    break;
                case 12:
                    konyvService.searchByTitleAndAuthor(sc);
                    break;
                case 13:
                    kolcsonzoService.searchByName(sc);
                    break;
                case 14:
                    kolcsonzesService.update(sc);
                    break;
                case 15:
                    kolcsonzesService.delete(sc);
                    break;
                case 16:
                    kolcsonzesService.searchJoined(sc);
                    break;
                case 0:
                    System.out.println("Kilépés...");
                    sc.close();
                    return;
                default:
                    System.out.println("Érvénytelen választás, próbáld újra.");
            }
        }
    }
}