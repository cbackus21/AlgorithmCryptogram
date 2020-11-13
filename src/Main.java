import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		File f1 = new File("dictionary.txt");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			CryptogramAlgorithm ca = new CryptogramAlgorithm(sc.nextLine());
			ca.makeTrie(f1);
		}
		sc.close();
	}
}
