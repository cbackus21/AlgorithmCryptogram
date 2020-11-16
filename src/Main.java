import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CryptogramAlgorithm ca;
		while (sc.hasNextLine()) {
			ca = new CryptogramAlgorithm(sc.nextLine());
		}
		sc.close();
	}
}

class CryptogramAlgorithm {
	private ArrayList<String> oneLetterWords;
	private ArrayList<String> twoLetterWords;
	private ArrayList<String> threeLetterWords;
	private ArrayList<String> fourLetterWords;
	private ArrayList<String> fiveLetterWords;
	private ArrayList<String> sixLetterWords;
	private ArrayList<String> sevenLetterWords;
	private ArrayList<String> eightLetterWords;
	private ArrayList<ArrayList<String>> dictionary;
	private ArrayList<String> results;
	private int numDecodings = 0;
	
	public CryptogramAlgorithm(String s) {
	    this.oneLetterWords = new ArrayList<String>();
	    this.twoLetterWords = new ArrayList<String>();
	    this.threeLetterWords = new ArrayList<String>();
        this.fourLetterWords = new ArrayList<String>();
        this.fiveLetterWords = new ArrayList<String>();
        this.sixLetterWords = new ArrayList<String>();
        this.sevenLetterWords = new ArrayList<String>();
        this.eightLetterWords = new ArrayList<String>();
        this.dictionary = new ArrayList<ArrayList<String>>();
        this.results = new ArrayList<String>();
		makeDictionary();
		Sentence inputSentence = new Sentence(s, this.dictionary);
		ArrayList<ArrayList<String>> arr = inputSentence.makeSentenceCandidates();
		inputSentence.processSentenceCandidates(arr, inputSentence.getResults(), 0, "");
		lookForResults(inputSentence.getSentence(), inputSentence.getResults());
		printResults();
		
	}
	
	private void lookForResults(String input, ArrayList<String> sentences) {
		for (String s : sentences) {
			SimpleCipher sc = new SimpleCipher();
			if (sc.setCipher(input, s)) {
				results.add(s);
				numDecodings++;
			}
		}
	}
	
	private void makeDictionary() {
		try {
			Scanner sc = new Scanner(new File("dictionary.txt"));
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				switch (s.length()) {
					case 1:
						oneLetterWords.add(s);
						break;
					case 2:
						twoLetterWords.add(s);
						break;
					case 3:
						threeLetterWords.add(s);
						break;
					case 4:
						fourLetterWords.add(s);
						break;
					case 5:
						fiveLetterWords.add(s);
						break;
					case 6:
						sixLetterWords.add(s);
						break;
					case 7:
						sevenLetterWords.add(s);
						break;
					case 8:
						eightLetterWords.add(s);
						break;
					default:
						break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dictionary.add(oneLetterWords);
		dictionary.add(twoLetterWords);
		dictionary.add(threeLetterWords);
		dictionary.add(fourLetterWords);
		dictionary.add(fiveLetterWords);
		dictionary.add(sixLetterWords);
		dictionary.add(sevenLetterWords);
		dictionary.add(eightLetterWords);
	} 
	public void printResults() {
		System.out.println(numDecodings);
		for (String s: results) {
			System.out.println(results);
		}
	}
}
