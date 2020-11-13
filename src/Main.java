import java.io.File;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
	    CryptogramAlgorithm ca;
		File f1 = new File("dictionary.txt");
		//Scanner sc = new Scanner(System.in);
		
		while (true) {
			ca = new CryptogramAlgorithm("vteex");
			ca.makeTrie(f1);
			ca.testValues();
			ca.printResults();
			break;
		}
		//sc.close();
	}
}
