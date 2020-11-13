import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CryptogramAlgorithm {
	private int numDecodings = 0;
	private Trie dictionary;
	private ArrayList<String> inputString;
	private ArrayList<String> currentCandidates;
	private ArrayList<String> results;
	private SimpleCipher cipher;
	
	public CryptogramAlgorithm(String s) {
		dictionary = new Trie();
		inputString = new ArrayList<String>(Arrays.asList(s.split(" ")));
		currentCandidates = new ArrayList<String>();
		results = new ArrayList<String>();
		
	}
	
	public void makeTrie(File f1) {
		String s;
		try {
			Scanner sc = new Scanner(f1);
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				dictionary.insert(s);
				if (s.length() == inputString.get(0).length()) {
					currentCandidates.add(s);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void testValues() {
		for (String testWord : currentCandidates) {
			try {
				String input = inputString.get(0);
				cipher = new SimpleCipher();
				cipher.setCipher(input, testWord);
				input = cipher.decode(input);
				if (dictionary.containsNode(input)) {
					results.add(input);
					numDecodings++;
				}
			}
			catch (ValueAlreadyMappedException e) {
				continue;
			}
			catch (KeyAlreadyMappedException e) {
				continue;
			}
	    }
	}
		
	public void printResults() {
		System.out.println(numDecodings);
		for (String s: results) {
			System.out.println(s);
		}
	}
}
