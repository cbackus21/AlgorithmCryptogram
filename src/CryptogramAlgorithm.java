import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CryptogramAlgorithm {
	private String[] inputString;
	private String inputWord1;
	private String inputWord2;
	private Trie currentTrie;
	private ArrayList<String> currentCandidates;
	
	public CryptogramAlgorithm(String s) {
		inputString = s.split(" ");
		inputWord1 = inputString[0];
		inputWord2 = inputString[1];
		this.currentTrie = new Trie();
		this.currentCandidates = new ArrayList<String>();
		
	}
	
	public void makeTrie(File f1) {
		String s;
		try {
			Scanner sc = new Scanner(f1);
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				if (s.length() == inputWord1.length()) {
					currentCandidates.add(s);
					currentTrie.insert(s);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void makeCypher()
	
	
}
