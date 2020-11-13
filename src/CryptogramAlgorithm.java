import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CryptogramAlgorithm {
	private int numDecodings = 0;
	private Trie currentTrie;
	private ArrayList<String> inputString;
	private ArrayList<String> currentCandidates;
	private Map<String, String> results;
	private SimpleCipher cipher;
	
	public CryptogramAlgorithm(String s) {
		inputString = new ArrayList<String>(s.split(" "));
		Collections.sort()
		this.currentTrie = new Trie();
		
		this.currentCandidates = new ArrayList<String>();
		this.results = new HashMap<String, String>();
		
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
	
	public void testValues() {
		for (String testWord : currentCandidates) {
			try {
				cipher = new SimpleCipher();
				cipher.setCipher(inputWord1, testWord);
				if (currentTrie.containsNode(cipher.decode(inputWord2))) {
					results.put(cipher.decode(inputWord1),cipher.decode(inputWord2));
					numDecodings++;
				}
			}
			catch (ValueAlreadyMappedException e) {
				continue;
			}		
	    }
	}
		
	public void printResults() {
		System.out.println(numDecodings);
		for (Map.Entry<String, String> entry : results.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
