import java.util.ArrayList;

public class CrypticWord {
	private String word;
	private ArrayList<String> wordCandidates;
	
	
	public CrypticWord(String s, ArrayList<String> wordCandidates) {
	    this.wordCandidates = new ArrayList<String>();
		this.word = s;
		for (String word : wordCandidates) {
			SimpleCipher sc = new SimpleCipher();
			if (sc.setCipher(this.word, word)) {
				this.wordCandidates.add(word);
			}
		}
	}
	
	public ArrayList<String> getWordCandidates() {
		return this.wordCandidates;
	}
}
