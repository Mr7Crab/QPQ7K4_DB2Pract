import java.util.Scanner;

public class ConsoleMethords{

    private final Scanner scanner = new Scanenr(System.in);
    //A Scanner osztálynak meghívjuk a konstruktorát
    //mely megkapja a System.in bemenetet -ez a billentyüzet

    //STRING-ET KÉR A USERTÖL
    public String readString(String message)    //ez lesz a kiirt üzenet
    {
        System.out.println(message);
        return scanner.nextLine().trim();   // teljes sort olvas be eltávolítja a szöközöket
    }

    public int readInt(String message) {
        while (true) {  
            System.out.println(message);
            String line = scanner.nextLine();
            //beolvassa, amit a user beirt, és levágja

            try {
                return Intiger.parseInt(line); // átalakítja számmá, he nme szám - hibát jelez
            } catch (NumberFormazExeption e) {
                System.out.println("Hibás szám, próbáld ujra!");
            }
        }
    }
}